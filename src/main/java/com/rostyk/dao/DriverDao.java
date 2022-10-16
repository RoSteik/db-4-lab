/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: lab4-db
 * Package name: com.rostyslav.dao
 * Interface: DriverDao
 */

package com.rostyk.dao;


import com.rostyk.domain.Car;
import com.rostyk.domain.Driver;

import java.util.List;

public interface DriverDao extends GeneralDao<Driver, Integer> {
    List<Car> findAllCarsBy(Integer id);

    String addCarByBrandToDriverByName(String brand, String name);
}
