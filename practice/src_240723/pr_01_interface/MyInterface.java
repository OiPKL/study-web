package pr_01_interface;

public interface MyInterface {

	void method1();
	
	public abstract void method2();
	
	default void method3() {
		System.out.println("default method!");
	}
	
	static void method4() {
		System.out.println("interface static method!");
	}
	
}
