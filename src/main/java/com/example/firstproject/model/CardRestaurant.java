package com.example.firstproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "card_restaurant")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CardRestaurant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
}
