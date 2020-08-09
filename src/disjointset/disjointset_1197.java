package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class disjointset_1197 {
	static int E, V;
	private static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Edge[] line = new Edge[E];
		parents = new int[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long val = Integer.parseInt(st.nextToken());
			line[i] = new Edge(from,to, val);
		}
		
		Arrays.sort(line);
		make();
		int cnt = 0;
		long sum = 0;
		int index = 0;
		while(index<E) {
			if(union(line[index].from ,line[index].to)) {
				cnt++;
				sum += line[index].val;
			}
			index++;
			if(cnt==V-1) break;
		}
		System.out.println(sum);
		
		
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB ) {
			return false;
		}
		parents[rootB] = rootA;
		return true;
	}
	
	private static int find(int i) {
		if(parents[i]==i) {
			return i;
		}
		return parents[i] = find(parents[i]);
	}
	
	private static void make() {
		for (int i = 1; i < V+1; i++) {
			parents[i] = i; 
		}
	}


}
class Edge implements Comparable<Edge>{
	int from;
	int to;
	long val;
	public Edge(int from, int to, long val) {
		super();
		this.from = from;
		this.to = to;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.val, o.val);
	}
	
}
