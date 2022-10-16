/**
 * Created by RoSteik (Telegram: @RoSteik)
 * Project name: lab4-db
 * Package name: com.rostyslav.service
 * Interface: CarService
 */

package com.rostyk.service;

import com.rostyk.domain.Car;

import java.util.Optional;

public interface CarService extends GeneralService<Car, Integer> {
    Optional<Car> findByCarBrand(String brand);

    Optional<Car> findByCarClas(String clas);
}
