package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class sort_1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0;i<n;i++){
			arr[i] = br.readLine();
		}
		Arrays.sort(arr);
		Arrays.sort(arr, Comparator.comparingInt(o1 -> o1.length()));
		for(int i=0;i<n;i++){
			if(i==0||arr[i].equals(arr[i-1])==false){
				System.out.println(arr[i]);
			}
		}
	}

}
