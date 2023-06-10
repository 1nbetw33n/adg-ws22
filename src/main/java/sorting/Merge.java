package sorting;

/*
 * Created by 0x1nbetw33n on 03. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Arrays;
import java.util.Comparator;

final class Merge extends Sort{

        /**
         * Implementation of merge sort.<br>
         * The Algorithm is <a href="https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/?type=article&id=10109">stable</a>
         * and <a href="https://www.geeksforgeeks.org/adaptive-and-non-adaptive-sorting-algorithms/">non-adaptive</a>
         * and <a href="https://en.wikipedia.org/wiki/In-place_algorithm/">not in-place</a>.<br>
         * It uses a temporary array (tmp) to store the partitioned data.<br>
         * Basic logic:<br>
         * The data is recursively split into 2 smaller partitions until the partitions are of size 1.<br>
         * Then the partitions are merged back together in a sorted manner.<br>
         * The Algorithm terminates when the partitions are merged back together.<br>
         * @param comp the comparator that is used to compare the elements
         * @param data the data that will be sorted
         */
        @SuppressWarnings("unchecked")
        protected <T> void sort(final Comparator<? super T> comp, T[] data) {
                T[] tmp = (T[]) new Object[data.length];
                take_snapshot(data);
                sort(0, data.length, comp, tmp, data);
                print_snapshots();
        }

        /**
         * Gets called recursively to split the data into smaller partitions.<br>
         * When the partitions are of size 1, the partitions are merged back together.
         * @param start the start index of the partition
         * @param end the end index of the partition
         * @param comp the comparator that is used to compare the elements
         * @param tmp the temporary array that is used to store the partitioned data
         * @param data the data that will be sorted
         */
        private <T> void sort(int start, int end, final Comparator<? super T> comp, T[] tmp, T[] data) {
                if (end - start <= 1) {
                        return;
                }
                int mid = (start + end + 1) / 2;
                sort(start, mid, comp, tmp, data);
                sort(mid, end, comp, tmp, data);
                merge(start, mid, end, comp, tmp, data);
                take_snapshot(Arrays.copyOfRange(data, start, end));
        }

        /**
         * Merge the partitions back together in a sorted manner.<br>
         * @param start the start index of the partition
         * @param mid the middle index of the partition
         * @param end the end index of the partition
         * @param comp the comparator that is used to compare the elements
         * @param tmp the temporary array that is used to store the partitioned data
         * @param data the data that will be sorted
         */
        private <T> void merge(final int start, final int mid, final int end, final Comparator<? super T> comp, T[] tmp, final T[] data) {
                int left = start;
                int right = mid;
                int i = 0;
                while (left < mid && right < end) {
                        tmp[i++] = comp.compare(data[left], data[right]) <= 0 ? data[left++] : data[right++];
                }
                while (left < mid) {
                        tmp[i++] = data[left++];
                }
                while (right < end) {
                        tmp[i++] = data[right++];
                }
                System.arraycopy(tmp, 0, data, start, i);
        }

}
