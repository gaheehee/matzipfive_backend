package com.example.firstproject.service;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.CardRestaurant;
import com.example.firstproject.repository.CardRepository;
import com.example.firstproject.repository.CardRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    CardRestaurantRepository cardRestaurantRepository;

    public List<Card> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards;
    }

    public Card getCardByCardId(Integer cardId) {
        return cardRepository.getById(cardId);
    }

    // 해당 테마에 등록된 카드들 가져오기
    public List<Card> getCardsByThemeId(Integer themeId){
        List<Card> cards = cardRepository.findAllByThemeId(themeId);
        return cards;
    }

    public Card registerCard(Card card) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        card.createdAt = timeStamp;
        cardRepository.save(card);
        return card;
    }

    // 카드 삭제하면 cardRestaurant에서 해당 카드 관련 row 다 삭제되나?
    public void removeCard(Integer cardId) {
        Optional<Card> card = cardRepository.findById(cardId);

        card.ifPresent(selectCard -> {
            cardRepository.delete(selectCard);
        });
    }

    // 카드에 맛집 추가
    public void addRestaurantInCard(Integer cardId, Integer restaurantId) {
        CardRestaurant cardRestaurant = new CardRestaurant();
        cardRestaurant.setCard(cardRepository.getById(cardId));
        cardRestaurant.setRestaurantId(restaurantId);

        cardRestaurantRepository.save(cardRestaurant);
    }

    // 카드 안의 해당 맛집 삭제
    public void removeRestaurantInCard(Integer cardId, Integer restaurantId) {
        cardRestaurantRepository.deleteByCardIdAndRestaurantId(cardId, restaurantId);
    }

    // 해당 카드에 저장된 맛집 id 정보
    /*public List<CardRestaurants> getRestaurantsByCardId(Integer cardId) {
        List<CardRestaurants> cardRestaurantIds = cardRestaurantIdsRepository.findAllByCardId(cardId);
        return cardRestaurantIds;
    }*/
}
