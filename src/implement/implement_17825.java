package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_17825 {
	static int[][] route = {{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
	 {10,13,16,19,25,30,35,40},
	 {20,22,24,25,30,35,40},
	 {30,28,27,26,25,30,35,40}};
	static int[] input = new int[10];
	private static int[] step;
	private static int[][] horse;
	private static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		step = new int[10];
		for (int i = 0; i < 10; i++) {
			step[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		System.out.println(max);
	}
	private static void permutation(int cnt) {
		if(cnt == 10) {
			go();
			return;
		}
		for (int j = 0; j < 4; j++) {
			input[cnt] = j;
			permutation(cnt+1);
		}
		
	}
	private static void go() {
		horse = new int[4][2];
		int sum = 0;
		for (int i = 0; i < step.length; i++) {
			int N = input[i]; // 움직일 말
			int map = horse[N][0]; // 움직일 말의 루트 
			int loc	= horse[N][1]; // 움직일 말의 루트에서의 위치 
			if(loc==-1) return; // 위치가 도착지점이면 이동 x 
			int dest = loc+step[i]; // 도착지점 
			if(dest>=route[map].length) {
				horse[N][1] = -1;
				continue;
			}
//			if(dest>route[map].length) {
//				return;
//			}
			// 도착지점이 맵을 넘어가면 
			int destScore = route[map][dest]; // 도착지점 점수 
			if(destScore==10) {
				horse[N][0] = 1;
				horse[N][1] = 0;
			}else if( destScore==20) {
				horse[N][0] = 2;
				horse[N][1] = 0;
			}else if( destScore==25) {
				horse[N][0] = 1;
				horse[N][1] = 4;
			}else if( horse[N][0] !=0 && destScore==30) {
				horse[N][0] = 1;
				horse[N][1] = 5;
			}else if(destScore==35) {
				horse[N][0] = 1;
				horse[N][1] = 6;
			}else if(horse[N][0] ==0 && destScore==30) {
				horse[N][0] = 3;
				horse[N][1] = 0;
			}else {
				horse[N][1] = dest;
			}
			// 겹치는 말이 있으면 
			for (int j = 0; j < horse.length; j++) {
				if(j==N) continue;
				if(horse[j][1]==-1) continue; // 도착지점이면 패스 
//				if(horse[j][0]==0&&horse[j][1]==0) continue;
				if(horse[j][0]==horse[N][0]&&horse[j][1]==horse[N][1]) { 
					return;
				}
				if(destScore == 40 && route[horse[j][0]][horse[j][1]]==40) {
					return;
				}
			}
			sum += destScore;
		}
		if(sum>max) {
			max = sum;
		}
		
	}

}
