package polymorphism3;

public class SamsungTV implements TV {
	private int price;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV 생성");
	}

	public void 멤버변수초기화() {
		System.out.println("===> 멤버변수초기화()");
		price = 1900000;
	}
	
	public void 자원해제() {
		price = 0;
		System.out.println("===> 자원해제()"+price);
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다" + price);
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV --- 소리 올린다");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV --- 소리 내린다");
	}
	
}
