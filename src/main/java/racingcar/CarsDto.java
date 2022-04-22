package racingcar;

import java.util.List;

public class CarsDto {
    List<CarDto> cars;

    public CarsDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
