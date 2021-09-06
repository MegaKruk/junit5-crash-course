package com.programming.techie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    @Test
    @DisplayName("Should create 1 contact")
    void addContact() {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Adam", "Smith", "0987654321");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should not create contact when firstName is null")
    void addContactNullFirstName() {
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Smith", "0987654321");
        });
    }

    @Test
    @DisplayName("Should not create contact when lastName is null")
    void addContactNullLastName() {
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Adam", null, "0987654321");
        });
    }

    @Test
    @DisplayName("Should not create contact when phoneNumber is null")
    void addContactNullPhoneNumber() {
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Adam", "Smith", null);
        });
    }

    @Test
    void getAllContacts() {
    }
}