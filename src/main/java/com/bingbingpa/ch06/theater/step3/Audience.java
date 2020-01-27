
package com.bingbingpa.ch06.theater.step3;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }
    
    // setTicket보다 좀 더 명확한 메서드로 반경 
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
