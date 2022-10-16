/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: lab4-db
 * Package: com.rostyslav.service.impl
 * Class: DriverServiceImpl
 */

package com.rostyk.service.impl;

import com.rostyk.dao.DriverDao;
import com.rostyk.domain.Car;
import com.rostyk.domain.Driver;
import com.rostyk.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverDao driverDao;

    public DriverServiceImpl(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    @Override
    public List<Driver> findAll() {
        return driverDao.findAll();
    }

    @Override
    public Optional<Driver> findById(Integer id) {
        return driverDao.findById(id);
    }

    @Override
    public int create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public int update(Integer id, Driver driver) {
        return driverDao.update(id, driver);
    }

    @Override
    public int delete(Integer id) {
        return driverDao.delete(id);
    }

    @Override
    public List<Car> findAllCarsBy(Integer id) {
        return driverDao.findAllCarsBy(id);
    }

    @Override
    public String addCarByBrandToDriverByName(String brand, String name) {
        return driverDao.addCarByBrandToDriverByName(brand, name);
    }
}
