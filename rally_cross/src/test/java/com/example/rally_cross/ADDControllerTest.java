package com.example.rally_cross;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ADDControllerTest {
    @Test
    void ADDValidation() {
        ADDController test = new ADDController();
        assertTrue(test.addValidation("mandinu", "25", "ddx", "honda", "39")) ;

    }
}