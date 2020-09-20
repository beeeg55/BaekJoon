package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class combination_2309 {

	private static int sum;
	private static int noSelect[] = new int[2];
	private static int[] kid;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sum = 0;
		kid = new int[9];
		for (int i = 0; i < 9; i++) {
			kid[i] = Integer.parseInt(br.readLine());
			sum += kid[i];
		}
		combination(0,0,0);
	}

	private static void combination(int count, int start, int noSelectSum) {
		// TODO Auto-generated method stub
		if(count==2) {
			if(sum-noSelectSum==100) {
				int[] answer = new int[7];
				int index = 0;
				for (int i = 0; i < 9; i++) {
					if(noSelect[0]==i||noSelect[1]==i) {
						continue;
					}
					answer[index++] = kid[i];
				}
				Arrays.sort(answer);
				for (int i = 0; i < answer.length; i++) {
					System.out.println(answer[i]);
				}
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			noSelect[count] = i;
			combination(count+1, i+1, noSelectSum+ kid[i]);
		}
	}
	
}
