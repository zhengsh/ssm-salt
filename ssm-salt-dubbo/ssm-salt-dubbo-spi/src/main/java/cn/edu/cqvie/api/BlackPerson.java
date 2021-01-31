package cn.edu.cqvie.api;

public class BlackPerson implements Person {

    private Car car;

    @Override
    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
