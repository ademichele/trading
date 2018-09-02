package it.report.dao.impl.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import it.report.bean.Entity;
import it.report.dao.EntityDAO;
import it.report.dao.impl.EntityDAOImpl;
import it.report.dto.EntityDTO;
import it.report.helper.DateUtils;

public class EntityDAOImplTest {

	@Test
	public void getTotalIncoming() {
		EntityDAO dao = new EntityDAOImpl();
		double total = 0.0d;
		Entity a02 = new Entity("bar", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 111, 150.3);
		Entity a05 = new Entity("foo", false, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 1500, 150.3);
		EntityDTO b02 = new EntityDTO(a02);
		EntityDTO b05 = new EntityDTO(a05);
		List<EntityDTO> tradeList = new ArrayList<EntityDTO>();
		tradeList.add(b02);
		tradeList.add(b05);
		try {
			total = dao.getTotalIncoming(tradeList, "08-27-2018");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(total == (double) (150.3 * 1500 * 0.55));
	}

	@Test
	public void getTotalOutgoing() {
		EntityDAO dao = new EntityDAOImpl();
		double total = 0.0d;
		Entity a02 = new Entity("bar", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 111, 150.3);
		Entity a05 = new Entity("foo", false, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 1500, 150.3);
		EntityDTO b02 = new EntityDTO(a02);
		EntityDTO b05 = new EntityDTO(a05);
		List<EntityDTO> tradeList = new ArrayList<EntityDTO>();
		tradeList.add(b02);
		tradeList.add(b05);
		try {
			total = dao.getTotalOutgoing(tradeList, "08-27-2018");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(total == (double) (150.3 * 111 * 0.55));
	}
	
	@Test
	public void getUSDIncomingChart() {
		EntityDAO dao = new EntityDAOImpl();
		Map<String, Double> incomingChart = new HashMap<String, Double>();
		String name = null;
		Double amount = null;
		Entity a02 = new Entity("bar", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 111, 150.3);
		Entity a05 = new Entity("foo", false, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 1500, 150.3);
		EntityDTO b02 = new EntityDTO(a02);
		EntityDTO b05 = new EntityDTO(a05);
		List<EntityDTO> tradeList = new ArrayList<EntityDTO>();
		tradeList.add(b02);
		tradeList.add(b05);
		try {
			incomingChart = dao.getUSDIncomingChart(tradeList, "08-27-2018");
			name = (String) incomingChart.keySet().toArray()[0];
			amount = incomingChart.get(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(name.equals("foo") && amount == (double)(150.3 * 1500 * 0.55));
	}
	
	@Test
	public void getUSDOutgoingChart() {
		EntityDAO dao = new EntityDAOImpl();
		Map<String, Double> incomingChart = new HashMap<String, Double>();
		String name = null;
		Double amount = null;
		Entity a02 = new Entity("bar", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 111, 150.3);
		Entity a05 = new Entity("foo", false, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 1500, 150.3);
		EntityDTO b02 = new EntityDTO(a02);
		EntityDTO b05 = new EntityDTO(a05);
		List<EntityDTO> tradeList = new ArrayList<EntityDTO>();
		tradeList.add(b02);
		tradeList.add(b05);
		try {
			incomingChart = dao.getUSDOutgoingChart(tradeList, "08-27-2018");
			name = (String) incomingChart.keySet().toArray()[0];
			amount = incomingChart.get(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(name.equals("bar") && amount == (double)(150.3 * 111 * 0.55));
	}
}
