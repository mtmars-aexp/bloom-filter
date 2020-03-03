package com.avnsystems;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class BloomFilter {

    BitSet bitset = new BitSet(1024 * 1024 * 1024);
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    Random ayn = new Random();


    public BloomFilter() throws NoSuchAlgorithmException {

    }

    public boolean contains(String value){

        ayn.setSeed(value.hashCode());
        for(int i = 0; i != 2; i++){
            int index = ayn.nextInt() % bitset.size();
            if (index < 0) index = -index;
            if(!bitset.get(index)){
                return false;
            }
        }
        return true;

    }

    public void add(String value){

        ayn.setSeed(value.hashCode());
        int randValue = 0;

        for(int i = 0; i != 2; i++) {
            int index = ayn.nextInt() % bitset.size();
            if (index < 0) index = -index;
            bitset.set(index);
        }

    }

}
