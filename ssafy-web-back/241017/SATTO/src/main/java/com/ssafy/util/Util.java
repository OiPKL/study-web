package com.ssafy.util;

import java.util.List;

import com.ssafy.mvc.dto.Message;

public class Util {
	private static Util instance = new Util();
	
	private Util() {
	}

	public static Util getInstance() {
		return instance;
	}
	
	public Message validCheck(String type, List<Integer> list) {
		boolean[] check = new boolean[46];
		if (type.equals("hand")) {
			for (Integer num : list) {
				if (num == null) {
					return new Message("error", "6개의 숫자를 모두 입력해주세요");
				}

				if (num < 0 || num > 45) {
					return new Message("error", "1~45사이의 숫자를 입력해주세요");
				}

				if (check[num]) {
					return new Message("error", "중복되지 않는 숫자를 입력해주세요");
				}
				check[num] = true;
			}
		}

		if (type.equals("auto")) {
			for (Integer num : list) {
				if (num == null) {
					continue;
				}

				if (num < 0 || num > 45) {
					return new Message("error", "1~45사이의 숫자를 입력해주세요");
				}

				if (check[num]) {
					return new Message("error", "중복되지 않는 숫자를 입력해주세요");
				}
				check[num] = true;
			}
		}

		return new Message("ok", "정상 입력입니다");
	}
}
