package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sort_1427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		
		int[] arr = new int[a.length()];
		
		for(int i=0;i<a.length();i++){
			arr[i] = a.charAt(i)-48;
		}
		Arrays.sort(arr);
		for(int i = a.length()-1;i>=0;i--){
			System.out.print(arr[i]);
		}
		
	}

}
