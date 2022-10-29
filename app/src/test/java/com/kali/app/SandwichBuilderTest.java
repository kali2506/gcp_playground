package com.kali.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.kali.app.Builder.Sandwich;
import com.kali.app.Builder.SandwichBuilder;

import org.junit.Ignore;
import org.junit.Test;

public class SandwichBuilderTest {

    @Ignore
    @Test
    public void firstSandwitchTest() {

        Sandwich sandwich = new SandwichBuilder()
                .setAufschnitt("Salami")
                .setSalat(true)
                .setBrotArt("Baguette")
                .setAuftstrich("Butter")
                .build();

        assertNull(sandwich.getKäse());
        assertDoesNotThrow(() -> sandwich.getKäse());
    }

    @Test
    public void secondSandwitchTest() {

        Sandwich sandwich = new SandwichBuilder().build();

        assertAll(
            ()->assertNull(sandwich.getAufschnitt()),
            ()->assertNull(sandwich.getAufstrich()),
            ()->assertNull(sandwich.getBrotArt())
            );
    }

}
