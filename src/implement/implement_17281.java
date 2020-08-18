package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class implement_17281 {
	private static boolean[] visit;
	private static int[] seq = new int[10];
	private static int N;
	private static int[][] players;
	private static int answer = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		players = new int[N][10];
		visit = new boolean[10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[0] = true;
		visit[1] = true;
		order(1);
		System.out.println(answer);
		
	}

	// 순열 
	private static void order(int cnt) {
		if (cnt == 10) {
			int temp = baseball();
			if(temp>answer) {
				answer = temp;
			}
			return;
		}
		if (cnt == 4) {
			seq[4] = 1;
			order(cnt + 1);
		}
		for (int i = 2; i <= 9; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			seq[cnt] = i;
			order(cnt + 1);
			visit[i] = false;
		}
	}
	private static int baseball() {
		int score = 0;
		int ord = 1;
		int inning = 0;
		boolean[] roo ;
		while (inning < N) {
			roo = new boolean[4];
			int outCount = 0;
			while (outCount < 3) {
				if(ord==10) ord = 1;
				int player = seq[ord]; // 현재 선수
				switch (players[inning][player]) {
				case 0: // 아웃
					outCount++; // 아웃카운트 늘리기
					break;
				case 1: // 안타
					if(roo[3]) {
						score++;
					}
					roo[3] = roo[2];
					roo[2] = roo[1];
					roo[1] = true;
					break;
				case 2: // 2루타 
					if(roo[3]) {
						score++;
					}
					if(roo[2]) {
						score++;
					}
					roo[3] = roo[1];
					roo[2] = true;
					roo[1] = false;
					break;
				case 3: // 3루타 
					if(roo[3]) {
						score++;
					}
					if(roo[2]) {
						score++;
					}
					if(roo[1]) {
						score++;
					}
					roo[3] = true;
					roo[2] = false;
					roo[1] = false;
					break;
				case 4: // 홈런 
					if(roo[3]) {
						score++;
					}
					if(roo[2]) {
						score++;
					}
					if(roo[1]) {
						score++;
					}
					score++;
					Arrays.fill(roo, false);
					break;
				}
				ord++;
			}
			inning++;
		}
		return score;
	}
}
