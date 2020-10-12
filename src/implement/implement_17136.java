package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_17136 {

	private static int[][] arr;
	private static int min = 100;

	public static void main(String[] args) throws IOException {
		arr = new int[10][10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rest = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					rest++;
				}
			}
		}
		min = 100;
		loop: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(arr[i][j]==1) {
					func(i, j, arr, new int[] { 0, 0, 0, 0, 0, 0 }, rest);
					break loop;
				}
			}
		}
		if(rest == 0) {
			System.out.println(0);
			System.exit(0);
		}
		if (min == 100) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void func(int a, int b, int[][] arr, int[] cnt, int rest) {
		for (int len = 0; len <= 4; len++) {
			int[][] copyarr = deepcopy(arr);
			int[] copycnt = deepcopy2(cnt);
			boolean flag = true;
			boolean isRange = true;
			if(copycnt[len+1]==5) continue;
			loop: for (int i = 0; i <= len; i++) {
				for (int j = 0; j <= len; j++) {
					if(a+i<0||a+i>=10||b+j<0||b+j>=10) {
						flag = false;
						isRange = false;
						break loop;
					}
					if(copyarr[a+i][b+j]==0) {
						flag = false;
						break loop;
					}
				}
			}
			if(!isRange) break;
			if(flag) {
				copycnt[len+1]++;
				for (int i = 0; i <= len; i++) {
					for (int j = 0; j <= len; j++) {
						copyarr[a+i][b+j]=0;
					}
				}
				if(rest-(len+1)*(len+1)==0) {
					int sum = 0;
					for (int i = 0; i < copycnt.length; i++) {
						sum += copycnt[i];
					}
					if(min>sum) {
						min = sum;
					}
				}
				int start = b;
				loop : for (int i = a; i < 10; i++) {
					for (int j = start; j < 10; j++) {
						if(copyarr[i][j]==1) {
							func(i, j, copyarr, copycnt, rest-(len+1)*(len+1));
							break loop;
						}
					}
					start = 0;
				}
			}
		}
		
	}

	private static int[] deepcopy2(int[] cnt) {
		int[] copyarr = new int[6];
		for (int i = 0; i < 6; i++) {
			copyarr[i] = cnt[i];
		}
		return copyarr;
	}

	private static int[][] deepcopy(int[][] arr) {
		int[][] copyarr = new int[10][10];
		for (int i = 0; i < copyarr.length; i++) {
			for (int j = 0; j < copyarr.length; j++) {
				copyarr[i][j] = arr[i][j];
			}
		}
		return copyarr;
	}

}
