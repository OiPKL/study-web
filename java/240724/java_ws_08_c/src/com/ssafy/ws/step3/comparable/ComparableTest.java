package com.ssafy.ws.step3.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
	String name;
	int height;
	
	public Person(String name, int height) {
		this.name = name;
		this.height = height;
	}
	
	@Override
	public int compareTo(Person anotherPerson) {
		
		int result1 = this.height - anotherPerson.height;
		int result2 = this.name.compareTo(anotherPerson.name);
		
		if(result1 > 0) return 1;
		else if (result1 < 0) return -1;
//		return 0;
		// 1. height 비교 ~ 2. name 비교
		else {
			return result2 * 1; 	// 오름차순
//			return result2 * -1;	// 내림차순
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + "]";
	}
	
}

// Comparable은 인터페이스로 반드시 구현 필요
// Comparable은 클래스 자체가 하나의 비교 대상이며
// compareTo() 메소드에 다른 비교 대상을 전달받아 비교
public class ComparableTest {
	
	public static void main(String[] args) {
		
		List<Person> personList = new ArrayList<>();
		
		personList.add(new Person("마누엘 노이어", 193));
		personList.add(new Person("해리 케인", 188));
		personList.add(new Person("우파메카노", 186));
		personList.add(new Person("김민재", 188));
		
		System.out.println("**************** 정렬 전 ****************");
		for(Person p : personList) {
			System.out.println(p);
		}
		
		Collections.sort(personList);
		
		System.out.println("**************** 정렬 후 ****************");
		for(Person p : personList) {
			System.out.println(p);
		}
		
	}
}
