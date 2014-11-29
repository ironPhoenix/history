package com.hans.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInt {
	public static List<Integer> getRandomIntList(int size, int min, int max) {
		if (size > max + 1 - min) {
			throw new RuntimeException();
		}
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		while (list.size() < size) {
			int i = random.nextInt(max + 1 - min) + min;
			if (!list.contains(i)) {
				list.add(i);
			}
		}
		return list;
	}

/*	public static void main(String[] args) {
		String username = "滕瀚斯";
		String phoneNumber = "13159876789";
		System.out.println(username.matches(".{2,4}"));
		System.out.println(phoneNumber.matches("1\\d{10}"));
		if (!username.matches(".{2,4}") || !phoneNumber.matches("1\\d{10}")) {
			System.out.println("error");
		} else {
			System.out.println("success");
		}
	}*/
}
