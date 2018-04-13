package com.map.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
 
public class OrderByValue {
 
    public static void main(String a[]){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Bjava", 20);
        map.put("C++", 45);
        map.put("AJava2Novice", 2);
        map.put("Unix", 67);
        map.put("ZMAC", 26);
        map.put("DWhy this kolavari", 93);
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return -(o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
        System.out.println(map);
    }
}