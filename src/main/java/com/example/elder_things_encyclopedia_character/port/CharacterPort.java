package com.example.elder_things_encyclopedia_character.port;

import com.example.elder_things_encyclopedia_character.domain.Character;

import java.util.List;

public interface CharacterPort {
    List<Character> getCharacters() throws Exception;
}
