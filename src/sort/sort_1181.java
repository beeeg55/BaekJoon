package sort;
//¹Ì¿Ï¼º
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class sort_1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int num = Integer.getInteger(s);
		
		String input[] = new String[num];
		int size[] = new int[num];
		
		for(int i=0;i<num;i++){
			input[i] = br.readLine();
			size[i] = input[i].length();
			//map.put(s1.length(), s1)
		}
		Arrays.sort(input);
		Arrays.sort(size);
		
	}

}
