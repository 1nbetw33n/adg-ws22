package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/*
 * Created by 0x1nbetw33n on 06. Jun   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

final class Util {

    private Util() {}

    /**
     * Checks if the input for the sorting algorithms is in the format of:<br>
     * {1,2,3} or {1, 2, 3, 4}.<br>
     * {1,2, 3} is not valid (there is a space between 2 and 3).<br>
     *
     * @throws IllegalArgumentException if the input is not valid
     */
    public static void is_valid_sorting_input(final String input) throws IllegalArgumentException {
        if (!(input.matches("^\\{\\d+(,\\d+)*}$") || input.matches("^\\{\\d+(, \\d+)*}$"))) {
            throw new IllegalArgumentException("invalid input");
        }
    }

    /**
     * Generates pseudo random data of the type that is provided as a parameter, with the given size and within the given range (inclusive).<br>
     * Uses {@link Random#nextInt(int)} to generate the random numbers.<br>
     * Generates no duplicates and no numbers < 1.
     * @param clazz the class of the type of the array
     * @param size the size of the array
     * @param range the range of the random numbers
     * @return an array of the given type with the given size filled with random numbers within the given range
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] generate_random_data(final Class<T> clazz, final int size, final int range) {
        final Random random = new Random();
        final T[] data = (T[]) Array.newInstance(clazz, size);
        final HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int number = random.nextInt(range) + 1;
            while (set.contains(number)) {
                number = random.nextInt(range) + 1;
            }
            set.add(number);
            data[i] = (T) Integer.valueOf(number);
        }
        return data;
    }

    /**
     * Prints an array in a nice way (sourrounds it with { } and ", " between each element).<br>
     * Adds a new line at the end.
     * @param array the array to be printed
     */

    public static <T> void print_array(final T[] array){
        System.out.print("{");
        Arrays.stream(array)
                .forEach(t -> {
                    if (t != array[array.length - 1]) {
                        System.out.print(t + ", ");
                    } else {
                        System.out.print(t);
                    }
                });
        System.out.print("}" + System.lineSeparator());
    }

}
