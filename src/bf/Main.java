package bf;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int level = 0;
		if(s.length()>=10){
			level++;
		}
		 
         try {
             Pattern pAlphabetLow = null;
             Pattern pAlphabetUp = null;
             Pattern pNumber = null;
             Pattern pSpecialChar = null;
             Pattern pThreeChar = null;
             Matcher match;
             
             pAlphabetLow = Pattern.compile("[a-z]");             // 영소문자
             pAlphabetUp = Pattern.compile("[A-Z]");             // 영대문자
             pNumber = Pattern.compile("[0-9]");                     // 숫자
             pSpecialChar = Pattern.compile("\\p{Punct}");         // 특수문자 -_=+\\|()*&^%$#@!~`?></;,.:'
             pThreeChar = Pattern.compile("(\\p{Alnum})\\1{2,}");// 3자리 이상 같은 문자 또는 숫자
  
             // 영소문자가 포함되어 있는가?
             match = pAlphabetLow.matcher(s);
             if(match.find()) level++;
             // 영대문자가 포함되어 있는가?
             match = pAlphabetUp.matcher(s);
             if(match.find()) level++;
             // 숫자가 포함되어 있는가?
             match = pNumber.matcher(s);
             if(match.find()) level++;
             // 특수문자가 포함되어 있는가?
             match = pSpecialChar.matcher(s);
             if(match.find()) level++;
             
             
         } catch (Exception ex) {
             
         }
         System.out.println("LEVEL"+level);
		
	}
}