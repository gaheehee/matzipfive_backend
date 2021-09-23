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

    public List<Integer> MockCardRestaurantIds = new ArrayList<>();
    { MockCardRestaurantIds.add(1); MockCardRestaurantIds.add(2); MockCardRestaurantIds.add(3); }

    public List<Card> MockCards = new ArrayList<>();
    {
        MockCards.add(new Card(1,"user1","2021년 09월 16일, 오후 02:17",MockCardRestaurantIds));
        MockCards.add(new Card(2,"user2","2021년 09월 16일, 오후 02:17",MockCardRestaurantIds));
        MockCards.add(new Card(3,"user3","2021년 09월 16일, 오후 02:17",MockCardRestaurantIds));
    }

    public List<Card> getAllCards() {
        return MockCards;
    }

    public Card getCardByCardId(Integer cardId) {
        return MockCards
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
        MockCards.add(card);

        return card;
    }

    public void updateCard(Integer cardId, Card card) {
        //Optional<Card> anyElement = cards.stream().filter(curCard -> curCard.getCardId().equals(cardId)).findAny();
        MockCards.stream()
                .filter(curCard -> curCard.getCardId().equals(cardId))
                .findAny()
                .orElse(new Card(-1,"",null,null))
                .setCard_restaurantIds(card.getCard_restaurantIds());
    }

    public void deleteCard(Integer cardId) {
        MockCards.removeIf(card -> card.getCardId().equals(cardId));
    }

}
