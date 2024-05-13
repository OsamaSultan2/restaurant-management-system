package com.example.demo3;

public class Table {
private	 double revenue=0;
private  int noChairs;
private Order order=new Order(); //the orders for that table
 Table(){

 }
public int getNoChairs() {
	return noChairs;
}

public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public void setNoChairs(int number){
	this.noChairs=number;
}
public void clear(){
	this.noChairs=0;
	this.order.clear();
}
public double getRevenue(){
	return revenue;
}
}
