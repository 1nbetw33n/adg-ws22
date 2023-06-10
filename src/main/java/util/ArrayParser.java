package util;

import java.util.stream.IntStream;

/*
 * Created by 0x1nbetw33n on 06. Jun   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

public final class ArrayParser {

    private ArrayParser() {}

    /**
     * Calls {@link #to_string(String, Object[])}   with the default regex pattern ", ".
     *
     * @param data the data that will be parsed
     * @return data as String
     */
    public static String to_string(final Object[] data){
        return to_string(", ", data);
    }

    /**
     * Parses a T[] to a String using the provided regex pattern as deliminiter.
     * @param regex the regex pattern that is used as deliminiter
     * @param data the data that will be parsed
     * @return data as String
     */
    public static String to_string(final String regex, final Object[] data){
        final StringBuilder builder = new StringBuilder("{");
        IntStream.range(0, data.length)
                .forEach(i -> {
                    builder.append(data[i]);
                    if (i != data.length - 1) {
                        builder.append(regex);
                    }
                });
        return builder.append("}").toString();
    }


}
