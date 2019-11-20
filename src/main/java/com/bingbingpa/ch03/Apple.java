package com.bingbingpa.ch03;

import com.bingbingpa.ch02.Color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public  class Apple {

    private int weight = 0;
    private Color color;
  }