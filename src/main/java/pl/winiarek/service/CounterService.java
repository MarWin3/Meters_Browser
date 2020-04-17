package pl.winiarek.service;


import pl.winiarek.entity.Counter;

import java.util.List;

public interface CounterService {
	public List<Counter> getCounter(int theSerialNumber);

	public List<Counter> getElectricityCounter();

	public List<Counter> getWaterCounter();

	public List<Counter> getCoolingCounter();

	public List<Counter> getHeatingCounter();

	public List<Counter> getGasCounter();


}
