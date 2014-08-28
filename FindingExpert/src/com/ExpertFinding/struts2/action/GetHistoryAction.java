package com.ExpertFinding.struts2.action;

import java.util.List;

import com.ExpertFinding.model.history;
import com.ExpertFinding.service.HistoryService;
import com.ExpertFinding.service.UserService;

import common.GetExpertidsFromIndex;
public class GetHistoryAction extends BasicAction{
	private List<String> history;
	private String query;
	public List<String> getHistory() {
		return history;
	}
	public void setHistory(List<String> history) {
		this.history = history;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public String execute() throws Exception {
		try {
			HistoryService historyService = serviceManager.getHistoryService();
			history=historyService.getHistory(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SUCCESS;
	}
}
