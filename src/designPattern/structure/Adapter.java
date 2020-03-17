package designPattern.structure;

/**
 * 类的适配器模式
 * @author Administrator
 *
 */
public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

}
