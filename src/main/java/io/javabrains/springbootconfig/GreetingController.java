package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${app.description}")
    private String appDescription;

    @Value("passing static value")
    private String staticValue;

    @GetMapping("/greeting")
    public String greeting() {
        System.out.println(appDescription);
        return greetingMessage + staticValue;
    }
}
