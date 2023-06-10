package sorting;

/*
 * Created by 0x1nbetw33n on 27. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Comparator;

final class Selection extends Sort {


    /**
     * Implementation of selection sort.<br>
     * The Algorithm is <a href="https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/?type=article&id=10109">not stable</a>
     * and <a href="https://www.geeksforgeeks.org/adaptive-and-non-adaptive-sorting-algorithms/">non-adaptive</a>
     * and <a href="https://en.wikipedia.org/wiki/In-place_algorithm/">in-place</a>.<br>
     * Basic logic:<br>
     * The algorithm divides the data into two subsets: sorted and unsorted.<br>
     * The algorithm iterates over the unsorted subset and finds the smallest element.<br>
     * The smallest element is then swapped with the first element of the unsorted subset.<br>
     * So the smallest elements are being moved to the beginning of the data.<br>
     * The algorithm iterates over the data until the unsorted subset is empty.<br>
     * @param comp comparator that is used to compare the elements
     * @param data data that will be sorted
     */
    protected <T> void sort(final Comparator<? super T> comp, final T[] data){
        for (int i = 0; i < data.length -1; i++) {
            take_snapshot(data);
            int min = i;
                for (int j = i + 1; j < data.length; j++) {
                        if (comp.compare(data[min], data[j]) > 0) {min = j;}
                }
            swap(i, min, data);
        }
        take_snapshot(data);
        take_snapshot(data);
        print_snapshots();
    }



}
    