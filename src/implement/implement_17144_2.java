package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_17144_2 {

	private static int[][] map;
	private static int C;
	private static int R;
	private static int[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		robot = new int[2];
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && !flag) {
					flag = true;
					robot[0] = i;
					robot[1] = i + 1;
				}
			}
		}
		int time = 0;
		while (time < T) {
			expandDust();
			cleanup();
			cleandown();
			map[robot[0]][1] = 0;
			map[robot[1]][1] = 0;
			time++;
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum+2);
	}

	private static void cleandown() {
		int[][] copymap = copyarr();
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int r = robot[1];
		int c = 1;
		for (int i = 0; i < dc.length; i++) {
			while (true) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!isRange(nr, nc) || (nr == robot[1] && nc == 0)) {
					break;
				}
				map[nr][nc] = copymap[r][c];
				r = nr;
				c = nc;
			}
		}
		
	}

	private static void cleanup() {
		int[][] copymap = copyarr();
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { 1, 0, -1, 0 };
		int r = robot[0];
		int c = 1;
		for (int i = 0; i < dc.length; i++) {
			while (true) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!isRange(nr, nc) || (nr == robot[0] && nc == 0)) {
					break;
				}
				map[nr][nc] = copymap[r][c];
				r = nr;
				c = nc;
			}
		}

	}

	private static void expandDust() {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[][] copymap = copyarr();
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (copymap[i][j] > 0) {
					int count = 0;
					for (int k = 0; k < 4; k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						if (isRange(r, c) && copymap[r][c] != -1) {
							count++;
						}
					}
					int amount = copymap[i][j] / 5;
					map[i][j] += (copymap[i][j] - amount * count);
					for (int k = 0; k < 4; k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						if (isRange(r, c) && copymap[r][c] != -1) {
							map[r][c] += copymap[i][j] / 5;
						}
					}
				}
			}
		}
		map[robot[0]][0] = -1;
		map[robot[1]][0] = -1;
	}

	private static boolean isRange(int r, int c) {
		if (0 > r || r >= R || 0 > c || c >= C) {
			return false;
		}
		return true;
	}

	private static int[][] copyarr() {
		int[][] copymap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		return copymap;
	}

}
