package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "themecardids")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ThemeCardIds {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "theme_id")
    private Integer themeId;
    @Column(name = "card_id")
    private Integer cardId;

    @JsonCreator
    @Builder
    public ThemeCardIds(@JsonProperty("id") Integer id,
                        @JsonProperty("theme_id") Integer themeId,
                        @JsonProperty("card_id") Integer cardId) {
        this.id = id;
        this.themeId = themeId;
        this.cardId = cardId;
    }
}
