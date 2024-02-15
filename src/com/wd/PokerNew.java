package com.wd;

import java.util.ArrayList;
import java.util.List;

public class PokerNew {
    private static volatile List<Poker> pokers=new ArrayList<>();

    public static void main(String[] args) {
        Class cl=PokerNew.class;
        System.out.println(cl.getClassLoader());

    }

}
