package com.xas.common.AppUtils;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

	public boolean isNullorEmpty(String args) {
		return (args==null && args.isEmpty());
	}
	public boolean isNotNullnorEmpty(String args) {
		return (args!=null && args.isEmpty());
	}
}
