package freelifer.sdk.usage.internal;

/**
 * @author kzhu on 2017/8/21.
 */
public class Print {

    private static final String spaces = "        ";

    public static void println(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    public static void printlnBySpace(String msg, Object... args) {
//        System.out.println(padWhitespaceLeft(String.format(msg, args), spaceLen));
        System.out.println(spaces + String.format(msg, args));

    }

    public static String center(String s, int len) {
        int innerLen = len - (len - s.length()) / 2;
        return padWhitespaceLeft(padWhitespaceRight(s, innerLen), len);
    }

    public static String padWhitespaceLeft(String s, int len) {
        return String.format("%1$" + len + "s", s);
    }

    public static String padWhitespaceRight(String s, int len) {
        return String.format("%1$-" + len + "s", s);
    }

}
