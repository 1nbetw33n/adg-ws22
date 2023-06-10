package sorting;

/*
 * Created by 0x1nbetw33n on 01. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Comparator;
import java.util.stream.IntStream;

final class Insertion extends Sort {


        /**
         * Implementation of insertion sort.<br>
         * The Algorithm is <a href="https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/?type=article&id=10109">stable</a>
         * and <a href="https://www.geeksforgeeks.org/adaptive-and-non-adaptive-sorting-algorithms/">adaptive</a>
         * and <a href="https://en.wikipedia.org/wiki/In-place_algorithm/">in-place</a>.<br>
         * Basic logic:<br>
         * The algorithm iterates over the data.
         * For each element {@code i} it iterates over the elements {@code j} from {@code i} to {@code 0}.
         * If {@code j} is greater than {@code j-1}, the elements are swapped.<br>
         * So the smallest element is moved to the beginning of the array in each iteration.<br>
         * @param comp the comparator that is used to compare the elements
         * @param data the data that will be sorted
         */
        protected <T> void sort(final Comparator<? super T> comp, final T[] data) {
                for (int i = 1; i < data.length; i++) {
                        take_snapshot(data);
                        IntStream.iterate(i, j -> j > 0 && (comp.compare((data[j - 1]), (data[j])) > 0), j -> j - 1)
                                .forEach(j -> swap(j - 1, j, data));
                }
                take_snapshot(data);
                print_snapshots();
        }


}
