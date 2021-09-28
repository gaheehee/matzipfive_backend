package com.example.firstproject.service;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.CardRestaurantIds;
import com.example.firstproject.repository.CardRepository;
import com.example.firstproject.repository.CardRestaurantIdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    CardRestaurantIdsRepository cardRestaurantIdsRepository;

    public List<Card> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards;
    }

    public Card getCardByCardId(Integer cardId) {
        return cardRepository.getById(cardId);
    }

    public Card registerCard(Card card) {
        cardRepository.save(card);
        return card;
    }

    public void modifyCard(Integer cardId, Card card) {
        cardRepository.save(card);
    }

    public void removeCard(Integer cardId) {
        Optional<Card> card = cardRepository.findById(cardId);

        card.ifPresent(selectCard -> {
            cardRepository.delete(selectCard);
        });
    }

    // 해당 카드에 저장된 맛집 id 정보
    public List<CardRestaurantIds> getRestaurantsByCardId(Integer cardId) {
        List<CardRestaurantIds> cardRestaurantIds = cardRestaurantIdsRepository.findAllByCardId(cardId);
        return cardRestaurantIds;
    }
}
