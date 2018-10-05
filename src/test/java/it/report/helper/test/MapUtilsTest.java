package it.report.helper.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import it.report.helper.MapUtils;

public class MapUtilsTest {

	@Test
	public void sortByValues(){
		Map<String,Double> map = new HashMap<String,Double>();
		map.put("world", 0.5d);
		map.put("hello", 1d);
		List<String> list = new ArrayList<String>();
		try {
			Map<String, Double> sortedMap = MapUtils.sortByValues(map);
			for(String name:sortedMap.keySet()){
				list.add(name);
			}
		} catch  (Exception e) {
			e.printStackTrace();
		}
		assertTrue(list.get(0).equals("hello")&&list.get(1).equals("world"));
		
	}
}
