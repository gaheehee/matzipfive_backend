package com.example.firstproject.controller;

import com.example.firstproject.model.Card;
//import com.example.firstproject.model.CardRestaurants;
import com.example.firstproject.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{cardId}")
    public Card getCardByCardId(@PathVariable Integer cardId) {
        return cardService.getCardByCardId(cardId);
    }

    // 해당 테마에 등록된 카드들 가져오기
    @GetMapping("/cardsByTheme/{themeId}")
    public List<Card> getCardsByThemeId(@PathVariable Integer themeId){
        return cardService.getCardsByThemeId(themeId);
    }

    @PostMapping("/registration/{themeId}/{userId}")
    public Card registerCard(@PathVariable Integer themeId, @PathVariable String userId, @RequestBody Card card) {
        return cardService.registerCard(themeId, userId, card);
    }

    // 카드 삭제될 때, cardRetaurant 테이블에서 해당 row들도 삭제되어야함.
    @DeleteMapping("/{cardId}")
    public void removeCard(@PathVariable Integer cardId ) {
        cardService.removeCard(cardId);
    }

    //card에 맛집 추가하기 - card_restaurant에 정보저장
    @PutMapping("/{cardId}/{restaurantId}")
    public void addRestaurantInCard(@PathVariable Integer cardId, @PathVariable Integer restaurantId) {
        cardService.addRestaurantInCard(cardId, restaurantId);
    }

    // 해당 card에서 해당 맛집 삭제
    @DeleteMapping("/{cardId}/{restaurantId}")
    public void removeRestaurantInCard(@PathVariable Integer cardId, @PathVariable Integer restaurantId){
        cardService.removeRestaurantInCard(cardId, restaurantId);
    }
}
