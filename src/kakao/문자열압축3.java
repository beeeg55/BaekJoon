package kakao;

public class 문자열압축3 {
	public int solution(String s) {
	       int answer = Integer.MAX_VALUE;
		        //압축 길이
		        for (int len = 1; len <= s.length()/2 + s.length()%2; len++) {
		
		            StringBuilder sb = new StringBuilder("");
		
		            int left	= 0;
		            int right 	= left+len;
		            int cnt 	= 1;
		
		            String s1 = s.substring(left,left+len);
		            sb.append(s1);
		
		            while(right+len <= s.length()) {
		
		                String s2 = s.substring(right,right+len);
		                if (!s1.equals(s2)) {
		                    left = right;
		                    s1 = s2;
		                    if (cnt > 1) sb.insert(sb.length()-len, cnt);
		                    sb.append(s1);
		                    cnt = 1;
		                } else {
		                    cnt++;
		                }
		                right += len;
		            }
		            if (cnt > 1) sb.insert(sb.length()-len, cnt);
		
		            sb.append(s.substring(right));
		            answer = Math.min(sb.length(), answer);
		        }
		
		        return answer;
	    }
}

