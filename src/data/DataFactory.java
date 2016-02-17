package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import business.Stock;
import business.Trade;
import tools.DateFormat;

public class DataFactory {

	private static Map<String, Stock> data;
	
	private DataFactory() {
		// Avoid to instantiate the class ...
	}
	
	/***
	 * Get Data as singleton ...
	 * @return
	 */
	public static Map<String, Stock> getData() {
		if (data == null) {
			data = buildData();
		}
		return data;
	}
	
	/***
	 * Create the movements (trade) linked to a stock ...
	 * @return
	 */
	private static Map<String, Stock> buildData() {
		List<Trade> movements= new ArrayList<Trade>();
		Map<String, Stock> stocks = StockFactory.getStockData4Test();
		Stock stock = stocks.get("TEA");
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:15"), 15.2, 3, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:17"), 17.2, 4, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:18"), 18.2, 7, false));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:19"), 19.2, 2, true));
		stock.setMovements(movements);
		//
		stock = stocks.get("POP");
		movements= new ArrayList<Trade>();
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:15"), 65.2, 5, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:20"), 89.9, 2, false));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:30"), 91.3, 4, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:31"), 92.7, 1, true));
		stock.setMovements(movements);
		//
		stock = stocks.get("ALE");
		movements= new ArrayList<Trade>();
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:17"), 5.2, 9, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:19"), 7.2, 4, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:21"), 8.3, 1, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:26"), 9, 6, false));
		stock.setMovements(movements);
		// 
		stock = stocks.get("GIN");
		movements= new ArrayList<Trade>();
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:17"), 10.1, 2, false));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:19"), 10.5, 7, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:21"), 14, 1, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:13"), 16, 6, true));
		stock.setMovements(movements);
		//
		stock = stocks.get("JOE");
		movements= new ArrayList<Trade>();
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:18"), 24, 3, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:19"), 24.1, 7, true));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:21"), 24.2, 2, false));
		movements.add(buildTrade(stock, DateFormat.toDateFromString_ddMMyyyy("01022015 10:24"), 25, 1, true));
		stock.setMovements(movements);
		return stocks;
		
	}
	
	private static Trade buildTrade(Stock stock, Date date, double price, int quantity, boolean buy) {
		Trade trade = new Trade();
		trade.setTimestamp(date);
		trade.setBuy(buy);
		trade.setPrice(price);
		trade.setQuantity(quantity);
		trade.setStock(stock);
		return trade;
	}
}
