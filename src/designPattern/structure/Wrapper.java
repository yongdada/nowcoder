package designPattern.structure;

/**
 * 对象的适配器模式
 *	基本思路和类的适配器模式相同，只是将 Adapter 类作修改，这次不继承 Source 类，
 *	而是持有 Source 类的实例，以达到解决兼容性的问题。
 *	Wrapper: 包装纸（名词）
 * @author Administrator
 *
 */
public class Wrapper implements Targetable{

	private Source source ;
	
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

}
