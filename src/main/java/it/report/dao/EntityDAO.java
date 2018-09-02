package it.report.dao;

import java.util.List;
import java.util.Map;

import it.report.dto.EntityDTO;

public interface EntityDAO {
	
	public Map<String, Double> getUSDIncomingChart(List<EntityDTO> incomingList, String date);
	public Map<String, Double> getUSDOutgoingChart(List<EntityDTO> outgoingList, String date);
	public double getTotalIncoming(List<EntityDTO> incomingList, String date);
	public double getTotalOutgoing(List<EntityDTO> outgoingList, String date);

}
