package com.ssafy.mvc.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Satto {
	private ArrayList<Integer> nums = new ArrayList<>();

	public Satto() {
		while (this.nums.size() < 6) {
			int nextNum = new Random().nextInt(45) + 1;

			if (!this.nums.contains(nextNum)) {
				this.nums.add(nextNum);
			}
		}
	}

	public Satto(Collection<Integer> nums) {
		for (Integer num : nums) {
			if (num != null) {
				this.nums.add(num);
			}
		}
		while (this.nums.size() < 6) {
			int nextNum = new Random().nextInt(45) + 1;

			if (!this.nums.contains(nextNum)) {
				this.nums.add(nextNum);
			}
		}
	}

	public ArrayList<Integer> getNums() {
		return nums;
	}

	public void setNums(ArrayList<Integer> nums) {
		this.nums = nums;
	}

	public boolean isValid() {
		return nums.size() == 6;
	}

	public int compare(Satto o) {
		int res = 0;
		for (int num : nums) {
			if (o.nums.contains(num)) {
				res++;
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return nums.toString();
	}

}
