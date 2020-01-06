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
	
	public Long hold(Ticket ticket) {
		if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
        	setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
	}
	
	public boolean hasTicket() {
		return ticket != null;
	}
	
	private boolean hasInvitation() {
		return invitation != null;
	}
	
	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	private void minusAmount(Long amount) {
		this.amount -= amount;
	}
}
