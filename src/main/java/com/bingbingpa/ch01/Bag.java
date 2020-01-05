package com.bingbingpa.ch01;

public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;
	
	// 현금만 있는 경우 
	public Bag(long amount) {
		this(null, amount);
	}
	
	// 초대장과 현금이 있는 경우
	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}
	public boolean hasInvitation() {
		return invitation != null;
	}
	
	public boolean hasTicket() {
		return ticket != null;
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public void minusAmount(Long amount) {
		this.amount -= amount;
	}
	
	public void plusAmount(Long amount) {
		this.amount += amount;
	}
}
