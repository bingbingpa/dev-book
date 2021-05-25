package com.bingbingpa.ch11;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OptionalMain {

    public String getCarInsuranceNameNullSafeV1(PersonV1 person) {
        if (person != null) {
            CarV1 car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    public String getCarInsuranceNameNullSafeV2(PersonV1 person) {
        if (person == null) {
            return "Unknown";
        }
        CarV1 car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> personList) {
        return personList.stream()
                .map(Person::getCar)
                .map(optionalCar -> optionalCar.flatMap(Car::getInsurance))
                .map(optionalInsurance -> optionalInsurance.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        Insurance cheapestCompany = new Insurance();
        return cheapestCompany;
    }

    public Optional<Insurance> nullSafeFindCheapestInsuranceQuiz(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
