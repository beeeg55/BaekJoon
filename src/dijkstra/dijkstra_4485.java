package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra_4485 {

	private static int[][] map;
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static int[][] dist;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int problem = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dijkstra();
			System.out.println("Problem "+problem+++": "+dist[N-1][N-1]);
		}
	}
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		pq.offer(new Node(0,0,map[0][0]));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.rupy> dist[now.r][now.c]) continue;
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(!isRange(nr,nc)) continue;
				if(dist[nr][nc]>dist[now.r][now.c]+map[nr][nc]) {
					dist[nr][nc]=dist[now.r][now.c]+map[nr][nc];
					pq.offer(new Node(nr,nc,dist[nr][nc]));
				}
			}
		}
		
	}
	private static boolean isRange(int nr, int nc) {
		if(nr<0||nr>= N||nc<0||nc>= N) {
			return false;
		}
		return true;
	}
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int rupy;
		public Node(int r,int c, int rupy) {
			this.r = r;
			this.c = c;
			this.rupy = rupy;
		}
		@Override
		public int compareTo(Node o) {
			return this.rupy -o.rupy;
		}
		
	}

}
