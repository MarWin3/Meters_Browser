package pl.winiarek.service;

import java.util.List;

import pl.winiarek.dao.CounterDAO;
import pl.winiarek.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CounterServiceImpl implements CounterService {

	@Autowired
	private CounterDAO counterDAO;

	@Override
	@Transactional
	public List<Counter> getCounter(int theSerialNumber) {
		// TODO Auto-generated method stub
		return counterDAO.getCounterDetail(theSerialNumber);
	}

	@Override
	@Transactional
	public List<Counter> getElectricityCounter() {
		// TODO Auto-generated method stub
		return counterDAO.getElectricityCounter();
	}

	@Override
	@Transactional
	public List<Counter> getWaterCounter() {
		// TODO Auto-generated method stub
		return counterDAO.getWaterCounter();
	}

	@Override
	@Transactional
	public List<Counter> getCoolingCounter() {
		// TODO Auto-generated method stub
		return counterDAO.getCoolingCounter();
	}

	@Override
	@Transactional
	public List<Counter> getHeatingCounter() {
		// TODO Auto-generated method stub
		return counterDAO.getHeatingCounter();
	}

	@Override
	@Transactional
	public List<Counter> getGasCounter() {
		// TODO Auto-generated method stub
		return counterDAO.getGasCounter();
	}



	

}
