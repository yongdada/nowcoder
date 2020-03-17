package designPattern.structure;

public class Source implements Sourceable{

	public void method1(){
		System.out.println("this is original method!");
	}

	@Override
	public void method() {
		System.out.println("the original method!");
	}
}
