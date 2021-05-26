package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/greeting")
    public String greeting() {
        System.out.println(appDescription);
        System.out.println(listOfValues);
        return greetingMessage +" " + staticValue +" "+ defaultValue;
    }
}
