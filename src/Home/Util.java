package Home;

import java.util.Random;

public class Util {

	private void calculateMultiplication() {
		try {
			
		} catch (NumberFormatException ex) {
			// 숫자가 아닌 값이 입력된 경우 처리
			
		}
	}

	public boolean Critical(double cri) {
		Random random = new Random();
		double randomNumber = random.nextInt(100) + 1;
		if (randomNumber < cri) {
			return true;
		}
		return false;
	}

	public double Dmg(double hp, double def, double atk, boolean cri) {
		double dmg = 1;
		if (cri) {
			atk *= 1.5;
		}
		dmg = (def*0.06)/(1+0.06*def);
		return dmg;
	}
}
