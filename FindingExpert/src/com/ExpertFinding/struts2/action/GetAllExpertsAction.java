package com.ExpertFinding.struts2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ExpertFinding.model.history;
import com.ExpertFinding.model.users;
import com.ExpertFinding.service.HistoryService;
import com.ExpertFinding.service.UserService;

import common.GetExpertidsFromIndex;
public class GetAllExpertsAction extends BasicAction{
	private List<users> users;
	private String query;
	public List<users> getUsers() {
		return users;
	}
	public void setUsers(List<users> users) {
		this.users = users;
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
			UserService userService = serviceManager.getUserService();
			history existHistory=new history();
			existHistory.setQuery(query);
			if(historyService.exists(existHistory)!=null){
				String[] nodeIds=historyService.exists(existHistory).split(" ");
				List<String> usersNodeIds=new ArrayList<String>();
				for(int i=0;i<nodeIds.length;i++){
					usersNodeIds.add(nodeIds[i]);
				}
				users=userService.findUsersByNodeId(usersNodeIds);
			}else{
			
				GetExpertidsFromIndex getJobids=new GetExpertidsFromIndex(query);
				List<String> jobids=getJobids.Search();
				users=userService.findUsersByNodeId(jobids);
			}
			String historyUsers="";
			for(int i=0;i<users.size();i++){
				historyUsers=historyUsers+users.get(i).getNodeId()+" ";
			}
			history his=new history();
			his.setQuery(query);
			String uId=UUID.randomUUID().toString();
			his.setHistoryId(uId);
			his.setUsers(historyUsers);
			his.setClick("1");
			historyService.save(his);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SUCCESS;
	}
}
