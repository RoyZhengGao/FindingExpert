package com.ExpertFinding.struts2.action;

import com.opensymphony.xwork2.*;
import java.util.*;
import javax.servlet.http.*;
import com.ExpertFinding.service.ServiceManager;

public class BasicAction extends ActionSupport implements
		org.apache.struts2.interceptor.ServletRequestAware,
		org.apache.struts2.interceptor.ServletResponseAware {
	protected ServiceManager serviceManager;
	protected String result;
	protected Map<String, String> cookies;
	protected javax.servlet.http.HttpServletResponse response;
	protected javax.servlet.http.HttpServletRequest request;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;

	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
}
