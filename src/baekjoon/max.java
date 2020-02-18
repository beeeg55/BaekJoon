package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class max {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
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
