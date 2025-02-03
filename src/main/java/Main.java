
public class Main
{
    public static void main(String[] args)
    {

    }

    public static boolean isValid(String password)
    {
        return  isLengthValid(password) &&
                containsDigit(password) &&
                containsLowerAndUpperCase(password) &&
                containsSpecialCharacter(password);

    }

    public static boolean isWeakPassword(String password) {
        return !isValid(password); // A password is weak if it does not meet all criteria
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


            // If both conditions are satisfied, we can break early.
            if (hasLower && hasUpper)
            {
                return true;
            }
        }
        return false;
    }
    //----------------------- BONUS STUFF -------------------------------------------------------------

    public static boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) { // Not a letter or digit = special character
                return true;
            }
        }
        return false;
    }

}