package designPattern.creat;

/**
 * 静态工厂方法模式:(又称 简单工厂模式)
 * 		将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 * @author Administrator
 *
 */
public class SendFactoryStatic {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
}
