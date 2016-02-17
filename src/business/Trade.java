package business;

import java.util.Date;

/***
 * This class records a stock (buy of sell) :
 * In my understanding .. A trade (movement) concerns a stock ...
 * We build or sell or stock with a price at a time ...
 * @author Stephane Joyeux
 *
 */
public class Trade {

	protected Date timestamp;
	
	protected Integer quantity;
	
	protected Boolean buy;
	
	protected Double price;
	
	/**
	 * A trade concerns a stock :
	 */
	protected Stock stock;
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getBuy() {
		return buy;
	}

	public void setBuy(Boolean buy) {
		this.buy = buy;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
