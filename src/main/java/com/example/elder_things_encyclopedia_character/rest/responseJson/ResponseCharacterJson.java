package com.example.elder_things_encyclopedia_character.rest.responseJson;

import lombok.Data;

@Data
public class ResponseCharacterJson {
    private String id;
    private String title;
    private String profile;

    public ResponseCharacterJson(String id, String title, String profile) {
        this.id = id;
        this.title = title;
        this.profile = profile;
    }
}
