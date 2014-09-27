package com.hans.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hans.bean.Info;
import com.hans.mapping.MappingFactory;
import com.hans.service.InfoService;
import com.hans.service.impl.InfoServiceImpl;
import com.hans.util.Pagination;

/**
 * Servlet implementation class InfoAction
 */
public class InfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoAction() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("add")) {
			doAdd(request, response);
		} else if (type.equals("change")) {
			doChange(request, response);
		} else if (type.equals("delete")) {
			delete(request, response);
		} else if (type.equals("saveById")) {
			saveById(request, response);
		} else if (type.equals("show")) {
			doShow(request, response);
		}
	}

	private void saveById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		Info info = new Info();
		info.setId(id);
		info.setName(name);
		info.setMessage(message);
		InfoService infoService = new InfoServiceImpl();
		infoService.saveById(info);
		doShow(request, response);
	}

	private void doChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		InfoService infoService = new InfoServiceImpl();
		request.setAttribute("info", infoService.getByid(id));
		request.getRequestDispatcher("../changeInfo.jsp").forward(request,
				response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		InfoService infoService = new InfoServiceImpl();
		infoService.delete(id);
		doShow(request, response);
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		System.out.println(name);
		System.out.println(message);
		Info info = new Info();
		info.setName(name);
		info.setMessage(message);
		InfoService infoService = new InfoServiceImpl();
		infoService.add(info);
		doShow(request, response);
	}

	private void doShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageSize = 2;
		int pageNumber;
		try {
			// 获取当前页码

			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			System.out.println(pageNumber);

		} catch (Exception e) {
			// 如果没有获取到当前页码那么将当前页码设置为1
			pageNumber = 1;
		}
		
		InfoService infoService = new InfoServiceImpl();
		System.out.println(pageSize+"asddddddddddd");

		Pagination pagination = infoService.getByPage(pageSize, pageNumber);
		MappingFactory mf = MappingFactory.getInstance();
		List<Object> list = pagination.getList(mf.getMapping(MappingFactory.INFO_MAPPING));
		
		request.setAttribute("AllInfoList", list);
		request.setAttribute("totalPageInfoList", pagination.getMaxPages());
		request.setAttribute("pageNumberInfoList", pagination.getPageNumber());
		request.getRequestDispatcher("../allInfo.jsp").forward(request,
				response);

	}

}
