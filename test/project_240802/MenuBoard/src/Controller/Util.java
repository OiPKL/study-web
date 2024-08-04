package Controller;

import java.util.Scanner;

public class Util {
	
    private static Scanner sc = new Scanner(System.in);

    private Util() {}

    public static String input(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public static int inputInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public static void printLine() {
        System.out.println("------------------------------------------------------");
    }

    public static void printLine(char ch) {
        for (int i = 0; i < 40; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void printLine(char ch, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void screenClear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    

    
}
















