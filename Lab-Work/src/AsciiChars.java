public class AsciiChars
{
    public static void printNumbers()
    {
        //print valid numeric input
        System.out.println("Valid Number inputs: ");
        for (int i = 48; i <= 57; i++) {
        System.out.println((char)i);
        }
    }

    public static void printLowerCase()
    {
        //print valid lowercase alphabetic input
        System.out.println("Valid LowerCase inputs: ");
        for (int i = 97; i <= 122; i++) {
            System.out.println((char)i);
        }
    }

    public static void printUpperCase()
    {
        //print valid uppercase alphabetic input
        System.out.println("Valid UpperCase inputs: ");
        for (int i = 65; i <= 90; i++) {
            System.out.println((char)i);
        }
    }


}