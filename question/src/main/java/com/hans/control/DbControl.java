package com.hans.control;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hans.model.Dan;
import com.hans.service.TestService;

public class DbControl {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"a-servlet.xml");
		TestService ts = context.getBean("testService", TestService.class);
		addDan(ts);	
	}

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
