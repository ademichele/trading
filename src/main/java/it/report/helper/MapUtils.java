package it.report.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapUtils  {
	
	//I created a method that sorts the HashMap by the values
	public static HashMap<String, Double> sortByValues(Map<String, Double> map) {
		
	    List<String> mapKeys = new ArrayList<String>(map.keySet());
	    List<Double> mapValues = new ArrayList<Double>(map.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);
	    Collections.reverse(mapValues);
	    Collections.reverse(mapKeys);

	    LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();

	    Iterator<Double> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Double val = valueIt.next();
	        Iterator<String> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            String key = keyIt.next();
	            Double comp1 = map.get(key);
	            Double comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}

public static void print (Map<String, Double> map){
		
		StringBuilder message = new StringBuilder();
		for (String key :map.keySet()){
			message.append(key);
			message.append(" - ");
			message.append(map.get(key));
			message.append(" USD");
			System.out.println(message);
			message.setLength(0);
		}
	}

}