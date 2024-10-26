package com.example.elder_things_encyclopedia_character.rest.responseJson;

import lombok.Data;

import java.util.List;

@Data
public class ResponseCharactersJson {
    private List<ResponseCharacterJson> characters;
}
