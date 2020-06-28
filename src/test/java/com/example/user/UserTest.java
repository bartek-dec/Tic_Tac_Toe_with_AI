package com.example.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void processCoordinatesWhenCorrectThenTrue() {
        assertTrue(user.processCoordinates("1 2"));
    }

    @Test
    void processCoordinatesWhenOutsideRangeThanFalse() {
        assertFalse(user.processCoordinates("1 4"));
    }

    @Test
    void processCoordinatesWhenLetterThanFalse() {
        assertFalse(user.processCoordinates("1 a"));
    }
}