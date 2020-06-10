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
             
             pAlphabetLow = Pattern.compile("[a-z]");             // ���ҹ���
             pAlphabetUp = Pattern.compile("[A-Z]");             // ���빮��
             pNumber = Pattern.compile("[0-9]");                     // ����
             pSpecialChar = Pattern.compile("\\p{Punct}");         // Ư������ -_=+\\|()*&^%$#@!~`?></;,.:'
             pThreeChar = Pattern.compile("(\\p{Alnum})\\1{2,}");// 3�ڸ� �̻� ���� ���� �Ǵ� ����
  
             // ���ҹ��ڰ� ���ԵǾ� �ִ°�?
             match = pAlphabetLow.matcher(s);
             if(match.find()) level++;
             // ���빮�ڰ� ���ԵǾ� �ִ°�?
             match = pAlphabetUp.matcher(s);
             if(match.find()) level++;
             // ���ڰ� ���ԵǾ� �ִ°�?
             match = pNumber.matcher(s);
             if(match.find()) level++;
             // Ư�����ڰ� ���ԵǾ� �ִ°�?
             match = pSpecialChar.matcher(s);
             if(match.find()) level++;
             
             
         } catch (Exception ex) {
             
         }
         System.out.println("LEVEL"+level);
		
	}
}