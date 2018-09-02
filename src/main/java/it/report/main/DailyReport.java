package it.report.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import it.report.bean.Entity;
import it.report.dao.EntityDAO;
import it.report.dao.impl.EntityDAOImpl;
import it.report.dto.EntityDTO;
import it.report.helper.DateUtils;
import it.report.helper.MapUtils;

public class DailyReport {

	public static void main(String[] args) {

		// I assumed this report runs only once in a day, so I set a String in a
		// properties file to simulate the current date
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String tradeDate = prop.getProperty("referenceDate");

		StringBuilder message = new StringBuilder();
		EntityDAO dao = new EntityDAOImpl();
		List<EntityDTO> tradeList = new ArrayList<EntityDTO>();
		Map<String,Double> incomingChart = new HashMap<String, Double>();
		Map<String,Double> outgoingChart = new HashMap<String, Double>();

		// I created a few samples using the parametric constructor, I preferred to keep the instantiation of the objects in the main because that's where I would call eventual methods to query the DB
		Entity a01 = new Entity("foo", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 21, 150.3);
		Entity a02 = new Entity("bar", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 111, 150.3);
		Entity a03 = new Entity("bar", false, 0.25, "AED", DateUtils.stringToDate("08-24-2018"), 401, 150.3);
		Entity a04 = new Entity("foo", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 178, 150.3);
		Entity a05 = new Entity("foo", false, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 1500, 150.3);
		Entity a06 = new Entity("nvg", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 73, 150.3);
		Entity a07 = new Entity("foo", false, 0.12, "SAR", DateUtils.stringToDate("08-24-2018"), 1, 150.3);
		Entity a08 = new Entity("foo", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 14, 150.3);
		Entity a09 = new Entity("tec", true, 0.55, "EUR", DateUtils.stringToDate("08-24-2018"), 100, 150.3);

		//using the parametric constructor of the DTO I automatically calculate the USD amount of each entity
		EntityDTO b01 = new EntityDTO(a01);
		EntityDTO b02 = new EntityDTO(a02);
		EntityDTO b03 = new EntityDTO(a03);
		EntityDTO b04 = new EntityDTO(a04);
		EntityDTO b05 = new EntityDTO(a05);
		EntityDTO b06 = new EntityDTO(a06);
		EntityDTO b07 = new EntityDTO(a07);
		EntityDTO b08 = new EntityDTO(a08);
		EntityDTO b09 = new EntityDTO(a09);

		// creating the lists using the DTO, in order to carry the USD amount
		
		tradeList.add(b01);
		tradeList.add(b02);
		tradeList.add(b03);
		tradeList.add(b04);
		tradeList.add(b05);
		tradeList.add(b06);
		tradeList.add(b07);
		tradeList.add(b08);
		tradeList.add(b09);
		
		//called the DAO implementation methods
		message.append(tradeDate);
		System.out.println(message);
		message.setLength(0);
		
		message.append("Total Incoming: ");
		System.out.println(message);
		message.setLength(0);
		message.append(dao.getTotalIncoming(tradeList, tradeDate));
		message.append(" USD");
		System.out.println(message);
		message.setLength(0);
		
		message.append("Total Outgoing: ");
		System.out.println(message);
		message.setLength(0);
		message.append(dao.getTotalOutgoing(tradeList, tradeDate));
		message.append(" USD");
		System.out.println(message);
		message.setLength(0);

		incomingChart = dao.getUSDIncomingChart(tradeList, tradeDate);
		message.append("Incoming Chart: ");
		System.out.println(message);
		message.setLength(0);
		MapUtils.print(MapUtils.sortByValues(incomingChart));
		
		outgoingChart = dao.getUSDOutgoingChart(tradeList, tradeDate);
		message.append("Outgoing Chart: ");
		System.out.println(message);
		message.setLength(0);
		MapUtils.print(MapUtils.sortByValues(outgoingChart));

	}

}
