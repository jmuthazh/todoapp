package com.workfront.todo.model;

public class Item {
	
	private String itemName;
    private String itemSatus = "Pending";
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSatus() {
		return itemSatus;
	}
	public void setItemSatus(String itemSatus) {
		this.itemSatus = itemSatus;
	}
    

}
