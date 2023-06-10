package graph;

/*
 * Created by 0x1nbetw33n on 07. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a graph as a map of adjacency lists.
 */
final class AdjLists extends Graph {

	private final Map<Object, List<Object>> adjLists = new LinkedHashMap<>();

	/**
	 * Retrieves the value of {@link #adjLists} without modifying it.
	 * @return the value of {@link #adjLists}
	 */
	Map<Object, List<Object>> get_AdjLists() {
		return adjLists;
	}

	/**
	 * Prints {@link #adjLists} to the console.
	 */
	void print_adjLists() {
		this.get_AdjLists()
			.forEach((o, objects) -> System.out.println(o + " -> " + objects));
	}

	/**
	 * Adds a new adjacency list to the end of {@link #adjLists}
	 * @param key the key of the adjacency list
	 * @param values the values of the adjacency list
	 */
	void add_adjList(Object key, List<Object> values) {
		get_AdjLists().put(key, values);
	}

	/**
	 * Retrieves the keys of {@link #adjLists} without modifying them.
	 * @return the keys as a list
	 */
	List<Object> get_keys() {
		return new ArrayList<>(get_AdjLists().keySet());
	}

	/**
	 * Retrieves the values of a key in {@link #adjLists} without modifying them.
	 * @param key the key
	 * @return the values as a list
	 */
	List<Object> get_values(final Object key) {
		return get_AdjLists().get(key);
	}

	/**
	 * Checks if a key is contained in any values of {@link #adjLists}.
	 * @param key the key
	 * @return true if the key is contained in any values, false otherwise
	 */
	@SuppressWarnings("BooleanMethodIsAlwaysInverted")
	public boolean contains_value(final Object key) {
		return this.get_AdjLists()
			.values()
			.stream()
			.anyMatch(values -> values.contains(key));
	}
}
