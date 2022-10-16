/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: db-4
 * Package: com.rostyk.service.impl
 * Class: TripServiceImpl
 */

package com.rostyk.service.impl;

import com.rostyk.dao.TripDao;
import com.rostyk.domain.Trip;
import com.rostyk.service.TripService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

    private final TripDao tripDao;

    public TripServiceImpl(TripDao tripDao) {
        this.tripDao = tripDao;
    }

    @Override
    public List<Trip> findAll() {
        return tripDao.findAll();
    }

    @Override
    public Optional<Trip> findById(Integer id) {
        return tripDao.findById(id);
    }

    @Override
    public int create(Trip trip) {
        return tripDao.create(trip);
    }

    @Override
    public int update(Integer id, Trip trip) {
        return tripDao.update(id, trip);
    }

    @Override
    public int delete(Integer id) {
        return tripDao.delete(id);
    }
}
