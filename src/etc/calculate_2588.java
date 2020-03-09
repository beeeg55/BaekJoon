package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class calculate_2588 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n1= br.readLine();
		int intn1 = Integer.parseInt(n1);
		String n2= br.readLine();
		
		int n3 = intn1*Character.getNumericValue(n2.charAt(2)); 
		int n4 = intn1*Character.getNumericValue(n2.charAt(1));
		int n5 = intn1*Character.getNumericValue(n2.charAt(0));
		int n6 = n3 + n4*10 + n5 *100;
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n5);
		System.out.println(n6);
		
	}

}
