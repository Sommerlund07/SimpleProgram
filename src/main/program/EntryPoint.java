package main.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tools.DateFormat;
import business.Stock;
import business.Trade;
import data.DataFactory;
import formula.CalculatorService;
import formula.ICalculator;

/***
 * 
 * @author ZA27543
 *
 */
public class EntryPoint {

	/***
	 * Entry point of the program :
	 * @param args
	 */
	public static void main(String[] args) {
		ICalculator calculator = new CalculatorService();
		Map<String, Stock> stocks = DataFactory.getData();
		Iterator<?> it = stocks.entrySet().iterator();
		List<Double> listOfPrices = new ArrayList<Double>();
	    while (it.hasNext()) {
	        Map.Entry entry = (Map.Entry)it.next();
	        Stock stock = (Stock) entry.getValue();
	        int countOftrades = 1;
	        System.out.println("----------------------------------------------");
	        System.out.println("Stock Symbol : " + stock.getSymbol());
	        System.out.println("1. Dividend Yield = " + calculator.getDividendYield(stock));
	        System.out.println("2. P/E Ratio = " + calculator.getPERation(stock));
	        System.out.println("3. List of movements : " + stock.getMovements().size());
	        for (Trade trade : stock.getMovements()) {
	        	System.out.println(" -------> Movement Nr " + countOftrades++);
	        	System.out.println("      - TimeStamp : " + trade.getTimestamp());
	        	System.out.println("      - Quantity : " + trade.getQuantity());
	        	System.out.println("      - Is Buy ? : " + trade.getBuy());
	        	System.out.println("      - Price : " + trade.getPrice());
			};
			Double stockPrice =  calculator.getStockPrice(stock, DateFormat.toDateFromString_ddMMyyyy("01012015 10:00"));
			System.out.println("4. Stock Price : " + stockPrice);
			listOfPrices.add(stockPrice);
	    }
	    System.out.println("----------------------------------------------");
	    System.out.println("5. GBCE All Share Index (Geometric Mean) : " + calculator.getGeometricMean(listOfPrices));
	    System.out.println("----------------------------------------------");
	}

}
