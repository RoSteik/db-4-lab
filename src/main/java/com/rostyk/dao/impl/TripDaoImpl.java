/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: db-4
 * Package: com.rostyk.dao.impl
 * Class: TripDaoImpl
 */

package com.rostyk.dao.impl;

import com.rostyk.dao.TripDao;
import com.rostyk.domain.Driver;
import com.rostyk.domain.Trip;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TripDaoImpl implements TripDao {
    private static final String FIND_ALL = "SELECT * FROM trip";
    private static final String CREATE = "INSERT trip(start_point, end_point, driver_id, user_name) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE trip SET start_point=?, end_point=?, driver_id=?, user_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM trip WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM trip WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    public TripDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Trip> findAll() {
        return jdbcTemplate.query(FIND_ALL,
                BeanPropertyRowMapper.newInstance(Trip.class));
    }

    @Override
    public Optional<Trip> findById(Integer id) {
        Optional<Trip> trip;
        try {
            trip = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Trip.class), id));
        } catch (EmptyResultDataAccessException e) {
            trip = Optional.empty();
        }
        return trip;
    }

    @Override
    public int create(Trip trip) {
        return jdbcTemplate.update(CREATE,
                trip.getStartPoint(), trip.getEndPoint(),
                trip.getDriverId(), trip.getUserName());
    }

    @Override
    public int update(Integer id, Trip trip) {
        return jdbcTemplate.update(UPDATE,
                trip.getStartPoint(), trip.getEndPoint(),
                trip.getDriverId(), trip.getUserName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
