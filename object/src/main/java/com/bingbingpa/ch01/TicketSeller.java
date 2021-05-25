package com.bingbingpa.ch01;

public class TicketSeller {
	private TicketOffice ticketOffice;
	
	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
	
	public TicketOffice getTicketOffice() {
		return ticketOffice;
	}
	
	public void sellTo(Audience audience) {
		ticketOffice.sellTicketTo(audience);
	}
}
