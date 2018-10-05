package bos.utils;

import java.util.List;

import bos.domain.Staff;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class jsonUtils {

	public static String objecttojson(Object object,String[] strings) {
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(strings);
		JSONObject fromObject = JSONObject.fromObject(object, jsonConfig);
		String json=fromObject.toString();
		return json;
	}
	public static String arraytojson(List list,String[] strings ){
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(strings);
		JSONArray fromObject = JSONArray.fromObject(list,jsonConfig);
		String json=fromObject.toString();
		return json;
	}
}
