package com.bingbingpa.ch02.movie;

import java.time.LocalDateTime;

import com.bingbingpa.ch02.money.Money;

public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;
	
	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}
	
	public LocalDateTime getStartTime() {
		return whenScreened;
	}
	
	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}
	
	public Money getMovieFee() {
		return movie.getFee();
	}		

	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}
	
	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);
	}
}
