package com.example.cardatabase4.service;

import com.example.cardatabase4.domain.Car;
import com.example.cardatabase4.domain.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    // 모든 자동차 목록 조회한다 가정함.
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    // 2. 새로운 자동차 저장
    public Car addCar(Car car) {
        return carRepository.save(car);
    }
    // 3. 차량 한 대 조회
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // 4. 차량 한대 삭제
    public boolean deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
    // 5. 차량 수정
    @Transactional
    public Optional<Car> updateCar(Long id, Car carDetails) {
        return carRepository.findById(id)
                .map(car -> {
                    car.setBrand(carDetails.getBrand());
                    car.setModel(carDetails.getModel());
                    car.setColor(carDetails.getColor());
                    car.setModelYear(carDetails.getModelYear());
                    car.setRegistrationNumber(carDetails.getRegistrationNumber());
                    car.setPrice(carDetails.getPrice());
                    return car;
                    // carRepository.save(car); 가 아님.
                    // @Transactional에 의해 변경이 감지되어 자동으로 DB 업뎃이 이뤄짐

                });
    }
}
