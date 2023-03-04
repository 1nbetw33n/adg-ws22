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

package adg.sorting;/*
 * Created by 0x1nbetw33n on 01. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Comparator;

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
                for (var i = 1; i < data.length; i++) {
                        write_current_state(data);
                        for (var j = i; j > 0 && comp.compare((data[j - 1]), (data[j])) > 0; j--) {
                                swap(j - 1, j, data);
                        }
                }
                write_current_state(data);
                print_states();
        }


}
