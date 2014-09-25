package com.hans.mapping;

import java.util.HashMap;
import java.util.Map;

public class MappingFactory {
	private static MappingFactory mappingFactory = null;
	public static final String INFO_MAPPING = "InfoMapping";
	private Map<String, EntityMapping> maps = new HashMap<String, EntityMapping>();

	private MappingFactory() {
	}

	public static MappingFactory getInstance() {
		if (mappingFactory == null) {
			mappingFactory = new MappingFactory();
			mappingFactory.maps.put(INFO_MAPPING, new InfoMapping());
		}
		return mappingFactory;
	}

	/**
	 * 获得Mapping
	 * 
	 * @param name
	 * @return
	 */
	public EntityMapping getMapping(String name) {
		return maps.get(name);
	}
}
