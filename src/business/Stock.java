package business;

import java.util.List;

/***
 * 
 * @author Stéphane Joyeux
 *
 */
public class Stock {
	
	protected String symbol;
	
	/*
	 * Sorry I'm not really sure this attribute is at the correct place ??
	 * parValue and tickerPrice seems to be the same ???
	 */
	protected double tickerPrice;
	
	protected ETypeStock type;
	
	protected Integer lastDividend;
	
	protected Double fixedDividend;
	
	protected Integer parValue;
	
	// List of movements for a trade :
	protected List<Trade> movements;
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public ETypeStock getType() {
		return type;
	}

	public void setType(ETypeStock type) {
		this.type = type;
	}

	public Integer getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Integer lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Integer getParValue() {
		return parValue;
	}

	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}

	public double getTickerPrice() {
		return tickerPrice;
	}

	public void setTickerPrice(double tickerPrice) {
		this.tickerPrice = tickerPrice;
	}
	
	public List<Trade> getMovements() {
		return movements;
	}

	public void setMovements(List<Trade> movements) {
		this.movements = movements;
	}



	public enum ETypeStock {
		COMMON,
		PREFERED
	}

}
