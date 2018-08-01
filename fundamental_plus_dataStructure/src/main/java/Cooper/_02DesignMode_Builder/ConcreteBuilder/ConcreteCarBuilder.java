package Cooper._02DesignMode_Builder.ConcreteBuilder;

import Cooper._02DesignMode_Builder.AbstractBuilder.ICarBuilder;
import Cooper._02DesignMode_Builder.Product.Car;

public class ConcreteCarBuilder implements ICarBuilder{

    private Car car;

    public ConcreteCarBuilder(Car car) {
        this.car = car;
    }

    public ConcreteCarBuilder() {
    }

    @Override
    public void buildWheel() {
        car.setWheel("轮子");
    }

    @Override
    public void buildSkeleton() {
        car.setSkeleton("车身结构");
    }

    @Override
    public void buildEngine() {
        car.setEngine("发动机");
    }

    @Override
    public Car buildCar() {
        return this.car;
    }
}
