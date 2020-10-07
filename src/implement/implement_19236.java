package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_19236 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sea = new int[4][4];
		int[][] loc = new int[17][2];
		int[] dir = new int[17];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				dir[sea[i][j]] = Integer.parseInt(st.nextToken()) - 1;
				loc[sea[i][j]][0] = i;
				loc[sea[i][j]][1] = j;
			}
		}
		answer = 0;
		int sharkR = 0;
		int sharkC = 0;
		int sharkD = dir[sea[0][0]];
		int sum = sea[0][0];
		move(loc, sea, dir, sharkR, sharkC, sharkD, sum);
		System.out.println(answer);
	}

	public static boolean move(int[][] loc, int[][] sea, int[] dir, int sharkR, int sharkC, int sharkD, int sum) {
		int[][] cloc = new int[17][2];
		for (int i = 1; i <= 16; i++) {
			cloc[i][0] = loc[i][0];
			cloc[i][1] = loc[i][1];

		}
		int[][] csea = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				csea[i][j] = sea[i][j];
			}
		}

		int[] cdir = new int[17];
		for (int i = 1; i <= 16; i++) {
			cdir[i] = dir[i];
		}

		cdir[csea[sharkR][sharkC]] = -1;
		csea[sharkR][sharkC] = 0;
		// 물고기 이동
		for (int i = 1; i < 17; i++) {
			if (cdir[i] == -1)
				continue; // 물고기 없음
			for (int j = 0; j < 8; j++) {
				int r = cloc[i][0] + dr[(cdir[i] + j) % 8];
				int c = cloc[i][1] + dc[(cdir[i] + j) % 8];
				if (r == sharkR && c == sharkC)
					continue; // 이동할자리가 상어있는자리면 패스
				if (0 <= r && r < 4 && 0 <= c && c < 4) {
					if (csea[r][c] == 0) { // 빈자리면
						csea[r][c] = csea[cloc[i][0]][cloc[i][1]];
						csea[cloc[i][0]][cloc[i][1]] = 0;
						cloc[i][0] = r;
						cloc[i][1] = c;
					} else { // 아니면 교환
						int temp = csea[cloc[i][0]][cloc[i][1]];
						csea[cloc[i][0]][cloc[i][1]] = csea[r][c];
						csea[r][c] = temp;

						int tempr = cloc[i][0];
						int tempc = cloc[i][1];
						cloc[i][0] = r;
						cloc[i][1] = c;
						cloc[csea[tempr][tempc]][0] = tempr;
						cloc[csea[tempr][tempc]][1] = tempc;
					}
					cdir[csea[r][c]] = (cdir[i] + j) % 8;
					break;
				}

			}
		}

		boolean sharkmove = false;
		for (int i = 1; i <= 4; i++) {
			int r = sharkR + dr[sharkD] * i;
			int c = sharkC + dc[sharkD] * i;
			if (0 <= r && r < 4 && 0 <= c && c < 4) {
				if (csea[r][c] == 0)
					continue;
				sharkmove = true;
				move(cloc, csea, cdir, r, c, cdir[csea[r][c]], sum + csea[r][c]);
			} else {
				break;
			}
		}

		if (!sharkmove) {
			if (answer < sum) {
				answer = sum;
			}
		}
		return true;
	}

}
