package com.example.demo3;

public class Side extends Food{
	private String name;
	private double price;
	Side(String x, double y){
	this.name=x;
	this.price=y;
	}
	Side(String name ,Double price , String foodImg){
		super(name,price,foodImg);
		this.name=name;
		this.price=price;
	}
	@Override
	public void setPrice(double price) {
    	this.price=price ;
    }
	@Override
	 public void setName(String name) {
	    	this.name=name;
	    }
	@Override
	 public double getPrice() {
		 return this.price;
	 }
	@Override
	 public String getName() {
		 return this.name;
	 }

	@Override
	public int compareTo(Food o) {
		if (this.price>o.getPrice())
			return 1;
		if (this.price<o.getPrice())
			return -1;
		else
			return 0;
	}
}
