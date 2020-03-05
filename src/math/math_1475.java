package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class math_1475 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int arr[] = new int[10];
		Arrays.fill(arr, 0);
		for(int i=0;i<s.length();i++){
			int temp = Character.getNumericValue(s.charAt(i));
			arr[temp] += 1;
		}
		
		int count69 = (arr[6]+arr[9]+1)/2;
		arr[6]=0;
		arr[9]=0;
		Arrays.sort(arr);
		int countOther = arr[9];
		if(count69<=countOther){
			System.out.println(countOther);
		}
		else{
			System.out.println(count69);
		}
		
	}

}
