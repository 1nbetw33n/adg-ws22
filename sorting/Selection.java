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
        for (var i = 0; i < data.length -1; i++) {
            take_snapshot(data);
            var min = i;
                for (var j = i + 1; j < data.length; j++) {
                        if (comp.compare(data[min], data[j]) > 0) {min = j;}
                }
            swap(i, min, data);
        }
        take_snapshot(data);
        take_snapshot(data);
        print_snapshots();
    }



}
    