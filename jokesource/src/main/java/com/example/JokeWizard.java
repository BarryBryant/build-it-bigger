package com.example;

import java.util.Random;

public class JokeWizard {

    public String getJoke(){
        Random rand = new Random();
        int key = rand.nextInt(6);
        String joke = "";
        switch (key){
            case 0: joke = "I used to think the brain was the most important organ. Then I thought... Look what's telling me that.";
            break;
            case 1: joke = "The midget fortune teller who kills his customers is a small medium at large.";
            break;
            case 2: joke = "The dyslexic devil worshipper sold his soul to Santa.";
            break;
            case 3: joke = "What kind of shoes do ninjas wear? Sneakers.";
            break;
            case 4: joke = "What did one developer say to the next? Want to get a byte to eat?";
            break;
            case 5: joke = "What's the best part about living in Switzerland? Not sure, but the flag is a big plus.";
            break;

        }
        return joke;
    }

}
