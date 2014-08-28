package common;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import function.index.MyRetrievalModel;
import function.index.indexReader;
import common.Constants;
public class GetExpertidsFromPossibility {
	public List<String> start(String query) throws Exception{
		MyRetrievalModel myRetrievalModel;
		indexReader ixreader = null;
		try {
			ixreader = new indexReader(Constants.Tweet,Constants.TweetId);
			ixreader.getNodeId(1);
		}catch(Exception e){
			System.out.println("ERROR: cannot initiate index directory.");
			e.printStackTrace();
		}
		System.out.println("123");
		myRetrievalModel=new MyRetrievalModel();
		myRetrievalModel.setIndex(ixreader);
//		long startTime = System.nanoTime();
		Map<String,Double> results = myRetrievalModel.search(query);
//		long endTime = System.nanoTime();
//		System.out.println(endTime - startTime);
		int i=0;
		List<String> jobids=new ArrayList<String>();
		Map<String, Double> sortedMap = sortByComparator(results);
		for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
			if(i<10){
				jobids.add(entry.getKey());
				System.out.println(entry);
				i++;
			}else{
				break;
			}
		}
		return jobids;
	}
	private static Map sortByComparator(Map unsortMap) {
		List list = new LinkedList(unsortMap.entrySet());
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	public static void main(String args[]) throws Exception{
		GetExpertidsFromPossibility test=new GetExpertidsFromPossibility();
		test.start("data mining");
	}
}
