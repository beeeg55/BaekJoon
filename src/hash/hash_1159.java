package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class hash_1159 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char start = s.charAt(0);
			map.put(start, map.getOrDefault(start, 0)+1);
		}
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		boolean flag = false;
		for (int i = 0; i < keys.length; i++) {
			if(map.get(keys[i])>4) {
				flag = true;
				System.out.print(keys[i]);
			}
		}
		if(!flag) {
			System.out.println("PREDAJA");
		}
	}

}
