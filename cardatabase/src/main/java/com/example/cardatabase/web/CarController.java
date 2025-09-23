package com.example.cardatabase.web;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository carrepository;

    public CarController(CarRepository carrepository) {
        this.carrepository = carrepository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        return carrepository.findAll();
    }
}
