package com.hans.util;

import java.util.List;

import com.hans.mapping.EntityMapping;

public interface Pagination {
	public boolean isFirst();

	public boolean isLast();

	public boolean hasNext();

	public boolean hasPrevious();

	public int getMaxElements();

	public int getMaxPages();

	public int getNext();

	public int getPrevious();

	public int getPageSize();

	public int getPageNumber();

	public List<Object> getList(EntityMapping mapping);

	public void setPageSize(int pageSize);

	public void setPageNumber(int pageNumber);
}
