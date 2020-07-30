package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class combination_1759 {
	private static int L, C;
	private static char[] numbers, input; // 순열 저장 배열, 입력된 숫자 배
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L =Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());
		numbers = new char[L];
		input = new char[C];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		combination(0,0);
		System.out.println(sb.toString());
	}

	// 지정된 자리에 조합 수 뽑기 
	private static void combination(int cnt, int start) { // cnt: 현재까지 뽑은 순열의 갯수, start: 조합에 시작점으로 시도할 인덱스 
		if(cnt==L) {
			int alpha = 0;
			for (int i = 0; i < L; i++) {
				if(numbers[i]=='a'||numbers[i]=='e'||numbers[i]=='i'||numbers[i]=='o'||numbers[i]=='u') {
					alpha++;
				}
			}
			if(alpha==0||L-alpha<2) {
				return;
			}else {
				String s = "";
				for (int i = 0; i < L; i++) {
					s += numbers[i];
				}
				sb.append(s+"\n");
			}
			return;
		}
		
		// 현재 수부터 끝 수까지 시작 
		for (int i = start; i < input.length; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
		
	}
}
