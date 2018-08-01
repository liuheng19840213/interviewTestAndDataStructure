package Cooper._02DesignMode_Builder.AbstractBuilder;

import Cooper._02DesignMode_Builder.Product.Car;

public interface ICarBuilder {
    void buildWheel();
    void buildSkeleton();
    void buildEngine();

    Car buildCar();
}
