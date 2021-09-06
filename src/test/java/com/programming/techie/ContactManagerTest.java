package com.programming.techie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

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
    @DisplayName("Should create 1 contact on Linux")
    @EnabledOnOs(value = OS.LINUX, disabledReason = "Enabled only on Linux")
    void addContactLinux() {
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
    @DisplayName("Should create 1 contact on Windows")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Enabled only on Windows")
    void addContactWindows() {
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
    @DisplayName("Should create 1 contact on developer machine")
    void addContactOnDev() {
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        contactManager.addContact("Adam", "Smith", "0987654321");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Adam") &&
                        contact.getLastName().equals("Smith") &&
                        contact.getPhoneNumber().equals("0987654321"))
        );
    }

    @RepeatedTest(value = 5,
            name = "Repeating add contact test {currentRepetition} of {totalRepetitions}")
    @DisplayName("Should create 1 contact repeatedly")
    void addContactRepeated() {
        contactManager.addContact("Adam", "Smith", "0987654321");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Adam") &&
                        contact.getLastName().equals("Smith") &&
                        contact.getPhoneNumber().equals("0987654321"))
        );
    }
}