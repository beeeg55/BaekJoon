package baekjoon;

import java.util.Scanner;

public class max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long num = in.nextLong();
		long p = (long)num/2;
		while(p>1){
			if(num%p==0){
				for(long q=2;q<=(long)p/2;q++){
					if(p%q==0) break;
					if(q==(long)p/2){
						System.out.println(p);
						return;
					}
				}
			}
			p--;
		}
	}

}
