package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class combination_swea_4613 {
	private static int n;
	private static int m;
	private static int min = Integer.MAX_VALUE;
	private static char[][] map;
	static int[] input = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			combination(1, 0);
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void combination(int start, int count) {
		if (count == 2) {
			int temp = 0;
			for (int i = 0; i < input[0]; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 'W') {
						temp++;
					}
				}
			}
			for (int i = input[0]; i < input[1]; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 'B') {
						temp++;
					}
				}
			}
			for (int i = input[1]; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 'R') {
						temp++;
					}
				}
			}
			if (temp < min) {
				min = temp;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			input[count] = i;
			combination(i + 1, count + 1);
		}

	}

}
