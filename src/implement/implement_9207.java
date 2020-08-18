package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class implement_9207 {
	static int min = Integer.MAX_VALUE;
	static int answerCount = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			min = Integer.MAX_VALUE;
			answerCount = 0;
			
			char[][] map = new char[5][9];
			
			int pin = 0;
			for (int i = 0; i < 5; i++) {
				String s = br.readLine();
				for (int j = 0; j < 9; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'o') {
						pin++;
					}
				}
			}
			game(map, pin, 0);
			System.out.println(min+" "+answerCount);			
			br.readLine();
		}

	}

	public static void game(char[][] map, int pin, int cnt) {
		boolean move = false;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if (map[i][j] == '.' && map[i][j + 1] == 'o' && map[i][j+2] == 'o') { // .oo 이 있으면
					move = true;
					// 이동
					map[i][j] = 'o';
					map[i][j + 1] = '.';
					map[i][j + 2] = '.';
					game(map, pin - 1, cnt + 1);
					// 복구 시키기
					map[i][j] = '.';
					map[i][j + 1] = 'o';
					map[i][j + 2] = 'o';
				}
				if (map[i][j] == 'o' && map[i][j + 1] == 'o' && map[i][j+2] == '.') { // oo.이 있으면
					move = true;
					// 이동
					map[i][j] = '.';
					map[i][j + 1] = '.';
					map[i][j + 2] = 'o';
					game(map, pin - 1, cnt + 1);
					// 복구 시키기
					map[i][j] = 'o';
					map[i][j + 1] = 'o';
					map[i][j + 2] = '.';
				}
			}
		}

		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 3; i++) {
				if (map[i][j] == '.' && map[i + 1][j] == 'o' && map[i + 2][j] == 'o') { // .oo( 세로버전 ) 이 있으면
					move = true;
					// 이동
					map[i][j] = 'o';
					map[i + 1][j] = '.';
					map[i + 2][j] = '.';
					game(map, pin - 1, cnt + 1);
					// 복구 시키기
					map[i][j] = '.';
					map[i + 1][j] = 'o';
					map[i + 2][j] = 'o';
				}
				if (map[i][j] == 'o' && map[i+1][j] == 'o' && map[i+2][j] == '.') { // oo.( 세로버전 ) 이 있으면
					move = true;
					// 이동
					map[i][j] = '.';
					map[i+1][j] = '.';
					map[i+2][j] = 'o';
					game(map, pin - 1, cnt + 1);
					// 복구 시키기
					map[i][j] = 'o';
					map[i+1][j] = 'o';
					map[i+2][j] = '.';
				}
			}
		}
		// 이동한 핀이 없으면 
		if (!move) {
			if (pin < min) {
				min = pin;
				answerCount = cnt;
			}
		}

	}
}
