package Day13;

public class Fry extends Thread {

	private int 튀김개수;
	
	public Fry(int 튀김선택) { //튀김선택 숫자를 인수로 받아서 튀김개수에 저장
		튀김개수 = 튀김선택;
	}

	@Override
	public void run() {
		while(튀김개수>0) { //튀김개수는 만들어야할 튀김의 개수
			튀김개수--;	//다 만들 (남지 않을) 때까지 튀김개수를 1씩 감소하면서 반복
			System.out.println("튀김 " + 튀김개수 + "개 남았습니다.");
			try {
				Thread.sleep(1000); //1초 동안 지연
			}catch(Exception e) {
				e.getMessage();
			}
			if(튀김개수 == 0) { //튀김을 다만들면 
				System.out.println("튀김이 모두 완성되었습니다!! 식사 맛있게 하세요!!");
			}
		}
	}
}
