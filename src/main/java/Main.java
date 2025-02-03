
public class Main
{
    public static final String RESET = "\u001B[0m";  // Reset to default color
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void main(String[] args)
    {
        String myPassword = PasswordGenerator.generateSecurePassword();

        if(isValid(myPassword))
            System.out.println(GREEN + "Password: " + myPassword + " is a valid password." + RESET);
        else
            System.out.println(RED + "Password : " + myPassword + " is NOT a valid password"+ RESET);
    }

    public static boolean isValid(String password)
    {
        return  isLengthValid(password) &&
                containsDigit(password) &&
                containsLowerAndUpperCase(password) &&
                containsSpecialCharacter(password);
    }

    public static boolean isWeakPassword(String password)
    {
        return isLengthValid(password) &&
            (  !containsDigit(password) ||
               !containsLowerAndUpperCase(password) ||
               !containsSpecialCharacter(password));
    }

    public static boolean isLengthValid(String password)
    {
        return password != null && password.length() >= 8;
    }

    public static boolean containsDigit(String password)
    {
        for (char c : password.toCharArray())
        {
            if (Character.isDigit(c))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean containsLowerAndUpperCase(String password)
    {
        boolean hasLower = false;
        boolean hasUpper = false;

        for (char c : password.toCharArray())
        {
            if (Character.isLowerCase(c))
                hasLower = true;
            else if (Character.isUpperCase(c))
                hasUpper = true;

            // break early if both conditions are met.
            if (hasLower && hasUpper)
                return true;
        }

        return false;
    }

    //----------------------- BONUS STUFF -------------------------------------------------------------

    public static boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray())
        {
            if (!Character.isLetterOrDigit(c)) // Not a letter or digit = special character
            {
                return true;
            }
        }

        return false;

        // You could also use this if you want more control/or want to exclude characters
        // return password.matches(".*[!@#$%^&*()\-_=+\[\]{};:'",.<>?/`~].*");
    }
}