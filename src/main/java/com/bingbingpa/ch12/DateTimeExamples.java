package com.bingbingpa.ch12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTimeExamples {

    private static final ThreadLocal<DateFormat> formatters = new ThreadLocal<DateFormat>() {

    };

    @Override
    protected DateFormat initalValue() {
        return new SimpleDateFormat("dd-MMM-yyyy");
    }
}
