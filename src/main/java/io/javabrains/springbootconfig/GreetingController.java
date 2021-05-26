package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${app.description}")
    private String appDescription;

    @Value("passing static value")
    private String staticValue;

    @Value("${my.notExistingProp: default: Some Default Value}")
    private String defaultValue;

    @Value("${my.list.values}")
    private List<String> listOfValues;

    @Value("#{${my.db.mapValues}}") // pay attention to this line
    private Map<String, String> myDbValues;

    @Value("${my.list.values}")
    private List<String> DbSettings;

    @GetMapping("/greeting")
    public String greeting() {
        System.out.println(appDescription);
        System.out.println(listOfValues);
        System.out.println();
        return greetingMessage +" " + staticValue +" "+ defaultValue + " " + myDbValues;
    }
}
