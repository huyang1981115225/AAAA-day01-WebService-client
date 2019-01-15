package cn.tedu.client;

import cn.tedu.ws.HelloWSImpl;
import cn.tedu.ws.HelloWSImplService;

/**
 * 调用WebService
 * 
 * @author HY
 *
 */
public class ClientTest {
	public static void main(String[] args) {
		
		HelloWSImplService factory = new HelloWSImplService();
		HelloWSImpl helloWS = factory.getHelloWSImplPort();
		
		System.out.println(helloWS);
		System.out.println(helloWS.getClass());
		
		System.out.println("下面开始调用...");
		String name = "Tom";
		String result = helloWS.sayHello(name);
		System.out.println(result);
		
		Integer age = 18;
		result = helloWS.introduce(name, age);
		System.out.println(result);
	}
}
