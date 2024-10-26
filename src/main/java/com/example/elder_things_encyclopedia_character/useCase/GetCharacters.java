package com.example.elder_things_encyclopedia_character.useCase;

import com.example.elder_things_encyclopedia_character.domain.Character;
import com.example.elder_things_encyclopedia_character.port.CharacterPort;

import java.util.List;

public class GetCharacters {
    private final CharacterPort characterPort;

    public GetCharacters(CharacterPort characterPort) {
        this.characterPort = characterPort;
    }

    public List<Character> execute() throws Exception {
        return characterPort.getCharacters();
    }
}
