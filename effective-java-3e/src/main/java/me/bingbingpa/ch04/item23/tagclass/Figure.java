package me.bingbingpa.ch04.item23.tagclass;

public class Figure {
    enum Shape { RECTANGLE, CIRCLE }

    // 태그 필드 - 현재 모양을 나타낸다.
    private final Shape shape;

    // 다음 필드들은 모양이 사각형일 때만 쓰인다.
    private double length;
    private double width;

    // 다음 필드는 모양이 원일 때만 쓰인다.
    private double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        radius = radius;
    }

    // 사각형 생성자
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        length = length;
        width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
