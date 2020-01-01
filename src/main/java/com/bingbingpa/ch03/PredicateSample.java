package com.bingbingpa.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredicateSample {
	
	public static void main(String...args) {
		
		List<String> listOfStrings = Arrays.asList("park", "", "hyun");
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmptyList = Filter(listOfStrings, nonEmptyStringPredicate);
		System.out.println(nonEmptyList);
	}
	
	@FunctionalInterface
	public interface Predicate<T> {
		boolean getValue(T t);
	}
	
	public static <T> List<T> Filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for(T t : list) {
			if(p.getValue(t)) {
				results.add(t);
			}
		}
		
		return results;
	}
}
