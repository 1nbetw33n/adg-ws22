package util;

/*
 * Created by 0x1nbetw33n on 06. Jun   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */
public final class StringFormatter {

    /**
     * Removes all curly braces from a string.
     * @param str the string to be modified
     * @return the modified string
     */
    public static String remove_curlyBraces(final String str) {
        return str.replaceAll("[{}]", "");
    }

    /**
     * Removes all double quotes from a string.
     * @param str the string to be modified
     * @return the modified string
     */
    public static String remove_doubleQuotes(final String str) {
        return str.replaceAll("\"", "");
    }

}
