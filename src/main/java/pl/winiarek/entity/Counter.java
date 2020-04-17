package pl.winiarek.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="counter")
public class Counter {
	private static List<Counter> countersList;
	@Id
	@Column(name="counterId")
	private int counterId;
	
	@Column(name="counterSerialNumber")
	private int counterSerialNumber;

	@Column(name="counterLocation")
	private String counterLocation;
	
	@Column(name="counterMedium")
	private String counterMedium;
	
	@Column(name="counterAddress")
	private int counterAddress;
	
	@Column(name="counterDate")
	private Date counterDate;
	
	@Column(name="counterValue")
	private double counterValue;
	
	@Column(name="counterUnit")
	private String counterUnit;

	//private List<Counter> counters;
	
	public Counter() {
	}

	public int getCounterId() {
		return counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}

	public int getCounterSerialNumber() {
		return counterSerialNumber;
	}

	public void setCounterSerialNumber(int counterSerialNumber) {
		this.counterSerialNumber = counterSerialNumber;
	}

	public String getCounterLocation() {
		return counterLocation;
	}

	public void setCounterLocation(String counterLocation) {
		this.counterLocation = counterLocation;
	}

	public String getCounterMedium() {
		return counterMedium;
	}

	public void setCounterMedium(String counterMedium) {
		this.counterMedium = counterMedium;
	}

	public int getCounterAddress() {
		return counterAddress;
	}

	public void setCounterAddress(int counterAddress) {
		this.counterAddress = counterAddress;
	}

	public Date getCounterDate() {
		return counterDate;
	}

	public void setCounterDate(Date counterDate) {
		this.counterDate = counterDate;
	}

	public double getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(double counterValue) {
		this.counterValue = counterValue;
	}

	public String getCounterUnit() {
		return counterUnit;
	}

	public void setCounterUnit(String counterUnit) {
		this.counterUnit = counterUnit;
	}

	public static List<Counter> getCountersList() {
		return countersList;
	}

	public static void setCountersList(List<Counter> countersList) {
		Counter.countersList = countersList;
	}

	@Override
	public String toString() {
		return "Counter [counterSerialNumber=" + counterSerialNumber + ", counterLocation=" + counterLocation
				+ ", counterMedium=" + counterMedium + ", counterAddress=" + counterAddress + "]";
	}

	/*public List<Counter> getCounters() {
		return counters;
	}

	public void setCounters(List<Counter> counters) {
		this.counters = counters;
		System.out.println(counters.size());
	}*/
	

}
