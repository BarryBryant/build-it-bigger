package com.example;

import java.util.Random;

public class JokeWizard {

    public String getJoke(){
        Random rand = new Random();
        int key = rand.nextInt(3);
        String joke = "";
        switch (key){
            case 0: joke = "cool";
            break;
            case 1: joke = "swell";
            break;
            case 2: joke = "awesome";
            break;

        }
        return joke;
    }

}
