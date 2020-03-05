package bf;

import java.util.Scanner;

public class bf_2231 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		int unit = 1;
		int count =0;
		int p=0;
		int q=p;
		String temp="";
		while(p<=num){
			q = p;
			temp = Integer.toString(q);
			for(int i=0;i<temp.length();i++){
				q += Character.getNumericValue(temp.charAt(i));
			}
			if(num==q){
				break;
			}
			p++;
		}
		if(num<p){
			System.out.println(0);
		}
		else{
			System.out.println(p);
		}
		
	}

}


