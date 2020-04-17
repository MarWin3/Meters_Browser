package pl.winiarek.dao;

import java.util.List;
import pl.winiarek.entity.Counter;

public interface CounterDAO {
public Counter getCounter();
public List<Counter> getCounterDetail(int theSerialNumber);
public List<Counter>getElectricityCounter();
public List<Counter>getWaterCounter();
public List<Counter>getCoolingCounter();
public List<Counter>getHeatingCounter();
public List<Counter>getGasCounter();
}