import java.io.*;
import java.util.*;

public class Graph {
	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int v) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[v] = true;
		queue.add(v);

		while (queue.size() != 0) {
			int s = queue.pop();
			System.out.println(s);
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String args[])
	{
		Graph g = new Graph(4);
 
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
 
		g.BFS(2);
	}
}