package com.ssafy.ws.step3.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
	String name;
	int height;
	
	public Person(String name, int height) {
		this.name = name;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + "]";
	}
	
}

// Comparator는 인터페이스로 반드시 구현 필요
// Comparator는 Comparable과 다르게 2개의 객체를 compare 메소드를 통해 비교
public class CompatatorTest {
	
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
		
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				return Integer.compare(p1.height, p2.height);
			}
		});
		
		System.out.println("**************** 정렬 후 ****************");
		for(Person p : personList) {
			System.out.println(p);
		}
	}
}
