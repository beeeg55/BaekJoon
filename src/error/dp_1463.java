package error;

import java.util.Scanner;
//도전실패
public class dp_1463 {
	static long n;
	static int count;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		count = 0;
		calculator();
		System.out.println(count);
	}
	public static void calculator(){
		while(n!=1){
			if(n%3==0){
				while(n%3 ==0){
					n=n/3;
					count++;
				}
			}
			if(n!=1&&(n-1)%3==0){
				n=n-1;
				count++;
				calculator();
			}
			if(n%2==0){
				while(n%2==0){
					n=n/2;
					count++;
				}
			}
			if(n!=1&&(n-1)%3==0){
				n=n-1;
				count++;
				calculator();
			}
			if(n==2){
				n=n-1;
				count++;
			}
		}
	}

}
