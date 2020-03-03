package com.avnsystems;

import sun.plugin2.message.Message;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        //List<String> words = Arrays.asList("Hazelnut","Mystify","Cuttlefish","Lark","Lurk","Robert","Anglican","Pheromone","Haltertop","Marmalade","Hardware","Laser","Pepper","Release","Kneecap","Falafel","Period","Chaste","Chased","Leggings","Wool","Sweater","Heartbeat","Heartbeat","Heart","Beat","Heart","Beat","Beat","Beat","Beat","Beat");
        List<String> words = Files.readAllLines(new File("wordlist.txt").toPath());

        double percentage = 100;
        percentage *= 0.01;

        System.out.println("Percentage: " + percentage);
        Set spagsetti = new Set();



        System.out.println("Adding " + percentage * 100 + "% of the words. (" + words.size() * percentage + ")");
        for(int i = 0; i != Math.floor(words.size() * percentage) - 1; i++){
            spagsetti.add(words.get(i));
        }
        System.out.println("Words added.");
        System.out.println("Last word added: " + words.get((int)Math.floor(words.size() * percentage) - 1));

        for(int i = 0; i != 1000; i++) {

            String randomWord = "";
            Random ayn = new Random();
            int randomIndex = ayn.nextInt(words.size() - 1);
            randomWord = words.get(randomIndex);
            System.out.println("Set contains: " + randomWord + "? " + spagsetti.contains(randomWord));

            if((randomIndex > words.size() * percentage) && spagsetti.contains(randomWord)){
                System.out.println("(False positive likely).");
            }

        }

        System.out.println("Set contains: " + "camiblammi" + "? " + spagsetti.contains("camiblammi"));


        //System.out.println(spagsetti.getBloomFilter().bitset);
    }
}
