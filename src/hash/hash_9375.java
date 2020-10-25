package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hash_9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < num; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String item = st.nextToken();
				String type = st.nextToken();
				
				map.put(type, map.getOrDefault(type, 0)+1);
			}
			int sum = 1;
			for(String key : map.keySet()) {
				sum *= (map.get(key)+1);
			}
			System.out.println(sum-1);
		}

	}

}
