package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_1107_2 {
    static boolean[] broken;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int start = 100;
        int channel = Integer.parseInt(br.readLine());
      
        int N = Integer.parseInt(br.readLine());
        if(N == 0) {
        	 System.out.println(Integer.toString(channel).length());
        	 return;
        }
        broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }
        if (start == channel) {
        	System.out.println(0);
        	return;
        }
        int ans = Math.abs(channel - start);
        for (int i = 0; i <= 1000000; i++) { 
            if (control(i)) {
                int tmp = Math.abs(i - channel) + ("" + i).length();
                if (ans > tmp) {
                    ans = tmp;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean control(int c) {
        String s = "" + c;
        for (int i = 0; i < s.length(); i++) {
            if (broken[s.charAt(i) - '0'])
                return false;
        }
        return true;
    }
}