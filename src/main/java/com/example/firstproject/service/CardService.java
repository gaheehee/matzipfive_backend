package com.example.firstproject.service;

import com.example.firstproject.dao.CardDao;
import com.example.firstproject.model.Card;
import com.example.firstproject.model.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardDao cardDao;

    public List<Card> getAllCards() { return cardDao.getAllCards(); }

    public Card getCardByCardId(Integer cardId) { return cardDao.getCardByCardId(cardId); }

    public Card registerCard(Card card) { return cardDao.insertCard(card); }

    public void modifyCard(Integer cardId, Card card) { cardDao.updateCard(cardId, card); }

    public void removeCard(Integer cardId) { cardDao.deleteCard(cardId); }

}
