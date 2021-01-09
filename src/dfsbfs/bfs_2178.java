package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2178 {

	private static int N;
	private static int M;
	private static char[][] arr;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		System.out.println(Bfs());

	}

	private static int Bfs() {
		boolean visit[][] = new boolean[N][M];
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {0,0});
		visit[0][0] = true;
		int len = 1;
		while(!qu.isEmpty()) {
			int quSize = qu.size();
			for (int i = 0; i < quSize; i++) {
				int[] temp = qu.poll();
				for (int d = 0; d < 4; d++) {
					int r = temp[0] + dr[d];
					int c = temp[1] + dc[d];
					if(isRange(r,c)&&arr[r][c]=='1'&&!visit[r][c]) {
						if(r==N-1&&c==M-1) {
							return len+1;
						}
						visit[r][c] = true;
						qu.add(new int[] {r,c});
					}
				}
			}
			len++;
		}
		return 0;
		
	}

	private static boolean isRange(int r, int c) {
		if(r<0||r>=N||c<0||c>=M) {
			return false;
		}
		return true;
	}

}
