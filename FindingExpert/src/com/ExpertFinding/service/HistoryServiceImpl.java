package com.ExpertFinding.service;

import java.util.List;

import com.ExpertFinding.dao.HistoryDAO;
import com.ExpertFinding.model.history;

public class HistoryServiceImpl implements HistoryService{
	private HistoryDAO historyDAO;
	public HistoryServiceImpl(HistoryDAO historyDAO){
		this.historyDAO=historyDAO;
	}
	@Override
	public List<String> getHistory(String query) throws Exception{
		return historyDAO.getHistory(query+"%");
	}
	@Override
	public void save(history his) throws Exception{
		history click=historyDAO.exists(his);
		if(click!=null){
			click.setClick(String.valueOf(Integer.valueOf(click.getClick())+1));
			historyDAO.save(click);
		}else{
			historyDAO.save(his);
		}
	}
	@Override
	public String exists(history his) throws Exception{
		if(historyDAO.exists(his)!=null){
			return historyDAO.exists(his).getUsers();
		}else{
			return null;
		}
	}
}
