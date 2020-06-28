package com.example.level;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ComputerEasyTest {

    private ComputerEasy computerEasy;
    private Random random;

    @BeforeEach
    void setUp() {
        random = Mockito.mock(Random.class);
        computerEasy = new ComputerEasy(random);
    }

    @Test
    void chooseCoordinate() {
        when(random.nextInt(3)).thenReturn(1);
        assertEquals("22", computerEasy.chooseCoordinate());
    }
}