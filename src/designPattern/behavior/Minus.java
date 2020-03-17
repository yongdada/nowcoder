package designPattern.behavior;

public class Minus extends AbstreactCalculation implements ICalculator{

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "-");
		return arrayInt[0] - arrayInt[1];
	}

}
