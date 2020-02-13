package baekjoon;

import java.util.Scanner;

public class bf_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int unit = 1;
		int count =0;
		while(num/unit!=0){
			unit=1*10;
			count++;
		}
			System.out.println(count);
		
		
	}

}
