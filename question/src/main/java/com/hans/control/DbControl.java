package com.hans.control;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hans.model.Dan;
import com.hans.model.Duo;
import com.hans.model.Pan;
import com.hans.service.TestService;

public class DbControl {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.out.println(LocalTime.now());
		//ApplicationContext context = new ClassPathXmlApplicationContext(
				//"a-servlet.xml");
		//TestService ts = context.getBean("testService", TestService.class);
		//addDan(ts);	
		//addPan(ts);
		//addDuo(ts);
	}
	private static void addDuo(TestService ts) throws Exception {
		Path p = Paths.get("C:\\code\\c.txt");
		List<String> list = Files.readAllLines(p, StandardCharsets.UTF_8);
		for (int i = 0; list.size() > i; i = i + 6) {
			System.out.println(i);
			Duo duo = new Duo();
			duo.setId(i / 6);
			duo.setQuestion(list.get(i + 0));
			duo.setA(list.get(i + 1));
			duo.setB(list.get(i + 2));
			duo.setC(list.get(i + 3));
			duo.setD(list.get(i + 4));
			duo.setAnswer(list.get(i + 5));
			ts.addDuo(duo);
		}
		
	}
	@SuppressWarnings("unused")
	private static void addPan(TestService ts) throws Exception {
		Path p = Paths.get("C:\\code\\b.txt");
		List<String> list = Files.readAllLines(p, StandardCharsets.UTF_8);
		for (int i = 0; list.size() > i; i = i + 2) {
			System.out.println(i);
			Pan pan = new Pan();
			pan.setId(i / 2);
			pan.setQuestion(list.get(i + 0));
			pan.setAnswer(list.get(i + 1));
			ts.addPan(pan);
		}
		
	}

	@SuppressWarnings("unused")
	private static void addDan(TestService ts) throws Exception {
		Path p = Paths.get("C:\\code\\a.txt");
		List<String> list = Files.readAllLines(p, StandardCharsets.UTF_8);
		for (int i = 0; list.size() > i; i = i + 6) {
			System.out.println(i);
			Dan dan = new Dan();
			dan.setId(i / 6);
			dan.setQuestion(list.get(i + 0));
			dan.setA(list.get(i + 1));
			dan.setB(list.get(i + 2));
			dan.setC(list.get(i + 3));
			
			String s = list.get(i + 4);
			if (!s.equals("null")) {
				dan.setD(s);
			}
			dan.setAnswer(list.get(i + 5));
			ts.addDan(dan);
		}
		
	}
}
