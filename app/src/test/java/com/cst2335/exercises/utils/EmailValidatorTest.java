package com.cst2335.exercises.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EmailValidatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("myname@gmail.com"));
    }

    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("myname@company.co.uk"));
    }


    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@company"));
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@company..com"));
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@company.com"));
    }
    @Test
    public void emailValidator_UserNamwOnly_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("myname"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_AtEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@"));
    }


    @Test
    public void emailValidator_throwsException() throws Exception {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> EmailValidator.isValidEmail(null));
        assertEquals("Email Argument cannot be null", exception.getMessage());
    }
}