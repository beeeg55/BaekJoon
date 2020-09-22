package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_14890 {

	private static int L;
	private static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		// 가로 탐색
		for (int i = 0; i < N; i++) {
			if(searchRow(i,map)) {
				answer++;
			}
		}
		// 세로 탐색
		for (int i = 0; i < N; i++) {
			if(searchCol(i,map)) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static boolean searchRow(int i, int[][] map) {
		boolean[] build = new boolean[N];
		for (int j = 0; j < N-1; j++) {
			int temp = map[i][j]-map[i][j+1];
			if(build[j]) { // 이미 경사로가 있는 곳
				if(temp==-1) { // 내리막길 놔야대면 패스
					return false;
				}
				if(temp!=1) { // 평지면 패스
					continue;
				}
				// 내리막길을 놔봐야대면 계속 진행 
			}
			if(temp == 0) {
				continue;
			}else if(Math.abs(temp)>1) {
				return false;
			}else if(temp==1){ //내리막길을 만들어야 된다면
				if(build[j+1]) return false; // 이미 지어진 경사로
				for (int k = 1; k < L; k++) {
					if(j+1+k>=N||map[i][j+1]!=map[i][j+1+k]) {
						return false;
					}
					build[j+1+k] = true;
				}
				build[j+1] = true; // 경사로 지어진거 표시 
			}else { // 오르막길을 만들어야 한다면
				for (int k = 1; k < L; k++) {
					if(j-k<0||build[j-k]||map[i][j]!=map[i][j-k]) {
						return false;
					}
					build[j-k] = true;
				}	
				build[j] = true;
			}
		}
		return true;
	}
	
	private static boolean searchCol(int j, int[][] map) {
		boolean[] build = new boolean[N];
		for (int i = 0; i < N-1; i++) {
			int temp = map[i][j]-map[i+1][j];
			if(build[i]) {
				if(temp==-1) {
					return false;
				}
				if(temp!=1) {
					continue;
				}
			}
			if(temp == 0) {
				continue;
			}else if(Math.abs(temp)>1) {
				return false;
			}else if(temp==1){ //내리막길을 만들어야 된다면
				if(build[i+1]) return false;
				for (int k = 1; k < L; k++) {
					if(i+1+k>=N||map[i+1][j]!=map[i+1+k][j]) {
						return false;
					}
					build[i+1+k]=true;
				}		
				build[i+1]=true;
			}else { // 오르막길을 만들어야 한다면
				for (int k = 1; k < L; k++) {
					if(i-k<0||build[i-k]||map[i][j]!=map[i-k][j]) {
						return false;
					}
					build[i-k] = true;
				}	
				build[i] = true;
			}
		}
		return true;
	}
	

}
