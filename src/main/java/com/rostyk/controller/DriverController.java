/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: lab4-db
 * Package name: com.rostyslav.controller
 * Interface: DriverController
 */

package com.rostyk.controller;

import com.rostyk.domain.Car;
import com.rostyk.domain.Driver;

import java.util.List;

public interface DriverController extends GeneralController<Driver, Integer> {
    List<Car> findAllCarsBy(Integer id);

    String addCarByBrandToDriverByName(String brand, String name);
}
