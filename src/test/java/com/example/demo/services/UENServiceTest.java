package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UENServiceTest {

    static UENService uenService;

    @BeforeAll
    static void init() {
        uenService = new UENService();
    }

    @Test
    void testIsUENSuccess1() {
        String uenInput = "201707912H";
        assertTrue(uenService.isUEN(uenInput));
    }

    @Test
    void testIsUENSuccess2() {
        String uenInput = "S47TU0022K";
        assertTrue(uenService.isUEN(uenInput));
    }

    @Test
    void testIsUENSuccess3() {
        String uenInput = "T16LL0606F";
        assertTrue(uenService.isUEN(uenInput));
    }

    @Test
    void testIsUENSuccess4() {
        String uenInput = "53333178A";
        assertTrue(uenService.isUEN(uenInput));
    }

    @Test
    void testIsUENSuccess5() {
        String uenInput = "53333304X";
        assertTrue(uenService.isUEN(uenInput));
    }

    @Test
    void testIsUENFail1() {
        String uenInput = "";
        assertFalse(uenService.isUEN(uenInput));
    }

    @Test
    void testIsUENFail2() {
        String uenInput = "abc";
        assertFalse(uenService.isUEN(uenInput));
    }
}
