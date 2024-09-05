package baekjoon;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		List<Integer> hhh = new ArrayList<>();
		hhh.add(0);
		hhh.add(0);
		hhh.add(0);
		hhh.add(0);
		
		hhh.set(hhh.size() - 1, hhh.get(hhh.size() - 1) + 3);
		
		for (int h : hhh)
			System.out.print(h + " ");
		System.out.println();
		
	}
}