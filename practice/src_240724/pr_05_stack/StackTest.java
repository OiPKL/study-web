package pr_05_stack;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		
		// Stack
		// 특징 : LIFO (Last In First Out)
		//     : Stack 단일 클래스 사용 (인터페이스X)
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.add(3);
		
		System.out.println("******************** 추가 ********************");
		System.out.println(stack);
		
		System.out.println("******************** 조회 ********************");
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
		System.out.println("***************** 조회 & 삭제 *****************");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
			System.out.println(stack);
		}
		
	}
}
