package com.wd.online;

import com.wd.online.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    public void increaseScore(int points) {
        score += points;
    }
}

