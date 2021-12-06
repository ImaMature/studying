package 검색;




public class Idtester {

	
	public static void main(String[] args) {
		Id a = new Id();
		Id b = new Id();
		
		System.out.println("a아이디 : " + a.getId());
		System.out.println("b아이디 : " + b.getId());
		
		System.out.println("부여한 아이디 개수 : " + Id.getCounter() );

		
	}
	
}
