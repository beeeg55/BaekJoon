package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_13565 {

	private static int M;
	private static int N;
	private static char[][] arr;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new char[M][N];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		boolean conn = Bfs();
		if(conn) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	private static boolean Bfs() {
		Queue<int[]> qu = new LinkedList<>();
		boolean visit[][] = new boolean[M][N];
		for (int i = 0; i < N; i++) {
			if(arr[0][i]=='0') {
				qu.add(new int[] {0,i});
				visit[0][i] = true;
			}
		}
		while(!qu.isEmpty()) {
			int[] temp = qu.poll();
			for (int d = 0; d < 4; d++) {
				int r = temp[0] + dr[d];
				int c = temp[1] + dc[d];
				if(0<=r&&r<M&&0<=c&&c<N&&!visit[r][c]&&arr[r][c]=='0') {
					qu.add(new int[] {r,c});
					visit[r][c] = true;
					if(r==M-1) {
						return true;
					}
				}
			}
		}
		return false;
		
	}

}
