package Day14;

class RamenCook extends Thread implements Runnable //쓰레드 상속에 Runnable 인터페이스 선언 //run으로 실행
{
	private int ramenCount;
	private String[] burners = {"_","_","_","_"};
	
	public RamenCook(int count) //RamenProgram클래스에서 num을 인수로 전달받음.
	{
		ramenCount = count; //ramenCount에 저장
	}
	
	@Override
	public void run()
	{
		while(ramenCount > 0) //라면개수가 0이거나 0보다 낮으면 실행X
		{
			synchronized(this) // 한번에 하나의 스레드만 실행 가능 //멀티스레드가 순서대로 실행되도록 하는 것
			{
				ramenCount--; // 라면 개수 줄이기
				System.out.println(Thread.currentThread().getName() + " : " + ramenCount + "개 남았습니다");
				//현재 쓰레드의 이름 + 남은 라면 개수 표시
			}
			
			for(int i = 0; i < burners.length; i++) // burners 배열의 길이만큼 반복
			{
				if(!burners[i].equals("_")) // i번째가 비어있지 않다면
				{
					continue; //계속하기
				}
				
				synchronized(this) 
				{
					//버너가 켜졌을 때 배열에 해당하는 이름을 추가하는 쓰레드
						burners[i] = Thread.currentThread().getName(); //배열의 i번째에 현재 쓰레드의 이름 저장
						System.out.println("                 " + Thread.currentThread().getName() + " : [" + (i + 1) + "]번 버너 ON");
																						//인덱스는 0부터 시작해서  +1 했습니다.
						showBurners();
						//메소드 호출
					
				}
				
				try
				{
					Thread.sleep(2000);	//2초간 일시정지
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				synchronized(this)
				{
					//버너를 끈 상태로 보이게 하는 쓰레드 // 순서는 무작위
					burners[i] = "_";
					System.out.println("                                  " + Thread.currentThread().getName() + " : [" + (i + 1) + "]번 버너 OFF" );
					showBurners();
				}
				break;
			}
			
			try
			{
				Thread.sleep(Math.round(1000 * Math.random()));
				//지연되는 시간을 0~1초 사이로 무작위로 지정하기 
				//Math.round = 소수점 이하 반올림
				//1000*Math.random() = (최댓값 0 ~ 1초)
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//버너 배열의 상태를 보여주는 메소드
	private void showBurners()
	{
		String stringToPrint = "                                                             "; // 구별하기 위해 긴 공백 저장
		for(int i = 0; i < burners.length; i++) // burners 배열의 길이 만큼 반복
		{
			stringToPrint += (" " + burners[i]); // 배열의 i번째 상태 값 String화해서 stringToPrint에 더해서 저장
		}
		System.out.println(stringToPrint); 
	}


}