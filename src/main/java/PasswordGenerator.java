import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator
{
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?/{}[]|~";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
    private static final int DEFAULT_PASSWORD_LENGTH = 12; //


    public static String generateSecurePassword()
    {
        return generateSecurePassword(DEFAULT_PASSWORD_LENGTH);
    }

    public static String generateSecurePassword(int length)
    {
        if(length<8)
            try {
                throw new IllegalAccessException("Password have at least 8 characters");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        password.append(getRandomCharacter(UPPERCASE,random));
        password.append(getRandomCharacter(LOWERCASE,random));
        password.append(getRandomCharacter(DIGITS,random));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS,random));


        for(int i =4; i<length;i++)
        {
            password.append(getRandomCharacter(ALL_CHARACTERS,random));
        }

        List<Character> passwordCharacters = new ArrayList<>();
        for(char c : password.toString().toCharArray())
        {
            passwordCharacters.add(c);
        }

        Collections.shuffle(passwordCharacters, random);

        StringBuilder finalPassword = new StringBuilder();
        for(char c : passwordCharacters)
            finalPassword.append(c);

        return finalPassword.toString();
    }

    private static char getRandomCharacter(String characterSet, SecureRandom random)
    {
        int index = random.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }
}
