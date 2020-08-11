package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class combination_2565 {
	private static int N, R;
	static boolean answer;
	private static int[][] numbers, input; // 순열 저장 배열, 입력된 숫자 배
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input= new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < input.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input, Comparator.comparingInt(o1 -> o1[0]));
		
		for (int i = 7; i > 0; i--) {
			R = i;
			numbers = new int[R][2];
			combination(0,0);
			if(answer==true) {
				System.out.println(N-R);
				break;
			}
		}
		
		
	}
	private static void combination(int cnt, int start) {
		if(cnt==R) {
			for (int i = 0; i < R-1; i++) {
				if(numbers[i+1][1]-numbers[i][1]<0) {
					return;
				}
			}
			answer = true;
			return;
		}
		
		// 현재 수부터 끝 수까지 시작 
		for (int i = start; i < input.length; i++) {
			numbers[cnt][0] = input[i][0];
			numbers[cnt][1] = input[i][1];
			combination(cnt+1,i+1);
		}
	}

}
