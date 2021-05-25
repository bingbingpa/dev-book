package com.bingbingpa.ch01;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
    	// Theater클래스에서 너무 많은 일을 하므로 일부는 ticketSeller에서 처리하도록 수정
        ticketSeller.sellTo(audience);
    }
}