package Day13;

public class Gimbap extends Thread {
	private int 김밥_수; 


	
	public Gimbap(int 김밥선택) { //김밥 몇줄인지 선택한 숫자를 인수로 받아 김밥_수에 저장
		김밥_수 = 김밥선택;
	}
	
	@Override
	public void run() {	//객체 김밥_수는 만들어야할 김밥의 수
		while(김밥_수>0) { //다 만들 때까지 김밥_수가 1씩 감소하며 반복
			김밥_수--;
			System.out.println("김밥 "+김밥_수+"줄 남았습니다.");
			try {
				Thread.sleep(1000); //1초 동안 지연
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(김밥_수 ==0) {
				System.out.println("김밥이 모두 완성되었습니다!! 식사 맛있게 하세요!!");
			}	
			
		}
	}
}
