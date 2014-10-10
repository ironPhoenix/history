package com.hans.action;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController implements ServletContextAware {

	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public void handleUploadData(String name,
			@RequestParam("file") CommonsMultipartFile file) {
		if (!file.isEmpty()) {
			String path = this.servletContext.getRealPath("/tmp/"); // 获取本地存储路径
			System.out.println(path);
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(fileType);
			File file2 = new File(path, new Date().getTime()+fileName); // 新建一个文件
			try {
				file.getFileItem().write(file2); // 将上传的文件写入新建的文件中
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("success");
		} else {
			System.out.println("error");
			;
		}
	}
}
