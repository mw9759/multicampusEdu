package polymorphism3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String input= br.readLine();
		
		// Spring 컨테이너를 생성한다.
		GenericXmlApplicationContext container 
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너로부터 사용할 객체를 획득한다.
//		TV tv = (TV) container.getBean(input);
		TV tv = (TV) container.getBean("tv");
		
//		TV tv = new SamsungTV();
//		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// Spring 컨테이너를 종료한다.
		container.close();
	}

}
