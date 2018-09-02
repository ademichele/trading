package it.report.dto;

import it.report.bean.Entity;

//DTO for the Java bean, where I implemented the automatic conversion to USD in the constructor
public class EntityDTO {
	
	private Entity entity;
	private double amountUSD;
	
	
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public double getAmountUSD() {
		return amountUSD;
	}
	public void setAmountUSD(double amountUSD) {
		this.amountUSD = amountUSD;
	}
	
	public EntityDTO(Entity entity) {
		super();
		this.entity = entity;
		this.amountUSD = (entity.getUnitPrice()*entity.getUnits()*entity.getAgreedFx());
	}
	
    
	
}
