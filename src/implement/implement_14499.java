package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_14499 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 명령의 개수 
		int[][] map = new int[N][M];
		int[] dice = new int[7]; // 1. 위 2. 뒤 3. 오 4. 왼 5. 앞 6. 밑 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < K; i++) {
			int ord = Integer.parseInt(st.nextToken());
			int temp = 0;
			switch (ord) {
			case 1: // 동쪽 
				if(y==M-1) continue;
				y = y+1;
				temp = dice[3];
				dice[3]= dice[1];
				dice[1]= dice[4];
				dice[4]= dice[6];
				dice[6]= temp;
				break;
				
			case 2: // 서쪽 
				if(y==0) continue;
				y = y-1;
				temp = dice[4];
				dice[4]= dice[1];
				dice[1]= dice[3];
				dice[3]= dice[6];
				dice[6]= temp;
				break;
				
			case 3: // 북쪽 
				if(x==0) continue;
				x = x-1;
				temp = dice[2];
				dice[2]= dice[1];
				dice[1]= dice[5];
				dice[5]= dice[6];
				dice[6]= temp;
				break;
				
			case 4: // 남쪽 
				if(x==N-1) continue;
				x = x+1;
				temp = dice[5];
				dice[5]= dice[1];
				dice[1]= dice[2];
				dice[2]= dice[6];
				dice[6]= temp;
				break;	
				
			}
			if(map[x][y]==0) {
				map[x][y] = dice[6];
			}else {
				dice[6] = map[x][y];
				map[x][y] = 0;
			}
			sb.append(dice[1]+"\n");
			
		}
		System.out.println(sb.toString());
	}

}
