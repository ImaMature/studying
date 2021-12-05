package 알고리즘입문;

public class 제네릭클래스테스트 {

	//제네릭 클래스의 매개변수(파라미터)를 T라고 선언
	static class GenericClass<T> {
		private T xyz;
		public GenericClass(T t) {
			this.xyz = t;
		}
		public T getXyz() { //xyz반환하는 getter
			return xyz;
		}
		
	}
	public static void main(String[] args) {
		
		//다음 처럼 파라미터(매개변수)에 String을 넘길 수도 있고 Integer를 넘길 수도 있다.
		GenericClass<String> s = new GenericClass<String>("ABC"); //t에 넘겨진다. this에 저장 xyz가 ABC가 된다.
		GenericClass<Integer> n = new GenericClass<Integer>(15); // 마찬가지
		System.out.println(s.getXyz());
		System.out.println(n.getXyz());
	}
}
