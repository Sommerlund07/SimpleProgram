package data;

import java.util.HashMap;
import java.util.Map;

import business.Stock;
import business.Stock.ETypeStock;

public class StockFactory {
	
	private static Map<String, Stock> stocks;
	
	private StockFactory() {
		// Avoid to instantiate the class ...
	}
	
	/***
	 * Create Data with singleton pattern ...
	 * @return
	 */
	protected static Map<String, Stock> getStockData4Test() {
		if (stocks == null) {
			stocks = buildData();	
		}
		return stocks;
		
	}
	
	/***
	 * Create just Fake data according Table 1 : Global Beverage Corporation Exchange :
	 * @return
	 */
	private static Map<String, Stock> buildData() {
		Map<String, Stock> ret = new HashMap<String, Stock>();
		Stock stock1 = new Stock();
		stock1.setSymbol("TEA");
		stock1.setType(ETypeStock.COMMON);
		stock1.setLastDividend(0);
		stock1.setParValue(100);
		// Not sure for the ticket price ??
		stock1.setTickerPrice(100.00);
		ret.put(stock1.getSymbol(), stock1);
		Stock stock2 = new Stock();
		stock2.setSymbol("POP");
		stock2.setType(ETypeStock.COMMON);
		stock2.setLastDividend(8);
		stock2.setParValue(100);
		stock2.setTickerPrice(100.00);
		ret.put(stock2.getSymbol(), stock2);
		Stock stock3 = new Stock();
		stock3.setSymbol("ALE");
		stock3.setType(ETypeStock.COMMON);
		stock3.setLastDividend(23);
		stock3.setParValue(60);
		stock3.setTickerPrice(60.00);
		ret.put(stock3.getSymbol(), stock3);
		Stock stock4 = new Stock();
		stock4.setSymbol("GIN");
		stock4.setType(ETypeStock.PREFERED);
		stock4.setLastDividend(8);
		stock4.setFixedDividend(2.0);
		stock4.setParValue(100);
		stock4.setTickerPrice(100.00);
		ret.put(stock4.getSymbol(), stock4);
		Stock stock5 = new Stock();
		stock5.setSymbol("JOE");
		stock5.setType(ETypeStock.COMMON);
		stock5.setLastDividend(13);
		stock5.setParValue(250);
		stock5.setTickerPrice(250.00);
		ret.put(stock5.getSymbol(), stock5);
		return ret;
	}
}
