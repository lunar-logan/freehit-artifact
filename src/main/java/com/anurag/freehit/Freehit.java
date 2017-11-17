package com.anurag.freehit;

import com.anurag.freehit.common.ConfigUtils;
import com.anurag.freehit.common.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
@EnableAutoConfiguration
public class Freehit {
    public static void main(String[] args) {
        SpringApplication.run(Freehit.class, args);
    }

    @Bean
    public Random getRandom() {
        Long seed = ConfigUtils.getLongScalar(Property.RNG_SEED);
        seed = (seed == null ? System.nanoTime() : seed);
        return new Random(seed);
    }
}
