package com.example.elder_things_encyclopedia_character.gateway;

import com.example.elder_things_encyclopedia_character.domain.Character;
import com.example.elder_things_encyclopedia_character.driver.db.ElderThingsEncyclopedia;
import com.example.elder_things_encyclopedia_character.driver.db.entity.CharacterJson;
import com.example.elder_things_encyclopedia_character.port.CharacterPort;

import java.util.ArrayList;
import java.util.List;

public class CharacterGateway implements CharacterPort {
    private final ElderThingsEncyclopedia elderThingsEncyclopediaDriver;

    public CharacterGateway(ElderThingsEncyclopedia elderThingsEncyclopediaDriver) {
        this.elderThingsEncyclopediaDriver = elderThingsEncyclopediaDriver;
    }

    @Override
    public List<Character> getCharacters() throws Exception {
        List<Character> characters = new ArrayList<>();
        List<CharacterJson> characterJsonList = elderThingsEncyclopediaDriver.getCharacters();
        for (CharacterJson characterJson : characterJsonList) {
            Character character = new Character(characterJson.getId(), characterJson.getTitle(), characterJson.getProfile());
            characters.add(character);
        }

        return characters;
    }
}
