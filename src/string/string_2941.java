package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string_2941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s=s.replaceAll("c=", "0");
		s=s.replaceAll("c-", "0");
		s=s.replaceAll("dz=", "0");
		s=s.replaceAll("d-", "0");
		s=s.replaceAll("lj", "0");
		s=s.replaceAll("nj", "0");
		s=s.replaceAll("s=", "0");
		s=s.replaceAll("z=", "0");
		
		System.out.println(s.length());
	}

}
