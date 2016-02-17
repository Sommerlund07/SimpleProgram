package formula;

import java.util.Date;
import java.util.List;

import business.Stock;
import business.Trade;

/***
 * Exception is not managed !! If a problem occurs (division by zero) the system
 * return 0 ...
 * 
 * @author Stephane Joyeux
 * 
 */
public class FormulaCalculator implements ICalculator {

	// TODO : Manage exception in result of formula :

	/* (non-Javadoc)
	 * @see formula.ICalculator#getDividendYield(business.Stock)
	 */
	@Override
	public double getDividendYield(Stock stock) {
		switch (stock.getType()) {
		case COMMON:
			return stock.getLastDividend() / stock.getTickerPrice();
		case PREFERED:
			return stock.getFixedDividend() * stock.getParValue()
					/ stock.getTickerPrice();
		default:
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see formula.ICalculator#getPERation(business.Stock)
	 */
	@Override
	public double getPERation(Stock stock) {
		return stock.getTickerPrice() / getDividendYield(stock);
	}

	/* (non-Javadoc)
	 * @see formula.ICalculator#getGeometricMean(java.util.List)
	 */
	@Override
	public double getGeometricMean(List<Double> stockPrices) {
		int total = stockPrices.size();
		double result = 1;
		for (Double price : stockPrices) {
			result = result * price;
		}
		return Math.pow(result, 1.0/total);
	}

	/* (non-Javadoc)
	 * @see formula.ICalculator#getStockPrice(business.Stock, java.util.Date)
	 */
	@Override
	public double getStockPrice(Stock stock, Date startDate) {
		List<Trade> trades = stock.getMovements();
		double totalCostTrade = 0;
		int totalQuantity = 0;
		for (Trade trade : trades) {
			if (trade.getTimestamp().after(startDate)) {
				Double costTrade = trade.getPrice() * trade.getQuantity();
				if (trade.getBuy()) {
					totalQuantity = totalQuantity + trade.getQuantity();
					totalCostTrade = totalCostTrade + costTrade;
				} else {
					totalQuantity = totalQuantity - trade.getQuantity();
					totalCostTrade = totalCostTrade - costTrade;
				}
			}
		}
		if (totalQuantity != 0) {
			return totalCostTrade / totalQuantity;
		} else {
			return 0;
		}
	}
}
