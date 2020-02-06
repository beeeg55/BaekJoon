package baekjoon;

import java.util.Scanner;

public class factorial {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		System.out.println(mul(num));
	}	
	public static int mul(int i){
		if(i>1){
		return i * mul(i-1);
		}
		else{
			return 1;
		}
	}
}
	
