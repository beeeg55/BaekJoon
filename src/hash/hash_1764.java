package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hash_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(set.contains(s)) {
				arr.add(s);
			}
		}
		System.out.println(arr.size());
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
	}

}
