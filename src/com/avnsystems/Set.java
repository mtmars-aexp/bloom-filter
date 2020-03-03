package com.avnsystems;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Set {

    private List<String> contents;
    private BloomFilter bf;

    public Set() throws NoSuchAlgorithmException {
        contents = new ArrayList<String>();
        bf = new BloomFilter();
    }

    public void add(String value){
        contents.add(value);
        bf.add(value);

    }

    public boolean contains(String value){
        return bf.contains(value);
    }

    public BloomFilter getBloomFilter(){
        return bf;
    }



}
