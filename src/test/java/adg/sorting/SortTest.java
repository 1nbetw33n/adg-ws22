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

package adg.sorting;

import misc.util.String_Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Created by 0x1nbetw33n on 22. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

final class SortTest {

        /**
         * Calls {@link #sort_test(Comparator, Sort, Comparable[], Comparable[][])} with {@link Comparator#naturalOrder()} as comparator.
         * @param sort the sorting algorithm that will be tested
         * @param data the data that will be sorted
         */
        private <T extends Comparable<? super T>> void sort_test(final Sort sort, final T[] data, final T[][] exp_snaps) {
                sort_test(Comparator.naturalOrder(), sort, data, exp_snaps);
        }

        /**
         * Tests the sorting algorithm with the given inputs and expected snapshots.
         * @param comp the comparator that is used to compare the elements
         * @param sort the sorting algorithm that will be tested
         * @param data the data that will be sorted
         */
        @SuppressWarnings("unchecked")
        private <T extends Comparable<? super T>> void sort_test(final Comparator<? super T> comp, final Sort sort, final T[] data, final T[][] exp_snaps) {
                sort.sort(data);
                var actual_snaps = sort.get_snapshots();
                for (var i = 0; i < exp_snaps.length; i++) {
                        Assertions.assertEquals(0, Arrays.compare(exp_snaps[i], (T[]) actual_snaps[i], comp));
                }
        }


        @Test
        void swap_test() {
                Sort bubble_sort = new Bubble();
                var data = new Integer[]{1, 2, 3, 4, 5};
                bubble_sort.swap(0, 1, data);
                assert data[0] == 2;
                bubble_sort.swap(1, 2, data);
                assert data[2] == 1;
        }

        /**
         * Tests the implementation of selection sort with inputs and expected snapshots from selection.csv.
         * @param input the input data
         * @param exp_snaps the expected snapshots of the order of the data that it had while sorting
         * @param desc the description of the test
         */
        @ParameterizedTest(name = "{2}: {0}")
        @CsvFileSource(resources = "/adg/sorting/selection.csv", numLinesToSkip = 1, delimiter = ',')
        void selection_sort_test(final String input, final String exp_snaps, @SuppressWarnings("unused") final String desc){
                sort_test(new Selection(), String_Parser.to_integer_array(input), String_Parser.to_integer_2D_array(exp_snaps));
        }

        /**
         * Tests the implementartion of insertion sort with inputs and expected snapshots from insertion.csv.
         * @param input the input data
         * @param exp_snaps the expected snapshots of the order of the data that it had while sorting
         * @param desc the description of the test
         */
        @ParameterizedTest(name = "{2}: {0}")
        @CsvFileSource(resources = "/adg/sorting/insertion.csv", numLinesToSkip = 1, delimiter = ',')
        void insertion_sort_test(final String input, final String exp_snaps, @SuppressWarnings("unused") final String desc) {
                sort_test(new Insertion(), String_Parser.to_integer_array(input), String_Parser.to_integer_2D_array(exp_snaps));
        }

        /**
         * Tests the implementation of bubble sort with inputs and expected snapshots from bubble.csv.
         * @param input the input data
         * @param exp_snaps the expected snapshots of the order of the data that it had while sorting
         * @param desc the description of the test
         */
        @ParameterizedTest(name = "{2}: {0}")
        @CsvFileSource(resources = "/adg/sorting/bubble.csv", numLinesToSkip = 1, delimiter = ',')
        void bubble_sort_test(final String input, final String exp_snaps, @SuppressWarnings("unused") final String desc) {
                sort_test(new Bubble(), String_Parser.to_integer_array(input), String_Parser.to_integer_2D_array(exp_snaps));
        }

        /**
         * Tests the implementation of merge sort with inputs and expected snapshots from merge.csv.
         * @param input the input data
         * @param exp_snaps the expected snapshots of the order of the data that it had while sorting
         * @param desc the description of the test
         */
        @ParameterizedTest(name = "{2}: {0}")
        @CsvFileSource(resources = "/adg/sorting/merge.csv", numLinesToSkip = 1, delimiter = ',')
        void merge_sort_test(final String input, final String exp_snaps, @SuppressWarnings("unused") final String desc) {
                sort_test(new Merge(), String_Parser.to_integer_array(input), String_Parser.to_integer_2D_array(exp_snaps));
        }

        /**
         * Tests the implementation of quick sort with inputs and expected snapshots from quick.csv.
         * @param input the input data
         * @param exp_snaps the expected snapshots of the order of the data that it had while sorting
         * @param desc the description of the test
         */
        @ParameterizedTest(name = "{2}: {0}")
        @CsvFileSource(resources = "/adg/sorting/quick.csv", numLinesToSkip = 1, delimiter = ',')
        void quick_sort_test(final String input, final String exp_snaps, @SuppressWarnings("unused") final String desc) {
                sort_test(new Quick(), String_Parser.to_integer_array(input), String_Parser.to_integer_2D_array(exp_snaps));
        }

}
