package com.example.firstproject.controller;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.CardRestaurantIds;
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

    // 해당 카드에 저장된 맛집 id 정보
    @GetMapping("/restaurantsInCard/{cardId}")
    public List<CardRestaurantIds> getRestaurantsByCardId(@PathVariable Integer cardId){
        return cardService.getRestaurantsByCardId(cardId);
    }

    @PostMapping("")
    public Card registerCard(@RequestBody Card card) {
        return cardService.registerCard(card);
    }

    @PutMapping("/{cardId}")
    public void modifyCard(@PathVariable Integer cardId, @RequestBody Card card) {
        cardService.modifyCard(cardId, card);
    }

    @DeleteMapping("/{cardId}")
    public void removeCard(@PathVariable Integer cardId ) {
        cardService.removeCard(cardId);
    }


}
