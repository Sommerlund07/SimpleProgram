package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tools.DateFormat;
import data.DataFactory;
import business.Stock;
import formula.CalculatorService;
import formula.ICalculator;

public class CalculatorServiceTest {

	private ICalculator calculator;
	private Map<String, Stock> data;
	
	@Before
	public void setUp() {
		calculator = new CalculatorService();
		data = DataFactory.getData();
	}
	
	@Test
	public void testDividendYield() {
		Stock stock = data.get("ALE");
		double result = calculator.getDividendYield(stock);
		Assert.assertEquals(0.38, result, 0.01);
	}
	
	@Test
	public void testPERation() {
		Stock stock = data.get("POP");
		double result = calculator.getPERation(stock);
		Assert.assertEquals(1250, result, 0.1);
	}
	
	@Test
	public void testStockPrice() {
		Stock stock = data.get("TEA");
		double result = calculator.getStockPrice(stock, DateFormat.toDateFromString_ddMMyyyy("01012015 10:00"));
		Assert.assertEquals(12.7, result, 0.0);
		stock = data.get("POP");
		result = calculator.getStockPrice(stock, DateFormat.toDateFromString_ddMMyyyy("01012015 10:00"));
		Assert.assertEquals(75.5, result, 0.1);
	}
	
	@Test
	public void testGeometricMean() {
		List<Double> listOfStockPrices = new ArrayList<>();
		Iterator<?> it = data.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry)it.next();
		    Stock stock = (Stock) entry.getValue();
		    listOfStockPrices.add(calculator.getStockPrice(stock, DateFormat.toDateFromString_ddMMyyyy("01012015 10:00")));
		}
		Assert.assertEquals(16.3, calculator.getGeometricMean(listOfStockPrices), 01);
	}
}
