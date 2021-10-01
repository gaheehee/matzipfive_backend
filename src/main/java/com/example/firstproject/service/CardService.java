package com.example.firstproject.service;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.CardRestaurant;
import com.example.firstproject.model.Theme;
import com.example.firstproject.model.User;
import com.example.firstproject.repository.CardRepository;
import com.example.firstproject.repository.CardRestaurantRepository;
import com.example.firstproject.repository.ThemeRepository;
import com.example.firstproject.repository.UserRepository;
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
    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    UserRepository userRepository;


    public List<Card> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards;
    }

    public Card getCardByCardId(Integer cardId) {
        return cardRepository.getById(cardId);
    }

    public List<Card> getCardsByThemeId(Integer themeId){
        List<Card> cards = cardRepository.findAllByTheme(themeRepository.getById(themeId));
        return cards;
    }


    public Card registerCard(Integer themeId, String userId, Card card) {

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        card.createdAt = timeStamp;
        cardRepository.save(card);

        Theme theme = themeRepository.getById(themeId);
        card.setTheme(theme);

        //카드 추가하면 테마 테이블에서 cardNum++
        theme.setCardNum(theme.getCardNum()+1);
        themeRepository.save(theme);

        User user = userRepository.getById(userId);
        card.setUser(user);

        cardRepository.save(card);
        return card;
    }

    public void removeCard(Integer cardId) {

        //카드 삭제하면 테마 테이블에서 cardNum--
        Card card1 = cardRepository.getById(cardId);
        Theme theme = card1.getTheme();
        theme.setCardNum(theme.getCardNum()-1);
        themeRepository.save(theme);

        Optional<Card> card = cardRepository.findById(cardId);
        card.ifPresent(selectCard -> {
            cardRepository.delete(selectCard);
        });

        cardRestaurantRepository.deleteByCardId(cardId);
    }

    public void addRestaurantInCard(Integer cardId, Integer restaurantId) {
        CardRestaurant cardRestaurant = new CardRestaurant();

        cardRestaurant.setCardId(cardId);
        cardRestaurant.setRestaurantId(restaurantId);

        cardRestaurantRepository.save(cardRestaurant);
    }

    public void removeRestaurantInCard(Integer cardId, Integer restaurantId) {
        cardRestaurantRepository.deleteByCardIdAndRestaurantId(cardId, restaurantId);
    }

}
