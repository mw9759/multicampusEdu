package polymorphism3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	// Speaker 타입이 객체를 메모리에서 찾아 객체의 주소를 speaker 변수에 할당한다.
	@Autowired // Type Injection
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("==> LgTV 생성");
		
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTV --- 전원 켠다");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTV --- 전원 끈다");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		speaker.volumeDown();
	}
	
}
