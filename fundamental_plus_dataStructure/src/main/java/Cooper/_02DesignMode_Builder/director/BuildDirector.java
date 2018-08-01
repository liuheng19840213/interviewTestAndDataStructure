package Cooper._02DesignMode_Builder.director;

import Cooper._02DesignMode_Builder.AbstractBuilder.ICarBuilder;
import Cooper._02DesignMode_Builder.Product.Car;

public class BuildDirector {
    //only a directing method
    public Car constructCar(ICarBuilder builder)
    {
        builder.buildEngine();
        builder.buildSkeleton();
        builder.buildWheel();
        return builder.buildCar();
    }
}
