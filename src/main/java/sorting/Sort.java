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
 * Created by 0x1nbetw33n on 22. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import util.ArrayParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

abstract sealed class Sort permits Bubble, Heap, Insertion, Merge, Quick, Selection {

        private final List<Object[]> snapshots = new ArrayList<>();


        /**
         * Framework for all sorting algorithms so that they can be used in the same way.<br>
         * Every sublass will implement its own sort method.
         * @param comp the comparator that is used to compare the elements
         * @param data the data that will be sorted
         */
        protected abstract <T> void sort(final Comparator<? super T> comp, final T[] data);

        /**
         * Calls {@link #sort(Comparator, Object[])} with {@link Comparator#naturalOrder()} as comparator.
         * @param data the data that will be sorted
         */
        protected <T extends Comparable<? super T>> void sort(final T[] data) {
                sort(Comparator.naturalOrder(), data);
        }

        /**
         * Calls {@link #sort(Comparator, Object[])} with {@link Comparator#reverseOrder()} as comparator.
         * @param data the data that will be sorted
         */
        @SuppressWarnings("unused")
        protected <T extends Comparable<? super T>> void sort_desc(final T[] data) {
                sort(Comparator.reverseOrder(), data);
        }

        /**
         * Swaps two elements in an array <a href="https://en.wikipedia.org/wiki/In-place_algorithm/">in-place</a>.
         * @param data the data whose elements will be swapped
         * @param i the index of the first element
         * @param j the index of the second element
         */
        protected <T> void swap(final int i, final int j, final T[] data) {
                final T tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
        }

        /**
         * Takes a snapshot of the current order of the data and appends it to  {@link #snapshots} {@code (List<Object[]>)}.
         */
        protected final <T> void take_snapshot(final T[] data) {
                snapshots.add(Arrays.copyOf(data, data.length));
        }

        /**
         * Parses {@link #snapshots} {@code (List<Object[]>)} to an Object[][].
         * @return snapshots as Object[][]
         */
        protected Object[][] get_snapshots() {
                return snapshots.toArray(Object[][]::new);
        }

        protected void print_snapshots() {
                StringBuilder sb = new StringBuilder("{").append(System.lineSeparator());
                IntStream.range(0, snapshots.size())
                        .forEach(i -> {
                                if (i < snapshots.size() - 1) {
                                        sb.append(ArrayParser.to_string(snapshots.get(i)))
                                                .append(",").append(System.lineSeparator());
                                } else {
                                        sb.append(ArrayParser.to_string(snapshots.get(i))).append(System.lineSeparator()).append("}");
                                }
                        });
                System.out.println(sb);
        }


}
