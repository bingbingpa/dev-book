package me.bingbingpa.ch03.item17.staticfactory;

public class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // 생성자 대신 정적 팩터리를 사용한 불변 클래스
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}
