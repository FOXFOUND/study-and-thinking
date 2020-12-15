package com.test.pakcage;

import java.util.concurrent.atomic.AtomicInteger;

public class IntergerTest {
    public static void main(String[] args) {
//        AtomicInteger integer =new AtomicInteger (1);
//
//        System.out.println(System.identityHashCode(integer));
//        add(integer);
//        System.out.println(System.identityHashCode(integer));
//        System.out.println(integer);

        Integer a = 1;
        System.out.println(System.identityHashCode(a));
        a++ ;
        System.out.println(System.identityHashCode(a));
        System.out.println(a);
    }

    private static void add(AtomicInteger  integer) {
        System.out.println(System.identityHashCode(integer));
        integer.addAndGet(1) ;
        System.out.println(System.identityHashCode(integer));
    }
}
