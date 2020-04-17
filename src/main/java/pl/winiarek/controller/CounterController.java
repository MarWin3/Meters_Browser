package pl.winiarek.controller;


import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.PostMapping;
import pl.winiarek.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.winiarek.report.CounterReport;
import pl.winiarek.service.CounterService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/counter")
public class CounterController {


	@Autowired
	private CounterService counterService;
	@Autowired
	private CounterReport report;
	private List<Counter> tempList;
	
	@RequestMapping("/list")
	public String lisCounters(Model theModel) throws FileNotFoundException, JRException, IOException {
		List<Counter> theElektricityCounter = counterService.getElectricityCounter();
		List<Counter>theWaterCounter = counterService.getWaterCounter();
		List<Counter>theCollingCounter = counterService.getCoolingCounter();
		List<Counter>theGasCounter = counterService.getGasCounter();
		List<Counter>theHeatingCounter = counterService.getHeatingCounter();
		theModel.addAttribute("elekt",theElektricityCounter);
		theModel.addAttribute("wat",theWaterCounter);
		theModel.addAttribute("cool",theCollingCounter);
		theModel.addAttribute("heat",theHeatingCounter);
		theModel.addAttribute("gas",theGasCounter);
		report.generateReport();

		return "counter-list";
	}
	@RequestMapping("/water")
	public String listWaterCounters(Model theModel) {
		List<Counter>theWaterCounter = counterService.getWaterCounter();
		tempList=theWaterCounter;
		theModel.addAttribute("wat",theWaterCounter);
		return "counter-water";
	}
	@RequestMapping("/electricity")
	public String listElectricityCounters(Model theModel) {
		List<Counter>theElectricityCounter = counterService.getElectricityCounter();
		tempList=theElectricityCounter;
		theModel.addAttribute("elek",theElectricityCounter);
		return "counter-electricity";
	}
	@RequestMapping("/gas")
	public String listGasCounters(Model theModel) {
		List<Counter>theGasCounter = counterService.getGasCounter();
		tempList=theGasCounter;
		theModel.addAttribute("gas",theGasCounter);
		return "counter-gas";
	}
	@RequestMapping("/cold")
	public String listColdCounters(Model theModel) {
		List<Counter>theColdCounter = counterService.getCoolingCounter();
		theModel.addAttribute("gas",theColdCounter);
		tempList=theColdCounter;
		return "counter-cold";
	}
	@RequestMapping("/heat")
	public String listHeatingCounters(Model theModel) {
		List<Counter>theHeatCounter = counterService.getHeatingCounter();
		tempList=theHeatCounter;
		theModel.addAttribute("gas",theHeatCounter);
		return "counter-heat";
	}
	@GetMapping("/showSpecCounter")
	public String readCounterDetail(@RequestParam("counterSerialNumber") int serialNumber, Model theModel) {
		List<Counter> theCounter = counterService.getCounter(serialNumber);
		tempList=theCounter;
		theModel.addAttribute("counter",theCounter);
		return "counterDetail";
	}


	@PostMapping("/list")
	public String reportAll(@RequestParam("counterSerialNumber") int serialNumber, Model theModel) {
		List<Counter> theCounter = counterService.getCounter(serialNumber);
		tempList=theCounter;
		theModel.addAttribute("counter",theCounter);
		return "counterDetail";
	}
}
