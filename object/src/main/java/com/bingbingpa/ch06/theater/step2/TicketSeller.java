package com.bingbingpa.ch06.theater.step2;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }
    
    // 오퍼레이션은 클라이언트가 객체에게 무엇을 원하는지를 명확하게 표현해야 한다. 그런 측면에서 setTicket 메서드는 명확하지 않다.
    public void setTicket(Audience audience) {
        ticketOffice.plusAmount(audience.setTicket(ticketOffice.getTicket()));
    }
}