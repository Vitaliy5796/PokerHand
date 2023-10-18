package ru.sidorov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandTest {

    @Test
    void initializeValueRank() {
        PokerHand hand = new PokerHand("2D 2H 2S AC JH");
        assertEquals(0, hand.getValueRank().get('2').intValue());
        assertEquals(9, hand.getValueRank().get('J').intValue());
        assertEquals(12, hand.getValueRank().get('A').intValue());
    }

    @Test
    void calculateRank() {
        PokerHand hand1 = new PokerHand("2D JD JS JC JH"); // Каре 8
        PokerHand hand2 = new PokerHand("2D 2S TS TC JH"); // Две пары 3
        PokerHand hand3 = new PokerHand("2D 2H 2S JC JH"); // Фулл-хаус 7
        PokerHand hand4 = new PokerHand("2D 2H 2S AC JH"); // Сет 4
        PokerHand hand5 = new PokerHand("2D 3D 4S 5C AH"); // Старшая A 1
        PokerHand hand6 = new PokerHand("TD JD QD KD AD"); // Флэш-роял 10
        PokerHand hand7 = new PokerHand("9D TD JD QD KD"); // Стрит-флэш 9
        PokerHand hand8 = new PokerHand("9D TS JH 9H KD"); // Пара 2
        PokerHand hand9 = new PokerHand("9D TS JH QH KD"); // Стрит 5
        PokerHand hand10 = new PokerHand("9D JD 2D KD 5D"); // Флэш 6

        assertEquals(8, hand1.getRank());
        assertEquals(3, hand2.getRank());
        assertEquals(7, hand3.getRank());
        assertEquals(4, hand4.getRank());
        assertEquals(1, hand5.getRank());
        assertEquals(10, hand6.getRank());
        assertEquals(9, hand7.getRank());
        assertEquals(2, hand8.getRank());
        assertEquals(5, hand9.getRank());
        assertEquals(6, hand10.getRank());

    }

    @Test
    void compareTo() {
        PokerHand hand1 = new PokerHand("TD JD QD KD AD");
        PokerHand hand2 = new PokerHand("9D TD JD QD KD");

        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);

        PokerHand hand3 = new PokerHand("2D 2S TS TC JH");
        PokerHand hand4 = new PokerHand("2D 2H 2S JC JH");

        result = hand3.compareTo(hand4);
        assertEquals(1, result);

        result = hand1.compareTo(hand4);
        assertEquals(-1, result);
    }

    @Test
    void count() {
        PokerHand hand1 = new PokerHand("2D 2S TS TC JH");
        PokerHand hand2 = new PokerHand("9D TS JH 9H KD");

        int result = hand1.count(hand1.getPairs());
        assertEquals(2, result);

        result = hand2.count(hand2.getPairs());
        assertEquals(1, result);
    }
}