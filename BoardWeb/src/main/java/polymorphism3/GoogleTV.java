package polymorphism3;

public class GoogleTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public GoogleTV() {
		System.out.println("==> GoogleTV(1) 생성");
	}
	
	public GoogleTV(Speaker speaker) {
		System.out.println("==> GoogleTV(2) 생성");
		this.speaker = speaker;
	}

	public GoogleTV(Speaker speaker, int price) {
		System.out.println("==> GoogleTV(3) 생성");
		this.speaker = speaker;
		this.price = price;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("GoogleTV --- 전원 켠다" + price);
	}
	
	@Override
	public void powerOff() {
		System.out.println("GoogleTV --- 전원 끈다");
	}
	
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
