/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: lab4-db
 * Package name: com.rostyslav.dao
 * Interface: CarDao
 */

package com.rostyk.dao;

import com.rostyk.domain.Car;

import java.util.Optional;

public interface CarDao extends GeneralDao<Car, Integer> {
    Optional<Car> findByCarBrand(String brand);

    Optional<Car> findByCarClas(String clas);
}
