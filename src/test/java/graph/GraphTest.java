package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;


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
					Util.format_order_dfsBfs(search.sort(adjListsList.get(i)))
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