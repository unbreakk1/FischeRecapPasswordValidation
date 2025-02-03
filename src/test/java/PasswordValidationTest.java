import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest
{
    @Test
        void shouldPassIfPasswordIsAtLeast8CharactersLong()
    {
        Assertions.assertTrue(Main.isValid("password123")); // Valid password
        Assertions.assertTrue(Main.isValid("abcdefgh")); // Valid password
    }

        @Test
        void shouldFailIfPasswordIsLessThan8Characters()
    {
        Assertions.assertFalse(Main.isValid("1234567")); // Invalid password (7 chars)
        Assertions.assertFalse(Main.isValid("abc")); // Invalid password
    }

    @Test
    void shouldPassIfPasswordContainsAtLeastOneDigit()
    {
        Assertions.assertTrue(Main.containsDigit("password123")); // Contains digits
        Assertions.assertTrue(Main.containsDigit("1password")); // Contains digits
    }

    @Test
    void shouldFailIfPasswordDoesNotContainAnyDigit()
    {
        Assertions.assertFalse(Main.containsDigit("password")); // No digits
        Assertions.assertFalse(Main.containsDigit("abcdefgh")); // No digits
    }

}
