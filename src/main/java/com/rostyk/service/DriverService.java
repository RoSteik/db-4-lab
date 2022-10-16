/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: lab4-db
 * Package name: com.rostyslav.service
 * Interface: DriverService
 */

package com.rostyk.service;


import com.rostyk.domain.Car;
import com.rostyk.domain.Driver;

import java.util.List;

public interface DriverService extends GeneralService<Driver, Integer> {
    List<Car> findAllCarsBy(Integer id);

    String addCarByBrandToDriverByName(String brand, String name);
}
