package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Dfs_11725 {

	private static int N;
	private static ArrayList[] arr;
	private static boolean[] visit;
	private static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		visit = new boolean[N+1];
		parents = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		dfs(1,1);
		for (int i = 2; i < N+1; i++) {
			System.out.println(parents[i]);
		}
		
	}

	private static void dfs(int i, int parent) {
		visit[i] = true;
		Iterator<Integer> iter = arr[i].iterator();
		while(iter.hasNext()) {
			int ch = iter.next();
			if(!visit[ch]) {
				parents[ch] = i;
				dfs(ch,i);
			}
		}
	}
	
}
