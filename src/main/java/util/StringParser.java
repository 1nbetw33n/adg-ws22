package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Created by 0x1nbetw33n on 06. Jun   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

public final class StringParser {

    private StringParser() {}

    /**
     * Calls {@link #to_objArray(String, String)} with the default regex pattern ",".<br>
     * @param str the string to be parsed
     * @return string as double[]
     */
    @SuppressWarnings("unused")
    public static Object[] to_objArray(final String str){
        return to_objArray(",", str);
    }

    /**
     * Parses a String to an Object[] by using the provided regex pattern.<br>
     * Before splitting the String, all whitespaces are removed, so it doesn't matter if the string is formatted like this
     * {2, 6, 28, 31} or this {2,6,28,31}.<br>
     * All occurrences of {@code { } [ ] } are also removed.<br>
     * So it also doesn't matter if the string is formatted like this<br>
     * {2, 6, 28, 31} or this [2, 6, 28, 31].<br>
     * @param str the string to be parsed
     * @param regex the regex that is used to split the string
     * @return string as Object[]
     */
    public static Object[] to_objArray(final String regex, final String str){
        final String[] strings = remove_whitespacesAndBrackets(str).split(regex);
        final Object[] objects = new Object[strings.length];
        System.arraycopy(strings, 0, objects, 0, strings.length);
        return objects;
    }

    /**
     * Calls {@link #to_intArray(String, String)} with the default regex pattern ",".<br>
     * @param str the string to be parsed
     * @return string as Integer[]
     */
    public static Integer[] to_intArray(final String str){
        return to_intArray(",", str);
    }

    /**
     * Parses a String to an int[] by using the provided regex pattern.<br>
     * Same behaviour as {@link #to_objArray(String, String)},<br>
     * but returns an Integer[] instead of an Object[].
     * @param regex the regex that is used to split the string
     * @param str the string to be parsed
     * @return string as Integer[]
     */
    public static Integer[] to_intArray(final String regex, final String str){
        return Arrays.stream(
                        remove_whitespacesAndBrackets(str).split(regex))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    /**
     * Calls {@link #to_intArray_2D(String, String)} with the<br>default regex pattern {@link System#lineSeparator()}.<br>
     * @param str the multi-line string to be parsed
     * @return string as Integer[][]
     */
    public static Integer[][] to_intArray_2D(final String str) {
        return to_intArray_2D(System.lineSeparator(), str);
    }

    /**
     * Parses a multi-line String to an Integer[][] by using the provided regex pattern.<br>
     * @param regex the regex that is used to split the string
     * @param str the multi-line string to be parsed
     * @return string as Integer[][]
     */
    public static Integer[][] to_intArray_2D(final String regex, final String str){
        return to_list_intArray(
                regex,
                remove_firstAndLast(str)
        ).toArray(Integer[][]::new);
    }


    /**
     * Calls {@link #to_list_intArray(String, String)} with the<br>default regex pattern {@link System#lineSeparator()}.
     * @param str the multi-line string to be parsed
     * @return string as {@code List<Integer[]>}
     */
    @SuppressWarnings("unused")
    public static List<Integer[]> to_list_intArray(final String str) {
        return to_list_intArray(System.lineSeparator(), str);
    }

    /**
     * Parses a multi-line String to an {@code List<Integer[]>} by using the provided regex pattern.<br>
     * @param regex the regex that is used to split the string
     * @param str the multi-line string to be parsed
     * @return string as {@code List<Integer[]>}
     */
    public static List<Integer[]> to_list_intArray(final String regex, final String str){
        final String s = str.substring(1);
        return Arrays.stream(
                        s.split(regex))
                .map(StringParser::to_intArray)
                .collect(Collectors.toList()
                );
    }

    /** Removes the first and last line of a multi-line string.<br>
     * <pre>
     * {
     * {2, 6, 28, 31, 24, 32, 29, 3, 16, 5, 14},
     * {2, 3, 5, 6, 14, 16, 24, 28, 29, 31, 32}
     * }
     * </pre>
     * to prepare the string to be parsed in one of the following methods:<br>
     * <ul>
     *         <li>{@link #to_intArray_2D(String)}</li>
     * </ul>
     * Removes the first and last line of the string.
     * @param str the string
     * @return the string without first and last line
     */
    public static String remove_firstAndLast(final String str) {
        return str
                .substring(1)
                .substring(0, str.length() - 2);
    }

    /**
     * Removes the following from a single line string:<br>
     * <ul>
     *         <li>whitespace</li>
     *         <li>{ }</li>
     *         <li>[ ]</li>
     * </ul>
     * Used by:<br>
     * <ul>
     *         <li>{@link #to_objArray(String, String)}</li>
     *         <li>{@link #to_intArray(String, String)}</li>
     * </ul>
     * @param str the string
     * @return the string without
     */
    private static String remove_whitespacesAndBrackets(final String str) {
        return str
                .replaceAll("\\s", "")
                .replaceAll("[{}]", "")
                .replaceAll("[\\[\\]]", "");
    }


}
