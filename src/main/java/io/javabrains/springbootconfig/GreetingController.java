package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

// we can run any profile using @Profile("test") annotation as well
@RestController
@EnableAutoConfiguration
@Configuration
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

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private Environment environment;

    @GetMapping("/greeting")
    public String greeting() {
        System.out.println(appDescription);
        System.out.println(listOfValues);
        System.out.println();
        return dbSettings.getConnection() + " " + dbSettings.getHost() + " " + dbSettings.getPort();
    }


    @GetMapping("/envdetails")
    public String getEnvDetails() {
        return environment.toString();
    }
}
