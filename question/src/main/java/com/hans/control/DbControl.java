package com.hans.control;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hans.model.User;
import com.hans.service.TestService;

public class DbControl {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
/*		for(int i=0;i<25;i++) {
			System.out.println("if (testService.getDanResultById(danInt.get("+i+")).equals(dan"+i+")) score = score + 2;");
		}
		for(int i=0;i<10;i++) {
			System.out.println("if (testService.getPanResultById(panInt.get("+i+")).equals(pan"+i+")) score = score + 2;");
		}
		for(int i=0;i<10;i++) {
			System.out.println("if (testService.getDuoResultById(duoInt.get("+i+")).equals(duo"+i+")) score = score + 3;");
		}*/
		
		//System.out.println(LocalTime.now());
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"a-servlet.xml");
		TestService ts = context.getBean("testService", TestService.class);
		printExcel(ts);
	}
	private static void printExcel(TestService ts) throws Exception{
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("用户表一");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow(0);  
       
        row.createCell(0).setCellValue("电话号码");  
        row.createCell(1).setCellValue("姓名");  
        row.createCell(2).setCellValue("成绩");  
        row.createCell(3).setCellValue("工作单位");
  
        List<User> list = ts.getAllUsers();
  
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow(i + 1);  
            
            // 第四步，创建单元格，并设置值  
            row.createCell(0).setCellValue(list.get(i).getPhoneNumber());  
            row.createCell(1).setCellValue(list.get(i).getUsername());  
            row.createCell(2).setCellValue(list.get(i).getScore());  
            row.createCell(3).setCellValue(list.get(i).getWorkSpace());  
         
        }  
        // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream("c:/code/users.xls");  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }
		
	}
/*	private static void addDuo(TestService ts) throws Exception {
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
		
	}*/


}
