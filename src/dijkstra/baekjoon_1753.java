package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class baekjoon_1753 {
	static class Vertex implements Comparable<Vertex>{
		int no, totalDistance;
		public Vertex(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.totalDistance - o.totalDistance;
		}
		
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		final int INF= Integer.MAX_VALUE;
		
		ArrayList[] matrix = new ArrayList[V+1];
		for (int i = 1; i < V+1; i++) {
			matrix[i] = new ArrayList<Vertex>();
		}
		
		int[] distance = new int[V+1]; 
		boolean[] visited = new boolean[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			matrix[u].add(new Vertex(v,w));
		}
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pQueue.offer(new Vertex(start, distance[start]));
		
		Vertex current = null;
		
		while(!pQueue.isEmpty()) {
			current = pQueue.poll();
			
			if(visited[current.no]) continue; 
			visited[current.no] = true;

			for (int j = 0; j < matrix[current.no].size(); j++) {
				Vertex n =  (Vertex) matrix[current.no].get(j);
				if (!visited[n.no] &&  distance[n.no] > current.totalDistance + n.totalDistance){
					distance[n.no] = current.totalDistance + n.totalDistance;
					pQueue.offer(new Vertex(n.no, distance[n.no]));
				}
			}
		}

		
		for (int i = 1; i < distance.length; i++) {
			if(distance[i]==INF) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
	}

}
