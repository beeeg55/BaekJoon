package kakao;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키 {

	private static ArrayList<Integer> list;

	public static int solution(String[][] relation) {

		int rowLen = relation.length;
		int colLen = relation[0].length;
		list = new ArrayList<Integer>();
		for (int subset = 1; subset <= (1 << colLen) - 1; subset++) {
			HashSet<String> hs = new HashSet<>();
			for (int row = 0; row < rowLen; row++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < relation[row].length; k++) {
					if ((subset & (1 << k)) > 0) {
						sb.append(relation[row][k]);
					}
				}
				hs.add(sb.toString());
			}

			if (hs.size() == rowLen) {
				boolean flag = true;
				for (int i = 0; i < list.size(); i++) {
					if ((list.get(i) & subset) == list.get(i)) {
						flag = false;
					}
				}
				if(flag) {
					list.add(subset);
				}
			}
		}
		return list.size();
	}
}
