package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Represents campus locations and routes as a graph. */
public class CampusGraph {
	private final Map<String, Set<String>> adjacencyList = new LinkedHashMap<>();

	/** Adds a campus location if it does not already exist. */
	public void addLocation(String location) {
		if (location == null || location.trim().isEmpty()) {
			return;
		}

		adjacencyList.putIfAbsent(location, new LinkedHashSet<>());
	}

	/** Removes a location and all connections leading to it. */
	public void removeLocation(String location) {
		if (location == null || !adjacencyList.containsKey(location)) {
			return;
		}

		adjacencyList.remove(location);
		for (Set<String> connections : adjacencyList.values()) {
			connections.remove(location);
		}
	}

	/** Adds an undirected connection between two existing locations. */
	public void addConnection(String firstLocation, String secondLocation) {
		if (!hasLocation(firstLocation) || !hasLocation(secondLocation)
				|| firstLocation.equals(secondLocation)) {
			return;
		}

		adjacencyList.get(firstLocation).add(secondLocation);
		adjacencyList.get(secondLocation).add(firstLocation);
	}

	/** Removes an undirected connection between two locations. */
	public void removeConnection(String firstLocation, String secondLocation) {
		if (!hasLocation(firstLocation) || !hasLocation(secondLocation)) {
			return;
		}

		adjacencyList.get(firstLocation).remove(secondLocation);
		adjacencyList.get(secondLocation).remove(firstLocation);
	}

	/** Displays each location and its directly connected locations. */
	public void displayConnections() {
		for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	/** Returns locations in breadth-first order from the starting location. */
	public List<String> bfs(String startLocation) {
		List<String> traversal = new ArrayList<>();
		if (!hasLocation(startLocation)) {
			return traversal;
		}

		Set<String> visited = new HashSet<>();
		Deque<String> queue = new ArrayDeque<>();
		visited.add(startLocation);
		queue.add(startLocation);

		while (!queue.isEmpty()) {
			String currentLocation = queue.remove();
			traversal.add(currentLocation);

			for (String connection : adjacencyList.get(currentLocation)) {
				if (visited.add(connection)) {
					queue.add(connection);
				}
			}
		}

		return traversal;
	}

	/** Returns locations in depth-first order from the starting location. */
	public List<String> dfs(String startLocation) {
		List<String> traversal = new ArrayList<>();
		if (!hasLocation(startLocation)) {
			return traversal;
		}

		Set<String> visited = new HashSet<>();
		dfsRecursive(startLocation, visited, traversal);
		return traversal;
	}

	private void dfsRecursive(String location, Set<String> visited, List<String> traversal) {
		visited.add(location);
		traversal.add(location);

		for (String connection : adjacencyList.get(location)) {
			if (!visited.contains(connection)) {
				dfsRecursive(connection, visited, traversal);
			}
		}
	}

	private boolean hasLocation(String location) {
		return location != null && adjacencyList.containsKey(location);
	}
}
