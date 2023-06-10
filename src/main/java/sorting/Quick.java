package sorting;

/*
 * Created by 0x1nbetw33n on 04. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Comparator;

final class Quick extends Sort{

	/**
	 * Implementation of quick sort.<br>
	 * The Algorithm is <a href="https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/?type=article&id=10109">unstable</a>
	 * and <a href="https://www.geeksforgeeks.org/adaptive-and-non-adaptive-sorting-algorithms/">adaptive</a>
	 * and <a href="https://en.wikipedia.org/wiki/In-place_algorithm/">in-place</a>.<br>
	 * Basisc logic:<br>
	 * The algorithm chooses a pivot element and puts all elements smaller than the pivot to the left and all elements
	 * greater than the pivot to the right.<br>
	 * Then the algorithm recursively sorts the left and right partition.<br>
	 * @param comp the comparator that is used to compare the elements
	 * @param data the data that will be sorted
	 */
	protected <T> void sort(final Comparator<? super T> comp, final T[] data) {
		take_snapshot(data);
		quick(0, data.length - 1, comp, data);
		print_snapshots();
	}

	/**
	 * Recursively sorts the data divided by the pivot.
	 * @param start the start index
	 * @param end the end index
	 * @param comp the comparator that is used to compare the elements
	 * @param data the data that will be sorted
	 */
	private <T> void quick(final int start, final int end, final Comparator<? super T> comp, final T[] data) {
		if (start >= end) {
			return;
		}
		int piv = pivot(start, end);
		swap(piv, end, data);
		int left = start;
		int right = end - 1;
		do {
			while (left <= right && comp.compare(data[left], data[end]) < 0) {
				left++;
			}
			while (left <= right && comp.compare(data[right], data[end]) >= 0) {
				right--;
			}
			if (left < right) {
				swap(left++, right, data);
			}
		} while (left <= --right);
		piv = left;
		swap(piv, end, data);
		take_snapshot(data);
		quick(start, piv - 1, comp, data);
		quick(piv + 1, end, comp, data);
	}


	/**
	 * Calculates the pivot index.
	 * This implementation uses the middle index as pivot.
	 * @param start the start index
	 * @param end the end index
	 * @return the pivot index
	 */
	private int pivot(final int start, final int end) {
		return (start + end) / 2;
	}


}
