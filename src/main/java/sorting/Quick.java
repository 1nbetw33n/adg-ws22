/*
 *
 * Copyright (c) 2022 1nbetw33n
 * Virgo Supercluster, Milky Way - Earth A-6847
 *
 * I dont give a fuck about copyright - this code is free to use for everybody - EXCEPTION:
 *      - entities that support:
 *          > queer hostility
 *          > any kind of religion
 *          > authoritarianism
 *          > sexism
 *          > racism
 *          > ableism
 *      - (most) boomer
 *      - conservatives
 *      - nazis
 *      - TERFs
 *      - TWERFs
 *      - SWERFs
 *      - MAPs
 *   -will be extended if necessary-
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * -will be extended if necessary-
 */

package sorting;/*
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
