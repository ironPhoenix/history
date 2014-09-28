package com.hans.control;

import java.util.List;
import java.util.Map;

import com.hans.bean.Info;
import com.hans.mapping.MappingFactory;
import com.hans.service.InfoService;
import com.hans.service.impl.InfoServiceImpl;
import com.hans.util.Pagination;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InfoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InfoService infoService;
	private Info info;
	private int pageNumber;

	public InfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String add() throws Exception {
		String name = info.getName();
		String message = info.getMessage();
		infoService = new InfoServiceImpl();
		infoService.add(info);

		return SUCCESS;
	}

	public String saveById() throws Exception {
		InfoService infoService = new InfoServiceImpl();
		System.out.println(info.getId()+"     qwetpoiupouiopiu");
		infoService.saveById(info);
		return SUCCESS;
	}

	public String delete() throws Exception {
		InfoService infoService = new InfoServiceImpl();
		infoService.delete(info.getId() + "");
		return SUCCESS;
	}

	public String getById() throws Exception {

		InfoService infoService = new InfoServiceImpl();

		Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");
		request.put("info", infoService.getByid(info.getId()));
		return "change";
	}

	public String show() throws Exception {
		int pageSize = 2;

		if (pageNumber == 0) {
			pageNumber = 1;
		}

		InfoService infoService = new InfoServiceImpl();
		System.out.println(pageNumber + "asddddddddddd");

		Pagination pagination = infoService.getByPage(pageSize, pageNumber);
		MappingFactory mf = MappingFactory.getInstance();
		List<Object> list = pagination.getList(mf
				.getMapping(MappingFactory.INFO_MAPPING));

		Map<String,Object> request = (Map<String,Object>) ActionContext.getContext().get("request");

		request.put("AllInfoList", list);
		request.put("totalPageInfoList", pagination.getMaxPages());
		request.put("pageNumberInfoList", pagination.getPageNumber());
		return ERROR;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}