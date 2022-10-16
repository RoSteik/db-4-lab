/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: db-4
 * Package: com.rostyk.controller.impl
 * Class: TripControllerImpl
 */

package com.rostyk.controller.impl;

import com.rostyk.controller.TripController;
import com.rostyk.domain.Trip;
import com.rostyk.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripControllerImpl implements TripController {
    private final TripService tripService;

    public TripControllerImpl(TripService tripService) {
        this.tripService = tripService;
    }

    @Override
    public List<Trip> findAll() {
        return tripService.findAll();
    }

    @Override
    public Optional<Trip> findById(Integer id) {
        return tripService.findById(id);
    }

    @Override
    public int create(Trip trip) {
        return tripService.create(trip);
    }

    @Override
    public int update(Integer id, Trip trip) {
        return tripService.update(id, trip);
    }

    @Override
    public int delete(Integer id) {
        return tripService.delete(id);
    }
}
