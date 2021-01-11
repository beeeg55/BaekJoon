package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_14496 {

	private static int N;
	private static ArrayList[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		int answer = bfs(a,b);
		if(a==b) {
			System.out.println(0);
			System.exit(0);
		}
		if(answer==0) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}

	}

	private static int bfs(int a, int b) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(a);
		boolean[] visit = new boolean[N+1];
		visit[a] = true;
		int cnt = 0;
		while(!qu.isEmpty()) {
			int quSize = qu.size();
			for (int i = 0; i < quSize; i++) {
				int element = qu.poll();
				Iterator<Integer> iter = list[element].iterator();
				while(iter.hasNext()) {
					int n = iter.next();
					if(n==b) {
						return cnt+1;
					}
					if(!visit[n]) {
						visit[n] = true;
						qu.add(n);
					}
				}
			}
			cnt++;
		}
		return 0;
	}

}
