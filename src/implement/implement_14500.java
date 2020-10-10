package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_14500 {
	
	private static int[][] arr;
	private static int N;
	private static int M;
	private static int max = 0;
	private static int a;
	private static int b;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//3x2
		a = 3; b=2;
		int[][] arr1 = {{1,0},{1,0},{1,1}};
		calMax(arr1);
		int[][] arr2 = {{1,1},{0,1},{0,1}};
		calMax(arr2);
		int[][] arr3 = {{1,0},{1,1},{0,1}};
		calMax(arr3);
		int[][] arr4 = {{1,0},{1,1},{1,0}};
		calMax(arr4);
		int[][] arr5 = {{0,1},{1,1},{0,1}};
		calMax(arr5);
		int[][] arr17 = {{0,1},{0,1},{1,1}};
		calMax(arr17);
		int[][] arr18 = {{1,1},{1,0},{1,0}};
		calMax(arr18);
		int[][] arr19 = {{0,1},{1,1},{1,0}};
		calMax(arr19);
		
		
		//2x2
		a=2;b=2;
		int[][] arr6 = {{1,1},{1,1}};
		calMax(arr6);
		
		//4x1
		a=4;b=1;
		int[][] arr7 = {{1},{1},{1},{1}};
		calMax(arr7);
		
		//1x4
		a=1;b=4;
		int[][] arr8 = {{1,1,1,1},{0,0,0,0}};
		calMax(arr8);
		
		//2x3
		a=2;b=3;
		int[][] arr9 = {{1,1,1},{1,0,0}};
		calMax(arr9);
		int[][] arr10 = {{0,0,1},{1,1,1}};
		calMax(arr10);
		int[][] arr11 = {{0,1,1},{1,1,0}};
		calMax(arr11);
		int[][] arr12 = {{0,1,0},{1,1,1}};
		calMax(arr12);
		int[][] arr13 = {{1,1,1},{0,1,0}};
		calMax(arr13);
		int[][] arr14 = {{1,1,0},{0,1,1}};
		calMax(arr14);
		int[][] arr15 = {{1,1,1},{0,0,1}};
		calMax(arr15);
		int[][] arr16 = {{1,0,0},{1,1,1}};
		calMax(arr16);
		
		System.out.println(max);
		
	}

	private static void calMax(int[][] t) {
		for (int i = 0; i <= N-a; i++) {
			for (int j = 0; j <= M-b; j++) {
				int sum = 0;
				for (int r = 0; r < a; r++) {
					for (int c = 0; c < b; c++) {
						sum += arr[i+r][j+c]*t[r][c];
					}
				}
				if(sum>max) {
					max = sum;
				}
			}
		}
	}

}
