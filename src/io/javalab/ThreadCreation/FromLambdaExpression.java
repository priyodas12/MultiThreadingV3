package io.javalab.ThreadCreation;

import java.util.stream.IntStream;

public class FromLambdaExpression {
    public static void main(String[] args) {
        Runnable r1=() -> {
            System.out.println(Thread.currentThread().getName());
        };
        IntStream.range(0,10).forEach(value -> new Thread(r1).start());
    }
}
