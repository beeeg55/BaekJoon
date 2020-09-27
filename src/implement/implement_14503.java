package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_14503 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int curR = Integer.parseInt(st.nextToken());
		int curC = Integer.parseInt(st.nextToken());
		int curD = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		loop: while (true) {
			if (map[curR][curC] == 0) {
				map[curR][curC] = 2;
				answer++;
			}
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int r = curR + dr[(curD +3- i) % 4];
				int c = curC + dc[(curD +3- i) % 4];
				if (0 <= r && r < N && 0 <= c && c < M && map[r][c] == 0) {
					flag = true;
					curR = r;
					curC = c;
					curD = (curD + 3-i) % 4;
					break;
				}
			}
			if (flag) {
				continue;
			} else {
				int r = curR - dr[curD];
				int c = curC - dc[curD];
				if (0 <= r && r < N && 0 <= c && c < M && map[r][c] == 1) {
					break loop;
				} else {
					curR = r;
					curC = c;
				}
			}
		}
		System.out.println(answer);
	}

}
