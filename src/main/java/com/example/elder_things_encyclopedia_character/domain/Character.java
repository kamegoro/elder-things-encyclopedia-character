package com.example.elder_things_encyclopedia_character.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Character {
    private final UUID id;
    private final String name;
    private final String profile;

    public Character(UUID id, String name, String profile) {
        this.id = id;
        this.name = name;
        this.profile = profile;
    }
}
