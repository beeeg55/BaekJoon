package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bfs_17070_2 {
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };
	private static int[][] map;
	private static boolean[][][] impossible;
	private static int count;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		impossible = new boolean[N][N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Dfs(0, 1, 0);
		System.out.println(count);
	}

	private static void Dfs(int i, int j, int mode) {
		if (i == N - 1 && j == N - 1) {
			count++;
			return;
		}
		for (int k = mode - 1; k <= mode + 1; k++) {
			// 45도씩만 회전
			if (k == -1 || k == 3)
				continue;
			int r = i + dr[k];
			int c = j + dc[k];
			if (k == 0 || k == 2) {
				if (inRange(r, c) && map[r][c] == 0) {
					if (impossible[r][c][k])
						continue;
					Dfs(r,c,k);
				} else {
					if (inRange(r, c)) {
						impossible[r][c][k] = true;
					}
				}
			} else {
				if (inRange(r, c) && map[r][c] == 0 && inRange(r - 1, c) && map[r - 1][c] == 0 && inRange(r, c - 1)
						&& map[r][c - 1] == 0) {
					if (impossible[i][j][k])
						continue;
					Dfs(r,c,k);
				} else {
					if (inRange(r, c)) {
						impossible[r][c][k] = true;
					}
				}
			}
		}
	}
	

	private static boolean inRange(int r, int c) {
		if (r < N && c < N) {
			return true;
		}
		return false;
	}

}
