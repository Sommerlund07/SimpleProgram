package formula;

import java.util.Date;
import java.util.List;

import business.Stock;

public interface ICalculator {

	/***
	 * 
	 * @param stock
	 * @return
	 */
	public abstract double getDividendYield(Stock stock);

	/***
	 * 
	 * @param stock
	 * @return
	 */
	public abstract double getPERation(Stock stock);

	/***
	 * 
	 * @param stockPrice
	 * @return
	 */
	public abstract double getGeometricMean(List<Double> stockPrice);

	/***
	 * 
	 * @param stock
	 * @param startDate
	 * @return
	 */
	public abstract double getStockPrice(Stock stock, Date startDate);

}