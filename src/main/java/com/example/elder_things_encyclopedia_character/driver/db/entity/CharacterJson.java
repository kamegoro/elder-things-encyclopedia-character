package com.example.elder_things_encyclopedia_character.driver.db.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class CharacterJson {
    private UUID id;
    private String title;
    private String profile;

    public CharacterJson(UUID id, String title, String profile) {
        this.id = id;
        this.title = title;
        this.profile = profile;
    }
}