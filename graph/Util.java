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

package adg.graph;/*
 * Created by 0x1nbetw33n on 12. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static misc.util.Util.remove_curlyBraces;
import static misc.util.Util.remove_doubleQuotes;

final class Util {

        /**
         * private constructor to prevent instantiation.
         */
        private Util() {}

        /**
         * Parses a csv file to a list of adjacency lists using {@link #parse_str_to_adjLists(String)}.<br>
         * The csv file must be in the following format:
         * <pre>
         * "{a}->{b,e,h}";"{b}->{g}";"{c}->{a}"
         * "{a}->{b,e,h}";"{b}->{g}";"{c}->{a}"
         * </pre>
         * @param path path to the csv file.
         * @return a list of adjacency lists.
         * @throws IOException if the file could not be read.
         */
        static List<AdjLists> parse_csv_to_list_adjLists(@SuppressWarnings("SameParameterValue") final String path) throws IOException {
                final List<AdjLists> adjListsList = new ArrayList<>();
                try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                                adjListsList.add(parse_str_to_adjLists(line));
                        }
                }
                return adjListsList;
        }

        /**
         * Parses a string to an adjacency list.<br>
         * The string must be in the following format:
         * <pre>
         * "{a}->{b,e,h}";"{b}->{g}";"{c}->{a}"
         * </pre>
         * @param str string to parse.
         * @return an adjacency list.
         */
        private static AdjLists parse_str_to_adjLists(final String str) { // str :: "{a}->{b,e,h}";"{b}->{g}";"{c}->{a}"
                final AdjLists adjLists = new AdjLists();
                final String[] adjListsStrArray = str.split(";"); // adjListsStrArray :: "{a}->{x,y,z}", "{b}->{t,z}"
                for (final String s : adjListsStrArray) {
                        final String[] key_value_pair = remove_doubleQuotes(s).split("->"); // key_value_pair :: {a}, {x,y,z}
                        adjLists.add_adjList(
                                remove_curlyBraces(key_value_pair[0]), // key_value_pair[0] :: a
                                List.of(remove_curlyBraces(key_value_pair[1]).split(",")) // key_value_pair[1] :: x,y,z
                        );
                }
                return adjLists;
        }

        /**
         * Formats the order of a graph to a string.<br>
         * @param list_obj the order of a graph
         * @return a string in the format: <pre>{"a","b","c"}</pre>
         */
        static String format_order_dfsBfs(final List<Object> list_obj) {
                final StringBuilder strB = new StringBuilder("{");
                IntStream.range(0, list_obj.size())
                                .filter(i -> !list_obj.get(i).equals(""))
                                        .forEach(i -> {
                                                strB.append("\"")
                                                        .append(list_obj.get(i))
                                                        .append("\"");
                                                if (i != list_obj.size() - 1) {
                                                        strB.append(",");
                                                } else {
                                                        strB.append("}");
                                                }
                                        });
                return strB.toString();
        }

        /**
         * Formats the ordered list of a topological sort to a string.<br>
         * @param list_int the order of a graph
         * @return a string in the format: <pre>{1,4,7,6,3,2,5,8}</pre>
         */
        static String format_order_topologicalSort(final List<Object> list_int) {
                final StringBuilder strB = new StringBuilder("{");
                IntStream.range(0, list_int.size())
                        .forEach(i -> {
                                strB.append(list_int.get(i));
                        if (i != list_int.size() - 1) {
                                strB.append(",");
                        } else {
                                strB.append("}");
                        }
                });
                return strB.toString();
        }

        /**
         * Parses a csv file to a list of pairs using {@link #parse_str_to_pair(String)}.<br>
         * The csv file must be in the following format:
         * <pre>
         *         dfs_order;bfs_order
         * </pre>
         * example:
         * <pre>
         *         {"a","b","c","e","d"};{"a","b","e","c","d"}
         * </pre>
         * @param path path to the csv file
         * @return a list of ordered dfs-bfs pairs
         */
        static List<Pair> parse_csv_to_pairList(@SuppressWarnings("SameParameterValue") final String path) {
                final List<Pair> listPair = new ArrayList<>();
                try (final Stream<String> stream = Files.lines(Paths.get(path))) {
                        stream.skip(1)
                                .forEach(s -> listPair.add(parse_str_to_pair(s)));
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return listPair;
        }

        /**
         * Splits a single string containing a dfs-bfs pair into two strings containing the dfs and bfs order respectively.<br>
         * The string must be in the following format:
         * <pre>
         *         dfs_order;bfs_order
         * </pre>
         * @param str string to parse
         * @return a dfs-bfs pair
         * @see #parse_csv_to_pairList(String) for more infos about the format of the parameter str
         */
        private static Pair parse_str_to_pair(final String str) {
                final String[] dfs_bfs = str.split(";");
                return new Pair(dfs_bfs[0], dfs_bfs[1]);
        }

        /**
         * A pair of dfs-bfs orders.
         * @see #parse_str_to_pair(String)
         */
        static final class Pair {

                private final String dfs;
                private final String bfs;


                private Pair(final String dfs, final String bfs) {
                        this.dfs = dfs;
                        this.bfs = bfs;
                }

                /**
                 * Returns the dfs order of the pair.
                 * @return the dfs order
                 */
                private String get_dfs() {
                        return dfs;
                }

                /**
                 * Returns the bfs order of the pair.
                 * @return the bfs order
                 */
                private String get_bfs() {
                        return bfs;
                }

                /**
                 * Returns the order of the pair according to the type specified.
                 * @param type either "DFS" or "BFS"
                 * @return either the dfs or bfs order
                 * @throws IllegalArgumentException if type is neither "DFS" nor "BFS"
                 */
                public String get_pair(final String type) {
                        if (type.equals(DFS.class.getSimpleName())) {
                                return get_dfs();
                        } else if (type.equals(BFS.class.getSimpleName())) {
                                return get_bfs();
                        } else {
                                throw new IllegalArgumentException("type must be either \"DFS\" or \"BFS\"");
                        }
                }

                /**
                 * Returns the string representation of the dfs-bfs pair.
                 * @return the dfs-bfs pair as a string
                 */
                public String toString() {
                        return "dfs: " + dfs + " | bfs: " + bfs;
                }
        }

}
