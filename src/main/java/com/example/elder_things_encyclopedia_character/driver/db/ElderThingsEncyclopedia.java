package com.example.elder_things_encyclopedia_character.driver.db;

import com.example.elder_things_encyclopedia_character.driver.db.entity.CharacterJson;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Scope(value = "singleton")
public class ElderThingsEncyclopedia {
    private final Connection connection;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ElderThingsEncyclopedia.class);

    public ElderThingsEncyclopedia(Connection connection) {
        this.connection = connection;
    }

    public List<CharacterJson> getCharacters() throws Exception {
        List<CharacterJson> characters = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM elder_things_encyclopedia.character";
            ResultSet result = statement.executeQuery(SQL);

            while (result.next()) {
                UUID id = UUID.fromString(result.getString("id"));
                String title = result.getString("title");
                String profile = result.getString("profile");

                CharacterJson characterJson = new CharacterJson(id, title, profile);
                characters.add(characterJson);
            }

            return characters;
        } catch (Exception e) {
            logger.error("Error while fetching characters", e);
            throw e;
        }
    }
}