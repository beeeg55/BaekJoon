package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class string_10809 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char arr1[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int arr2[]=new int[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Arrays.fill(arr2, -1);
		for(int i=s.length()-1;i>=0;i--){
				arr2[Arrays.binarySearch(arr1, s.charAt(i))]=i;
			
		}
		for(int i=0;i<arr2.length;i++){
			System.out.print(arr2[i]+" ");
		}
	}

}
