package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_2578 {
	static int r,c;
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		map = new int[5][5];
		int count = 0;
		int cntRow[] = new int[5];
		int cntCol[] = new int[5];
		int cntDia[] = new int[2];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				answer ++;
				int target = Integer.parseInt(st.nextToken());
				search(target);
				
				if(++cntRow[r] == 5) {
					count++;
				}
				if(++cntCol[c] == 5) {
					count++;
				}
				if(r==c) {
					if(++cntDia[0] == 5) {
						count++;
					}
				}
				if(r==4-c) {
					if(++cntDia[1] == 5) {
						count++;
					}
				}
				if(count>=3) {
					System.out.println(answer);
					System.exit(0);
				}
			}
		}
		
		
	}

	private static void search(int target) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == target) {
					r = i;
					c = j;
					return;
				}
			}
		}
		
	}
	

}
