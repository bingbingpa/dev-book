package com.ch03;

import java.awt.Color;

@FunctionalInterface
public interface PixelFunction {
    Color apply(int x, int y);
}