package com.koreait.mvcframework.model.blood;

public class BloodService {
	public String getAdvice(String blood) {
		String msg = null;
		if (blood.equals("A형")) {
			msg = "소심하고 꼼꼼하고 책임감 강함";
		} else if (blood.equals("B형")) {
			msg = "멋찜멋찜";
		} else if (blood.equals("AB형")) {
			msg = "잘 어울리고 오지랖";
		} else if (blood.equals("O형")) {
			msg = "우유부단";
		}
		return msg;
	}
}
