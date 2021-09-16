package com.example.firstproject.dao;

import com.example.firstproject.model.Card;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class CardDao {

    public static List<Card> cards;

    public static List<Integer> card_restaurantIds_1;
    public static List<Integer> card_restaurantIds_2;
    public static List<Integer> card_restaurantIds_3;

    static{
        card_restaurantIds_1 = new ArrayList<>();
        card_restaurantIds_1.add(1); card_restaurantIds_1.add(2); card_restaurantIds_1.add(3);
    }
    static{
        card_restaurantIds_2 = new ArrayList<>();
        card_restaurantIds_2.add(1); card_restaurantIds_2.add(2); card_restaurantIds_2.add(3);
    }
    static{
        card_restaurantIds_3 = new ArrayList<>();
        card_restaurantIds_3.add(1); card_restaurantIds_3.add(2); card_restaurantIds_3.add(3);
    }

    static {
        cards = new ArrayList<>();
        cards.add(new Card(1,"user1","2021년 09월 16일, 오후 02:17",card_restaurantIds_1));
        cards.add(new Card(2,"user2","2021년 09월 16일, 오후 02:17",card_restaurantIds_2));
        cards.add(new Card(3,"user3","2021년 09월 16일, 오후 02:17",card_restaurantIds_3));
    }

    public List<Card> getAllCards() {
        return cards;
    }

    public Card getCardByCardId(Integer cardId) {
        return cards
                .stream()
                .filter(card -> card.getCardId().equals(cardId))
                .findAny()
                .orElse(new Card(-1,"",null, null));
    }

    public Card insertCard(Card card) {

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        card.createdAt = timeStamp;
        cards.add(card);

        return card;
    }

    public void updateCard(Integer cardId, Card card) {
        //Optional<Card> anyElement = cards.stream().filter(curCard -> curCard.getCardId().equals(cardId)).findAny();
        cards.stream()
                .filter(curCard -> curCard.getCardId().equals(cardId))
                .findAny()
                .orElse(new Card(-1,"",null,null))
                .setCard_restaurantIds(card.getCard_restaurantIds());
    }

    public void deleteCard(Integer cardId) {
        cards.removeIf(card -> card.getCardId().equals(cardId));
    }

}
