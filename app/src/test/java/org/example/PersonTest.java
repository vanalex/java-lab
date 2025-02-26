package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.records.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Test
    public void testDefaultPerson() {
        Person johnDoe = Person.createDefault();
        Assertions.assertNotNull(johnDoe);
        assertEquals("John Doe", johnDoe.name());
        assertEquals(23, johnDoe.age());
        assertEquals("johndoe@example.com", johnDoe.email());
    }

    @Test
    public void testPersonBlankNameThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person johnDoe = new Person("", -1, "");
        });

        // Method 2: Asserting the exception message
        assertEquals("name cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testPersonAgeNegativeThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person maryDoe = new Person("mary", -1, "");
        });

        // Method 2: Asserting the exception message
        assertEquals("age cannot be negative", exception.getMessage());
    }

    @Test
    public void testPersonEmailBlankThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person maryDoe = new Person("mary", 1, "");
        });

        // Method 2: Asserting the exception message
        assertEquals("email cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testSerializePerson() throws JsonProcessingException {
        Person johnDoe = new  Person("John Doe", 23, "johndoe@example.com");
        String result = mapper.writeValueAsString(johnDoe);
        String expected = """
                {
                  "name" : "John Doe",
                  "age" : 23,
                  "email" : "johndoe@example.com",
                  "fullDetails" : "Name: John Doe, Age: 23, Email: johndoe@example.com"
                }""";
        assertEquals(expected, result);
    }
}
