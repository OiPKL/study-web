package swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static int checkBracket(Stack<Character> stack, char bracket) {
        if (bracket == '(' || bracket == '{' || bracket == '[' || bracket == '<') {
            stack.push(bracket);
            return 1;
        }
        
        if (stack.isEmpty()) return 0;
        
        char top = stack.pop();
        if ((bracket == ')' && top != '(') ||
            (bracket == '}' && top != '{') ||
            (bracket == ']' && top != '[') ||
            (bracket == '>' && top != '<')) {
            return 0;
        }
        
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int t = 1; t <= 10; t++) {
            int isValid = 1;
            int N = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            char[] charArr = str.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : charArr) {
                isValid = checkBracket(stack, c);
                if (isValid == 0) break;
            }

            if (!stack.isEmpty()) isValid = 0;

            System.out.println("#" + t + " " + isValid);
        }
        
        sc.close();
    }
}

//public class Solution {
//
//	public static int checkBracket(Stack<Character> stack, char bracket) {
//		
//		switch (bracket) {
//			case '(': 	stack.push(bracket);
//													return 1;
//			case ')': 	if (stack.pop() == '(') {	return 1;
//						} else 						return 0;
//			case '{': 	stack.push(bracket);
//													return 1;
//			case '}': 	if (stack.pop() == '{') {	return 1;
//						} else 						return 0;
//			case '[': 	stack.push(bracket);
//													return 1;
//			case ']': 	if (stack.pop() == '[') {	return 1;
//						} else 						return 0;
//			case '<': 	stack.push(bracket);
//													return 1;
//			case '>': 	if (stack.pop() == '<') {	return 1;
//						} else 						return 0;
//			default : 								return 1;
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		Stack<Character> stack = new Stack<>();
//		
//		for (int t = 1; t <= 10; t++) {
//			
//			int isValid = 1;
//			int N = sc.nextInt();
//			sc.nextLine();
//			String str = sc.nextLine();
//			char[] charArr = str.toCharArray();
//			
////			for (char arr : charArr)
////				System.out.print(arr + " ");
//
//			int n = 0;
//			while (isValid == 1) {
//				if (stack.size() == 0 && charArr[n] == ')') {
//					isValid = 0;
//					break;
//				}
//				else if (stack.size() == 0 && charArr[n] == '}') {
//					isValid = 0;
//					break;
//				}
//				else if (stack.size() == 0 && charArr[n] == ']') {
//					isValid = 0;
//					break;
//				}
//				else if (stack.size() == 0 && charArr[n] == '>') {
//					isValid = 0;
//					break;
//				}
//				isValid = checkBracket(stack, charArr[n++]);
//			}
//			if (stack.size() > 0) isValid = 0;
//			System.out.println("#" + t + " " + isValid);
//
//		}
//			
//	}
//}