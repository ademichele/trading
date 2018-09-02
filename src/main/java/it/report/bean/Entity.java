package it.report.bean;

import java.util.Date;

import it.report.helper.DateUtils;


//simple Java bean, with getters and setters only, meant for eventual persistence not implemented in this test
public class Entity {
	
	private String name;
	private boolean isBuy;
	private double agreedFx;
	private String currency;
	private Date instructionDate;
	private Date settlementDate;
	private int units;
	private double unitPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String entityName) {
		this.name = entityName;
	}
	public boolean isBuy() {
		return isBuy;
	}
	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public double getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Entity(String name, boolean isBuy, double agreedFx, String currency, Date instructionDate,
			 int units, double unitPrice) {
		super();
		this.name = name;
		this.isBuy = isBuy;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = DateUtils.getNextWorkingDay(this.instructionDate, this.currency);
		this.units = units;
		this.unitPrice = unitPrice;
	}
	
	

}
