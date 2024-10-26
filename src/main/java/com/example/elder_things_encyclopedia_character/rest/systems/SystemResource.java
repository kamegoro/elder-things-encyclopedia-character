package com.example.elder_things_encyclopedia_character.rest.systems;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemResource {
   @RequestMapping(value = "/v1/systems/ping", method = RequestMethod.GET)
   public String ping() {
       return "pong";
   }
}
