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

package adg.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static adg.graph.Util.format_order_dfsBfs;

/*
 * Created by 0x1nbetw33n on 13. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */
final class GraphTest {

	final List<AdjLists> adjListsList = Util.parse_csv_to_list_adjLists("src/test/resources/adg.graph/dfs_bfs_adjLists.csv");
	final List<Util.Pair> dfs_bfs_pairs = Util.parse_csv_to_pairList("src/test/resources/adg.graph/exp_visited_nodes_dfs_bfs.csv");

	GraphTest() throws IOException {}

	// TODO: write javadoc
	/**
	 *
	 */
	void search_test(final Search search) {
		if (search.getClass().getSimpleName().equals(DFS.class.getSimpleName()) || search.getClass().getSimpleName().equals(BFS.class.getSimpleName())) {
			IntStream.range(0, adjListsList.size())
				.forEach(i -> Assertions.assertEquals(
					dfs_bfs_pairs.get(i).get_pair(search.getClass().getSimpleName()),
					format_order_dfsBfs(search.sort(adjListsList.get(i)))
				));
		} else if (search.getClass().getSimpleName().equals(Top_Sort.class.getSimpleName())) {
			// TODO: implement
		}
	}

	// TODO: write javadoc
	/**
	 *
	 */
	@Test
	void dfs_test() {
		search_test(new DFS());
	}

	// TODO: write javadoc
	/**
	 *
	 */
	@Test
	void bfs_test() {
		search_test(new BFS());
	}

	// TODO: write javadoc
	/**
	 *
	 */
	@Test
	void top_sort_test() {
		search_test(new Top_Sort());
	}


}