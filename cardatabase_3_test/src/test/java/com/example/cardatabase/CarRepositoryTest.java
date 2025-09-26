package com.example.cardatabase;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;
import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.OwnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    @DisplayName("차량 저장 메서드 테스트")
    void saveCar() {
        // given - 제반 준비 사항
        // Car Entity를 확인해봤을 때 field로 Owner를 요구하기 때문에
        // 얘부터 먼저 만들고 -> ownerRepository에 저장
        Owner owner = new Owner("Gemini", "GPT");
        ownerRepository.save(owner);
        // 그리고 Car 객체 만들거임
        Car car = new Car("Ford", "Mustang", "Red", "ABCDEF", 2021, 567890, owner);
        // when - 테스트 실행
        // 저장이 됐는지 확인하기 위한 부분
        carRepository.save(car);
        // then - 그 결과가 어떠할지
        assertThat(carRepository.findById(car.getId())).isPresent();        // 이건 그냥 결과값이 하나일테니까.

        assertThat(carRepository.findById(car.getId()).get().getBrand()).isEqualTo("Ford");
    }

    @Test
    @DisplayName("삭제 확인 테스트")
    void delCar() {
        // given - Owner 객체 생성 / 저장 -> Car 객체 생성 / 저장
        Owner owner = new Owner("동차", "자");
        ownerRepository.save(owner);
        Car car = new Car("GENESIS", "g", "black", "126", 2017, 20000000, owner);
        carRepository.save(car);
        // when 삭제
//        carRepository.findById(car.getId());
        carRepository.deleteAll();
        assertThat(carRepository.count()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 조회")
    void findByBrandShouldReturnCar() {
        Owner owner = new Owner("Gemini", "GPT");
        ownerRepository.save(owner);
        carRepository.save(new Car("Ford", "Mustang", "Red", "ABCDEF", 2021, 567890, owner));
        carRepository.save(new Car("GENESIS", "G80", "black", "126", 2017, 20000000, owner));
        carRepository.save(new Car("Ford", "Mustang", "blue", "1234", 2020, 567890, owner));
        carRepository.save(new Car("HYUNDAI", "SONATA", "WHITE", "1232", 2022, 567890, owner));

        List<Car> fordCars = carRepository.findByBrand("Ford");
        assertThat(fordCars.get(0).getBrand()).isEqualTo("Ford");
        assertThat(fordCars.size()).isEqualTo(2);
    }
}
