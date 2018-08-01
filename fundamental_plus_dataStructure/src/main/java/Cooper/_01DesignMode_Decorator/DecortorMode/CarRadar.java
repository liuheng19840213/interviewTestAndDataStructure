package Cooper._01DesignMode_Decorator.DecortorMode;

public class CarRadar extends CarDecorator{
	public CarRadar(ICarShowable myCar) {
		super(myCar);
	}

	public void show() {
		super.show();
		System.out.println("radar added");
	}
}
