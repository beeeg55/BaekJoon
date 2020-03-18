package error;

import java.util.Scanner;

public class math_1110 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int oldNum = in.nextInt();
		int newNum = oldNum;
		int count = integerCycle(oldNum,newNum);
		System.out.println(count);
	}
	public static int integerCycle(int oldNum,int newNum){
		int count = 0;
		do{
			int sum1 = (newNum/10 + newNum%10)%10;
			newNum = sum1 + newNum%10*10;
			count++;
		}while(oldNum != newNum);
		return count;
	}

}
