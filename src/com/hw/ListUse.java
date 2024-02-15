package com.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUse {
    public static void main(String[] args) {
        List<Integer> data=new ArrayList<>();
        data.stream().mapToInt(Integer::intValue).sum();
        int num=0;
        num+=1;
        
    }
}
