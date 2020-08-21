package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sort_5052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine()); 
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine()); // 전화번호 개수 
			String[] tel = new String[n];
			for (int j = 0; j < tel.length; j++) {
				tel[j] = br.readLine();
			}
			Arrays.sort(tel); // 전화번호 정렬 
			boolean flag = true;
			for (int j = 1; j < tel.length; j++) {
				String before = tel[j-1];
				String after = tel[j];
				if(before.length()>=after.length()) {
					continue;
				}
				if(before.equals(after.substring(0,before.length()))) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
