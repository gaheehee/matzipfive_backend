package com.example.firstproject.dao;

import com.example.firstproject.model.Card;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardDao {

    public static List<Card> cards;

    static {
        cards = new ArrayList<>();
        cards.add(new Card(1,"user1","2021년 8월 9일 1:15 PM"));
        cards.add(new Card(2,"user2","2020년 9월 10일 4:26 PM"));
        cards.add(new Card(3,"user3","2019년 5월 11일 2:46 PM"));
    }

    public List<Card> getAllCards() {
        return cards;
    }

    public Card getCardByCardId(Integer cardId) {
        return cards
                .stream()
                .filter(card -> card.getCardId().equals(cardId))
                .findAny()
                .orElse(new Card(-1,"",""));
    }

    public Card insertCard(Card card) {
        cards.add(card);
        return card;
    }

    public void updateCard(Integer cardId, Card card) {
        cards.stream()
                .filter(curCard -> curCard.getCardId().equals(cardId))
                .findAny()
                .orElse(new Card(-1,"",""))
                .setCreatedAt(card.getCreatedAt());
    }

    public void deleteCard(Integer cardId) {
        cards.removeIf(card -> card.getCardId().equals(cardId));
    }

}
