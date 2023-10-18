package ru.sidorov;


import java.util.*;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

    private String hand;
    private int rank;
    private List<String> values = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");

    private Map<Character, Integer> valueRank = new HashMap<>();
    private Map<Character, Integer> pairs = new HashMap<>();

    public PokerHand(String hand) {
        this.hand = hand;
        initializeValueRank();
        calculateRank();
    }

    public void initializeValueRank() {
        for (int i = 0; i < values.size(); i++) {
            valueRank.put(values.get(i).charAt(0), i);
        }
    }

    public void calculateRank() {
        String[] cards = hand.split(" ");
        Arrays.sort(cards, (a, b) -> valueRank.get(a.charAt(0)) - valueRank.get(b.charAt(0)));
        hand = Arrays.toString(cards);


        boolean isFlash = true;
        boolean isStreet = true;

        char prevSuit = cards[0].charAt(1);
        int strStart = valueRank.get(cards[0].charAt(0));

        for (int i = 1; i < cards.length; i++) {
            if (prevSuit != cards[i].charAt(1)) {
                isFlash = false;
            }
            if (valueRank.get(cards[i].charAt(0)) != strStart + i) {
                isStreet = false;
            }
            prevSuit = cards[i].charAt(1);
        }
        for (int i = 0; i < cards.length; i++) {
            if (pairs.containsKey(cards[i].charAt(0))) {
                pairs.put(cards[i].charAt(0), pairs.get(cards[i].charAt(0)) + 1);
            } else {
                pairs.put(cards[i].charAt(0), 1);
            }

        }
        int count = count(pairs);

        if (isFlash && isStreet) {
            if (cards[0].charAt(0) == 'T') {
                rank = 10;   // Флэш-роял
            } else {
                rank = 9;   //  Стрит-флэш
            }
        } else if (pairs.containsValue(4)) {
            rank = 8;       // Каре
        } else if (pairs.containsValue(3) && pairs.containsValue(2)) {
            rank = 7;       // Фулл-хаус
        } else if (isFlash) {
            rank = 6;
        } else if (isStreet) {
            rank = 5;
        } else if (pairs.containsValue(3) && !pairs.containsValue(2)) {
            rank = 4;       // Сет
        } else if (count == 2) {
            rank = 3;       // Две пары
        } else if (count == 1 && !pairs.containsValue(3)) {
            rank = 2;       // Пара
        } else {
            rank = 1;
        }

    }

    public int count(Map<Character, Integer> pairs) {
        int count = 0;
        for (Map.Entry<Character, Integer> pair : pairs.entrySet()) {
            if (pair.getValue() == 2) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int compareTo(PokerHand otherHand) {
        if (this.rank < otherHand.rank) return 1;
        else if (this.rank > otherHand.rank) return -1;
        else return this.hand.compareTo(otherHand.hand);
    }

    public String getHand() {
        return this.hand;
    }

    public int getRank() {
        return this.rank;
    }

    public Map<Character, Integer> getValueRank() {
        return valueRank;
    }

    public Map<Character, Integer> getPairs() {
        return pairs;
    }
}