package com.ExpertFinding.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ExpertFinding.model.history;

import java.util.List;
public class HistoryDAOImpl extends DAOSupport implements HistoryDAO{
	public HistoryDAOImpl(HibernateTemplate template){
		super(template);
	}
	@Override
	public List<String> getHistory(String query){
		String hql="select query from history where query LIKE ? order by click DESC";
		List<String> users=template.find(hql,query);
		return users;
	}
	@Override
	public void save(history his){
		template.saveOrUpdate(his);
	}
	@Override
	public history exists(history his){
		String hql="from history where query= ?";
		List<history> hisList=template.find(hql,his.getQuery());
		if(hisList.size()>0)
			return hisList.get(0);
		else
			return null;
	}
}