package com.example.elder_things_encyclopedia_character.rest;

import com.example.elder_things_encyclopedia_character.domain.Character;
import com.example.elder_things_encyclopedia_character.driver.db.ElderThingsEncyclopedia;
import com.example.elder_things_encyclopedia_character.gateway.CharacterGateway;
import com.example.elder_things_encyclopedia_character.rest.config.ElderThingsEncyclopediaDataSourceConfig;
import com.example.elder_things_encyclopedia_character.rest.responseJson.ResponseCharacterJson;
import com.example.elder_things_encyclopedia_character.rest.responseJson.ResponseCharactersJson;
import com.example.elder_things_encyclopedia_character.useCase.GetCharacters;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CharactersResource {
    @RequestMapping(value = "/v1/characters", method = RequestMethod.GET)
    public ResponseEntity<ResponseCharactersJson> getCharacters() {
        ElderThingsEncyclopediaDataSourceConfig dataSourceConfig = new ElderThingsEncyclopediaDataSourceConfig();
        ResponseCharactersJson responseCharactersJson = new ResponseCharactersJson();

        try (Connection connection = dataSourceConfig.connect()) {
            ElderThingsEncyclopedia elderThingsEncyclopediaDriver = new ElderThingsEncyclopedia(connection);
            CharacterGateway characterGateway = new CharacterGateway(elderThingsEncyclopediaDriver);
            GetCharacters getCharactersUseCase = new GetCharacters(characterGateway);

            List<Character> characters = getCharactersUseCase.execute();

            List<ResponseCharacterJson> responseCharacterList = new ArrayList<>();

            for (Character character : characters) {
                ResponseCharacterJson characterResponseJson = new ResponseCharacterJson();
                characterResponseJson.setId(character.getId().toString());
                characterResponseJson.setTitle(character.getName());
                characterResponseJson.setProfile(character.getProfile());
                responseCharacterList.add(characterResponseJson);
            }

            responseCharactersJson.setCharacters(responseCharacterList);

            return ResponseEntity.ok(responseCharactersJson);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
