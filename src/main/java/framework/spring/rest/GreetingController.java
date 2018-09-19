package framework.spring.rest;

import framework.jackson.FileCalculationMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public List<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return Arrays.asList(new Greeting(counter.incrementAndGet(),
                String.format(template, name)));
    }

    @RequestMapping("testEnum")
    public FileCalculationMethod[] testEnum() {
        return FileCalculationMethod.values();
    }

}