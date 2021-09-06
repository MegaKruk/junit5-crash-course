package com.programming.techie;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    ContactManager contactManager;

    @BeforeEach
    public void setup() {
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Should create 1 contact")
    void addContact() {
        contactManager.addContact("Adam", "Smith", "0987654321");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Adam") &&
                        contact.getLastName().equals("Smith") &&
                        contact.getPhoneNumber().equals("0987654321"))
        );
    }

    @Test
    @DisplayName("Should not create contact when firstName is null")
    void addContactNullFirstName() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Smith", "0987654321");
        });
    }

    @Test
    @DisplayName("Should not create contact when lastName is null")
    void addContactNullLastName() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Adam", null, "0987654321");
        });
    }

    @Test
    @DisplayName("Should not create contact when phoneNumber is null")
    void addContactNullPhoneNumber() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Adam", "Smith", null);
        });
    }

    @Test
    void getAllContacts() {
    }
}