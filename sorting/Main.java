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
 * Created by 0x1nbetw33n on 04. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import misc.util.String_Parser;
import misc.util.Util;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

final class Main {

        private final List<String> sorting_algorithms;
        private final Scanner sc;

        /**
         * Private constructor to prevent outside use.
         */
        private Main(){
                sc = new Scanner(System.in);
                sorting_algorithms = List.of(new String[]{"selection", "insertion", "bubble", "merge", "quick", "heap"});
        }

        /**
         * Lists all available sorting algorithms.
         */
        private void show_selection() {
                System.out.println(System.lineSeparator() + "Which sorting algorithm do you want to use?");
                System.out.println("Available algorithms ::");
                sorting_algorithms.stream().map(v -> {
                        var i = sorting_algorithms.indexOf(v);
                        return (i + 1) + " -> " + v;
                }).forEach(System.out::println);
                System.out.println("Enter number ::" + System.lineSeparator());
        }

        /**
         * Gets the instance of the sorting algorithm based on the entered number.
         * @param name the name of the sorting algorithm
         * @return the instance of the sorting algorithm
         */
        private Sort get_sorting_algorithm(String name) {
                return switch (name) {
                        case "1" -> new Selection();
                        case "2" -> new Insertion();
                        case "3" -> new Bubble();
                        case "4" -> new Merge();
                        //case "5" -> new Quick();
                        //case "6": -> new Heap();
                        default -> null;
                };
        }

        /**
         * Runs the program.
         */
        private void run() {
                var main = new Main();
                main.show_selection();
                var algo = sc.nextLine();
                if (main.get_sorting_algorithm(algo) == null) {
                        System.out.println("Invalid sorting algorithm!");
                        return;
                }
                System.out.println(System.lineSeparator() + "Enter the data you want to sort in the following format ::"
                        + System.lineSeparator() + "{1,2,3} or {1, 2, 3}" + System.lineSeparator());
                var data = sc.nextLine();
                System.out.println();
                Util.is_valid_sorting_input(data);
                Objects.requireNonNull(main.get_sorting_algorithm(algo))
                        .sort(String_Parser.to_integer_array(data));
        }

        public static void main(String[] args) {
                new Main().run();
        }

}
