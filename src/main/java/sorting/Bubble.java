package sorting;

/*
 * Created by 0x1nbetw33n on 22. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Comparator;

final class Bubble extends Sort{

        /**
         * Implementation of bubble sort.<br>
         * The Algorithm is <a href="https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/?type=article&id=10109">stable</a>
         * and <a href="https://www.geeksforgeeks.org/adaptive-and-non-adaptive-sorting-algorithms/">adaptive</a>
         * and <a href="https://en.wikipedia.org/wiki/In-place_algorithm/">in-place</a>.<br>
         * Basic logic:<br>
         * The algorithm iterates over the data and compares {@code i} and {@code i+1}.<br>
         * If {@code i} is greater than {@code i+1}, the elements are swapped.<br>
         * So the largest element is bubbled to the end of the array in each iteration.<br>
         * The algorithm iterates over the data until no swaps are made anymore.<br>
         * @param data the data that will be sorted
         * @param comp the comparator that is used to compare the elements
         */
        protected <T> void sort(final Comparator<? super T> comp, final T[] data) {
                int pos = data.length - 1;
                while (pos > 0) {
                        int border = pos;
                        pos = 0;
                        take_snapshot(data);
                        for (int i = 0; i < border; i++) {
                                if (comp.compare(data[i], data[i + 1]) > 0) {
                                        swap(i, i + 1, data);
                                        pos = i;
                                }
                        }
                }
                take_snapshot(data);
                print_snapshots();
        }


}