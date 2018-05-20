package com.xas.common.AppUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;




public class AppUtil {

	public static String toString(Object o) {
		String s="";
		if (o instanceof Date ) {
			return o.toString();
		}
		else if (o instanceof String) {
			return o.toString();
		}
		else if(o==null) {

		}
		return s;

	}


	public static <T> T rowmapper(List<Object[]> result,Class<T> clazz) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Object[] o : result) {
			Field [] field=clazz.getDeclaredFields();

			for (int i = 0; i < field.length-1; i++) {
			
					Method[] m=clazz.getMethods();

					for (int j = 0; j < m.length; j++) {
						if (m[j].getName().equalsIgnoreCase("set"+field[i+1].getName())) {
							try {
								m[j].invoke(obj, o[0]);
								
								
							} catch (IllegalAccessException e) {
							
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
							
								e.printStackTrace();
							} catch (InvocationTargetException e) {
							
								e.printStackTrace();
							}
						}
					}

				
			}
		}
	
	return (T) obj;


}

	
}
