/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: lab4-db
 * Package: com.rostyslav.service.impl
 * Class: CarServiceImpl
 */

package com.rostyk.service.impl;

import com.rostyk.dao.CarDao;
import com.rostyk.domain.Car;
import com.rostyk.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Optional<Car> findById(Integer id) {
        return carDao.findById(id);
    }

    @Override
    public int create(Car car) {
        return carDao.create(car);
    }

    @Override
    public int update(Integer id, Car car) {
        return carDao.update(id, car);
    }

    @Override
    public int delete(Integer id) {
        return carDao.delete(id);
    }

    @Override
    public Optional<Car> findByCarBrand(String brand) {
        return carDao.findByCarBrand(brand);
    }

    @Override
    public Optional<Car> findByCarClas(String clas) {
        return carDao.findByCarClas(clas);
    }
}
