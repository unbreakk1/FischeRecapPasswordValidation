import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest
{
    @Test
        void shouldPassIfPasswordIsAtLeast8CharactersLong()
    {
        Assertions.assertTrue(Main.isLengthValid("password123")); // Valid password
        Assertions.assertTrue(Main.isLengthValid("abcdefgh")); // Valid password
    }

        @Test
        void shouldFailIfPasswordIsLessThan8Characters()
    {
        Assertions.assertFalse(Main.isLengthValid("1234567")); // Invalid password (7 chars)
        Assertions.assertFalse(Main.isLengthValid("abc")); // Invalid password
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

    @Test
    void shouldPassIfPasswordContainsBothLowercaseAndUppercaseLetters() {
        Assertions.assertTrue(Main.containsLowerAndUpperCase("Password123")); // Contains lowercase and uppercase
        Assertions.assertTrue(Main.containsLowerAndUpperCase("pAssword12")); // Contains lowercase and uppercase
    }

    @Test
    void shouldFailIfPasswordDoesNotContainBothLowercaseAndUppercaseLetters() {
        Assertions.assertFalse(Main.containsLowerAndUpperCase("password123")); // Only lowercase
        Assertions.assertFalse(Main.containsLowerAndUpperCase("PASSWORD123")); // Only uppercase
    }

    @Test
    void shouldBeWeakIfPasswordIsLessThan8Characters() {
        Assertions.assertTrue(Main.isWeakPassword("Passw1"));  // Too short
        Assertions.assertTrue(Main.isWeakPassword("abc123")); // Too short
    }

    @Test
    void shouldBeWeakIfPasswordDoesNotContainAnyDigit() {
        Assertions.assertTrue(Main.isWeakPassword("Password")); // No digits
        Assertions.assertTrue(Main.isWeakPassword("Shortpw")); // No digits
    }

    //-----------------------BONUS STUFF --------------------------------------------------------------
    @Test
    void shouldPassIfPasswordContainsSpecialCharacter() {
        Assertions.assertTrue(Main.containsSpecialCharacter("Password@123")); // Contains '@'
        Assertions.assertTrue(Main.containsSpecialCharacter("My$ecureP@ss")); // Contains '$' and '@'
    }

    @Test
    void shouldFailIfPasswordDoesNotContainSpecialCharacter() {
        Assertions.assertFalse(Main.containsSpecialCharacter("Password123")); // No special characters
        Assertions.assertFalse(Main.containsSpecialCharacter("mypassword"));  // No special characters
    }

    @Test
    void shouldPassIfPasswordMeetsAllCriteriaIncludingSpecialCharacter() {
        Assertions.assertTrue(Main.isValid("Password@123")); // Valid password with Special Character
    }

    @Test
    void shouldFailIfPasswordDoesNotIncludeSpecialCharacter() {
        Assertions.assertFalse(Main.isValid("Password123")); // Missing special character
    }


}
