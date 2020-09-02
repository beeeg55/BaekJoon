package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_15684 {

	private static int H, N, R;
	private static boolean success;
	private static boolean[][] ladder;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new boolean[H][N];
		// 가로선
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			ladder[a][b] = true;
		}
		for (R = 0; R <= 3; R++) {
			success = false;
			combination(0, 0);
		}
		System.out.println(-1);

	}

	private static void combination(int start, int cnt) {
		if (cnt == R) {
			success = checkDown();
			if (success) {
				System.out.println(R);
				System.exit(0);
			}

			return;
		}
		for (int i = 0; i < N * H; i++) {
			if (ladder[i / N][i % N]) // 이미 있는 경우 
				continue;
			if ((i % N + 1 < N) && ladder[i / N][i % N + 1]) // 오른쪽이랑 연속될 경우 
				continue;
			if (i % N - 1 >= 0 && ladder[i / N][i % N - 1]) // 왼쪽이랑 연속될 경우 
				continue;
			if(i%N == N-1) continue; // 마지막 줄은 오른쪽에 사다리를 놓을 수 없다. 
			ladder[i / N][i % N] = true;
			combination(start + 1, cnt + 1);
			ladder[i / N][i % N] = false;
		}
	}

	private static boolean checkDown() {
		for (int i = 0; i < N; i++) {
			int r = 0;
			int c = i;
			while (true) {
				if (0 <= c - 1 && ladder[r][c-1]) {// 왼쪽에 사다리가 있을 때
					c--;
					r++;
				} else if (ladder[r][c]) {// 오른쪽에 사다리가 있을 때
					c++;
					r++;
				} else {
					r++;
				}
				if (r == H) {
					break;
				}
			}
			if (c != i) {
				return false;
			}
		}
		return true;
	}

}
