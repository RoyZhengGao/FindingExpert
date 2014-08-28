package com.ExpertFinding.dao;

import java.util.List;

import com.ExpertFinding.model.history;

public interface HistoryDAO {
	List<String> getHistory(String query);
	void save(history his);
	history exists(history his);
}
