package designPattern.creat;

/**
 * 总体来说设计模式分为三大类： 
 * 1、创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
 * 2、结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
 * 3、行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模 式、
 * 		状态模式、访问者模式、中介者模式、解释器模式。
 * 
 * 单例设计模式: 分为懒汉式和饿汉式。
 * 
 * @author Administrator
 *
 */
public class SingletonHungry {

	// 直接创建对象
	public static SingletonHungry instance = new SingletonHungry();

	// 私有化构造函数
	private SingletonHungry() {
	}

	// 返回对象实例
	public static SingletonHungry getInstance() {
		return instance;
	}
}
