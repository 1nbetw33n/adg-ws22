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

package graph;
/*
 * Created by 0x1nbetw33n on 13. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


final class Main {

	private final List<String> searching_algos;
	private String algo;
	private final Scanner sc;

	/**
	 * Private constructor to prevent outside use.
	 */
	private Main() {
		sc = new Scanner(System.in);
		searching_algos = List.of("DFS", "BFS", "TopSort", "Dijkstra", "Bellman-Ford", "Floyd-Warshall", "Prim", "Kruskal");
	}

	//TODO: make file reading on demand (only when needed) instead of reading all files at once
	/**
	 * Reads the data for the algorithm from the dedicated csv files.
	 * Initiates the prompt for selecting an algorithm.<br>
	 * Then runs the selected algorithm.
	 * @param main Main object
	 * @throws IOException if an I/O error occurs while reading the file(s)
	 */
	private void select(final Main main) throws IOException {
		select_algo(main);
		final List<AdjLists> list_adjLists_dfs_bfs = Util.parse_csv_to_list_adjLists("src/test/resources/adg.graph/dfs_bfs_adjLists.csv");
		final List<AdjLists> list_adjLists = Util.parse_csv_to_list_adjLists("src/test/resources/adg.graph/top_sort_adjLists.csv");
		switch (main.get_algo(algo).getClass().getSimpleName()) {
			case "DFS" -> main.run_dfs(list_adjLists_dfs_bfs);
			case "BFS" -> main.run_bfs(list_adjLists_dfs_bfs);
			case "Top_Sort" -> main.run_topSort(list_adjLists);
			case "Dijkstra", "Bellma_Ford", "Floyd_Warshall", "Prim", "Kruskal" -> System.out.println("Not implemented yet");
			default -> System.out.println("Invalid input");
		}
	}

	/**
	 * Displays the available algorithms and prompts the user to select one or exit.
	 * @param main Main object
	 */
	@SuppressWarnings("DuplicatedCode")
	private void select_algo(final Main main) {
		System.out.println("Which algorithm do you want to use?");
		System.out.println("Available algorithms ::" + System.lineSeparator());
		searching_algos.stream()
				.map(algo -> {
					int i = searching_algos.indexOf(algo);
					return algo + " -> " + (i + 1);
				}).forEach(System.out::println);
		System.out.println("Exit -> 0");
		System.out.println();
		System.out.println("Enter number ::" + System.lineSeparator());
		algo = sc.next();
		System.out.println();
		if (algo.equals("0")) {
			System.out.println("Exiting now...");
			System.exit(0);
		}
		System.out.println("-> " + main.get_algo(algo).getClass().getSimpleName() + " <-" + System.lineSeparator());
	}

	/**
	 * Processes the user input and returns the corresponding algorithm.
	 * @param number String containing the number of the algorithm
	 * @return the class of the algorithm
	 */
	private Search get_algo(final String number) {
		return switch (number) {
			case "1" -> new DFS();
			case "2" -> new BFS();
			case "3" -> new Top_Sort();
			default -> null;
		};
	}

	/**
	 * Prints the adjacency lists of the graphs that are used for the algorithm.
	 * @param list_adjLists List of adjacency lists
	 */
	private void print_adjLists(final List<AdjLists> list_adjLists) {
		final AtomicInteger i = new AtomicInteger(1);
		list_adjLists.forEach(adjLists -> {
			System.out.println("Adjacency List " + i.getAndIncrement() + ":");
			adjLists.print_adjLists();
			System.out.println();
		});
	}

	/**
	 * Runs depth-first search on the graphs and prints the order of the nodes.
	 * @param list_adjLists List of adjacency lists
	 */
	private void run_dfs(final List<AdjLists> list_adjLists) {
		print_adjLists(list_adjLists);
		final Search dfs = new DFS();
		IntStream.range(0, list_adjLists.size())
			.forEach(i -> {
				System.out.print("Order for Graph " + (i + 1) + "::\t");
				System.out.println(Util.format_order_dfsBfs(dfs.sort(list_adjLists.get(i))));
			});
	}

	/**
	 * Runs breadth-first search on the graphs and prints the order of the nodes.
	 * @param list_adjLists List of adjacency lists
	 */
	private void run_bfs(final List<AdjLists> list_adjLists) {
		print_adjLists(list_adjLists);
		final Search bfs = new BFS();
		IntStream.range(0, list_adjLists.size())
			.forEach(i -> {
				System.out.print("Order for Graph " + (i + 1) + " ::\t");
				System.out.println(Util.format_order_dfsBfs(bfs.sort(list_adjLists.get(i))));
			});
	}


	/**
	 * Runs topological sort on the graphs and prints the order of the nodes.
	 * @param list_adjLists List of adjacency lists
	 */
	private void run_topSort(final List<AdjLists> list_adjLists) {
		print_adjLists(list_adjLists);
		final Search sort = new Top_Sort();
		IntStream.range(0, list_adjLists.size())
			.forEach(i -> {
				System.out.print("Order for Graph " + (i + 1) + " ::\t");
				System.out.println(Util.format_order_topologicalSort(sort.sort(list_adjLists.get(i))));
			});
	}

	/**
	 * Runs the program.
	 */
	private void run() throws IOException {
		final Main main = new Main();
		main.select(main);
	}

	public static void main(String... args) throws IOException {
		new Main().run();
	}


}
