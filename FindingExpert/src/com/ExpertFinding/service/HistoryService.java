package com.ExpertFinding.service;

import java.util.List;

import com.ExpertFinding.model.history;

public interface HistoryService {
	public List<String> getHistory(String query) throws Exception;
	public void save(history his) throws Exception;
	public String exists(history his) throws Exception;
}

