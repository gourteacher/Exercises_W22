package com.cst2335.exercises;

import static org.junit.Assert.*;

import com.cst2335.exercises.utils.EmailValidator;

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
    public void isValid_true() {
    }

    @Test
    public void isValid_false() {
    }

    @Test
    public void isValidEmail() {
    }

    @Test
    public void afterTextChanged() {



    }

    @Test
    public void beforeTextChanged() {
    }

    @Test
    public void onTextChanged() {
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