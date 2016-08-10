package jp.koshiro.create;

import java.io.Serializable;

public class Item implements Serializable {

	private String id;
	private String name;
	private String price;
	private String quantity;
	private String remarks;

	public Item() {}

	public Item(String id, String name, String price, String quantity, String remarks) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.remarks = remarks;

	}


	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getRemarks() {
		return remarks;
	}

}
