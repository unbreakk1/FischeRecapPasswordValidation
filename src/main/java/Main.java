
public class Main
{
    public static void main(String[] args)
    {

    }

    public static boolean isValid(String password)
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

}