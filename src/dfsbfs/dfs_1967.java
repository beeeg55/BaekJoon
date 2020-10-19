package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class dfs_1967 {

	private static final int N = 0;
	private static int max;
	private static boolean[] visit;
	private static int n;
	private static ArrayList[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Node>();
		}
		int[] cnt = new int[n+1];
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,val));
			list[b].add(new Node(a,val));
			cnt[a]++;
			cnt[b]++;
		}
		max = 0;
		
		for (int i = 1; i < n+1; i++) {
			if(cnt[i]>1) continue;
			visit = new boolean[n+1];
			dfs(i,0);
		}
		System.out.println(max);

	}

	private static void dfs(int start, int sum) {
		visit[start] = true;
		boolean flag = false;
		Iterator<Node> iter = list[start].iterator();
		while(iter.hasNext()) {
			Node node = iter.next();
			if(!visit[node.point]) {
				flag = true;
				dfs(node.point, sum+node.val);
			}
		}
		
		if(!flag&&sum>max) {
			max = sum;
		}
		
	}
	static class Node{
		int point;
		int val;
		public Node(int point, int val) {
			this.point = point;
			this.val = val;
		}
	}
}
