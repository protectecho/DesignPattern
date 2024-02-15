package com.wd.online;

import com.wd.online.Card;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardComparator implements Comparator<Card> {
    private Map<String, Integer> suitRank = new HashMap<>();

    public CardComparator() {
        suitRank.put("K", 6); // 大王
        suitRank.put("Q", 5); // 小王
        suitRank.put("D", 4); // 黑桃
        suitRank.put("C", 3); // 红桃
        suitRank.put("B", 2); // 梅花
        suitRank.put("A", 1); // 方片
    }

    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getRank() != card2.getRank()) {
            return card2.getRank() - card1.getRank();
        }
        return suitRank.get(card2.getSuit()) - suitRank.get(card1.getSuit());
    }
}

