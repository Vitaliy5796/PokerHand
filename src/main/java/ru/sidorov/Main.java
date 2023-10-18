package ru.sidorov;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        PokerHand hand1 = new PokerHand("2D JD JS JC JH"); // Каре 8
        PokerHand hand2 = new PokerHand("2D 2S TS TC JH"); // Две пары 3
        PokerHand hand3 = new PokerHand("2D 2H 2S JC JH"); // Фулл-хаус 7
        PokerHand hand4 = new PokerHand("2D 2H 2S AC JH"); // Сет 4
        PokerHand hand5 = new PokerHand("2D 3D 4S 5C AH"); // Старшая A 1
        PokerHand hand6 = new PokerHand("2D 3D 4S 5C KH"); // Старшая K 1
        PokerHand hand7 = new PokerHand("TD JD QD KD AD"); // Флэш-роял 10
        PokerHand hand8 = new PokerHand("9D TD JD QD KD"); // Стрит-флэш 9
        PokerHand hand9 = new PokerHand("9D TS JH 9H KD"); // Пара 2
        PokerHand hand10 = new PokerHand("9D TS JH QH KD"); // Стрит 5
        PokerHand hand11 = new PokerHand("9D JD 2D KD 5D"); // Флэш 6

        List<PokerHand> list = new ArrayList<>();
        list.add(hand1);
        list.add(hand2);
        list.add(hand3);
        list.add(hand4);
        list.add(hand5);
        list.add(hand6);
        list.add(hand7);
        list.add(hand8);
        list.add(hand9);
        list.add(hand10);
        list.add(hand11);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " = " + list.get(i).getHand() + " с рангом: " + list.get(i).getRank());
        }
    }
}