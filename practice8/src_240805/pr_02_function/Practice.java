package pr_02_function;

public class Practice {

	public static void main(String[] args) {
		System.out.println("1 main 호출");
		func1();
		System.out.println("2 main 종료");
	}
	
	public static void func1() {
		System.out.println("3 func1 호출");
		String name = "Kim";
		System.out.println(name);
		func2();
		System.out.println("4 func1 종료");
	}
	
	public static void func2() {
		System.out.println("5 func2 호출");
		String name = "Park";
		System.out.println(name);
		func3();
		System.out.println("6 func2 종료");
	}
	
	public static void func3() {
		System.out.println("7 func3 호출");
		System.out.println("8 func3 종료");
	}
	
	// >> 1 3 5 7   8 6 4 2
	
}