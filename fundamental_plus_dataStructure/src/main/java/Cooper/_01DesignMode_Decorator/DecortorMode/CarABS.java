package Cooper._01DesignMode_Decorator.DecortorMode;

public class CarABS extends CarDecorator{

	public CarABS(ICarShowable myCar) {
		super(myCar);
	}
	
	public void show(){
		super.show();
		System.out.println("abs added");
	}
	
}


