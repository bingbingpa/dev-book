package com.bingbingpa.ch01;

public class Audience {
	private Bag bag;
	
	public Audience(Bag bag) {
		this.bag = bag;
	}
	
	public Bag getBag() {
		return bag;
	}
	
	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}
}
