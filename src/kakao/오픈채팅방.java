package kakao;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

	public String[] solution(String[] record) {
		ArrayList<Record> list = new ArrayList<>(); // 로그용
		HashMap<String, String> hm = new HashMap(); // 아이디 갱신
		for (int i = 0; i < record.length; i++) {
			String[] temp = record[i].split(" ");
			switch (temp[0]) {
			case "Enter":
				list.add(new Record(0, temp[1]));
				hm.put(temp[1], temp[2]);
				break;
			case "Leave":
				list.add(new Record(1, temp[1]));
				break;
			case "Change":
				hm.replace(temp[1], temp[2]);
				break;
			}
		}

		String[] answer = new String[list.size()];
		int index = 0;
		for (Record re : list) {
			if (re.motion == 0) {
				answer[index] = hm.get(re.userId) + "님이 들어왔습니다.";
			} else {
				answer[index] = hm.get(re.userId) + "님이 나갔습니다.";
			}
			index++;
		}
		return answer;
	}

	static class Record {
		int motion; // 0: 입장 , 1: 퇴장
		String userId; // 유저아이디

		public Record(int motion, String userId) {
			super();
			this.motion = motion;
			this.userId = userId;
		}
	}
}
