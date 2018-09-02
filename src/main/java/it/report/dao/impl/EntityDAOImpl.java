package it.report.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.report.dao.EntityDAO;
import it.report.dto.EntityDTO;
import it.report.helper.DateUtils;
import it.report.helper.MapUtils;

public class EntityDAOImpl implements EntityDAO {

	/*
	 * I preferred to separate the incoming and outgoing methods instead of
	 * considering the isBuy flag in case of future changes in the business
	 * logic for sales and purchases for the incoming and outgoing charts I
	 * preferred to use a HashMap to work only with the specified fields
	 * requested in the report, using a helper class for the sorting by values
	 * and for the console output to keep the main class as clear as possible. I
	 * could have created methods to retrieve only the incoming and the outgoing
	 * from the lists to reduce the code, but I preferred not to because the
	 * repeated code is minimum
	 */

	public Map<String, Double> getUSDIncomingChart(List<EntityDTO> incomingList, String date) {
		// from the input List, only the objects that are for sale and having
		// the right settlement date are inserted in the Map, updating the
		// incoming total at each iteration
		Map<String, Double> incomingChart = new HashMap<String, Double>();
		for (EntityDTO dto : incomingList) {
			if (DateUtils.dateToString(dto.getEntity().getSettlementDate()).equals(date) && !dto.getEntity().isBuy()) {
				Double old = incomingChart.getOrDefault(dto.getEntity().getName(), 0d);
				old += dto.getAmountUSD();
				incomingChart.put(dto.getEntity().getName(), old);
			}
		}
		return incomingChart;
	}

	public Map<String, Double> getUSDOutgoingChart(List<EntityDTO> outgoingList, String date) {
		// same logic of the getUSDIncomingChart
		Map<String, Double> outgoingChart = new HashMap<String, Double>();
		for (EntityDTO dto : outgoingList) {
			if (DateUtils.dateToString(dto.getEntity().getSettlementDate()).equals(date) && dto.getEntity().isBuy()) {
				Double old = outgoingChart.getOrDefault(dto.getEntity().getName(), 0d);
				old += dto.getAmountUSD();
				outgoingChart.put(dto.getEntity().getName(), old);
			}
		}
		return outgoingChart;
	}

	public double getTotalIncoming(List<EntityDTO> tradeList, String tradeDate) {
		// the method simply iterates through the ArrayList, calculating the
		// total income; again I preferred to separate the methods in case of
		// eventual changes of the business logic
		double totalIncoming = 0;
		for (EntityDTO dto : tradeList) {
			if (DateUtils.dateToString(dto.getEntity().getSettlementDate()).equals(tradeDate)
					&& !dto.getEntity().isBuy())
				totalIncoming += dto.getAmountUSD();
		}
		return totalIncoming;

	}

	public double getTotalOutgoing(List<EntityDTO> tradeList, String date) {
		// same logic of getTotalIncoming
		double totalOutgoing = 0;
		for (EntityDTO dto : tradeList) {
			if (DateUtils.dateToString(dto.getEntity().getSettlementDate()).equals(date) && dto.getEntity().isBuy()) {
				totalOutgoing += dto.getAmountUSD();
			}
		}
		return totalOutgoing;
	}

}
