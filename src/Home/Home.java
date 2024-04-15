package Home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Home extends JFrame {

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3; // 새로 추가된 입력 상자
	private JTextField textField4; // 새로 추가된 입력 상자
	private JLabel resultLabel;
	private JLabel resultLabel2;

	public Home() {
		int col = 600;
		int row = 300;
		setTitle("계산기"); // 프레임 제목 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(col, row); // 프레임 크기 설정
		setLayout(null); // 레이아웃 매니저 설정

		// 첫 번째 숫자 입력 텍스트 상자와 라벨
		JLabel label1 = new JLabel("몬스터 hp");
		label1.setBounds(20, 15, 100, 25);
		add(label1);
		textField1 = new JTextField();
		textField1.setBounds(20, 40, 100, 25);
		add(textField1);

		// 두 번째 숫자 입력 텍스트 상자와 라벨
		JLabel label2 = new JLabel("몬스터 방어력");
		label2.setBounds(20, 70, 100, 25);
		add(label2);
		textField2 = new JTextField();
		textField2.setBounds(20, 95, 100, 25);
		add(textField2);

		// 세 번째 숫자 입력 텍스트 상자와 라벨
		JLabel label3 = new JLabel("유저 공격력");
		label3.setBounds(250, 15, 100, 25);
		add(label3);
		textField3 = new JTextField();
		textField3.setBounds(250, 40, 100, 25);
		add(textField3);

		// 네 번째 숫자 입력 텍스트 상자와 라벨
		JLabel label4 = new JLabel("유저 치명타율");
		label4.setBounds(250, 70, 100, 25);
		add(label4);

		textField4 = new JTextField();
		textField4.setBounds(250, 95, 100, 25);
		add(textField4);

		resultLabel = new JLabel("피해량:  ");
		resultLabel.setBounds(400, 120, 220, 50); // 크기 조정
		add(resultLabel);

		resultLabel2 = new JLabel("잔여 HP: ");
		resultLabel2.setBounds(400, 150, 220, 50); // 크기 조정
		add(resultLabel2);
		
		// 결과 표시 라벨
	
		// 곱셈 버튼
		JButton multiplyButton = new JButton("계산");
		multiplyButton.setBounds(450, 200, 100, 25);
		add(multiplyButton);

		// 버튼에 리스너 추가
		multiplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateMultiplication();
			}
		});

		setVisible(true); // 화면에 프레임 출력
	}

	private void calculateMultiplication() {
		try {
			double num1 = 100, num2 = 1, num3 = 1, num4 = 1;

			// 첫 번째 숫자 입력 상자
			if (!textField1.getText().isEmpty()) {
				num1 = Double.parseDouble(textField1.getText());
			}

			// 두 번째 숫자 입력 상자
			if (!textField2.getText().isEmpty()) {
				num2 = Double.parseDouble(textField2.getText());
			}

			// 세 번째 숫자 입력 상자
			if (!textField3.getText().isEmpty()) {
				num3 = Double.parseDouble(textField3.getText());
			}

			// 네 번째 숫자 입력 상자
			if (!textField4.getText().isEmpty()) {
				num4 = Double.parseDouble(textField4.getText());
			}

			// 네 숫자 곱셈하여 결과 라벨에 표시
			boolean critical = Critical(num4);
			String crilog = "";

			double res = Dmg(num1, num2, num3, critical);
			if(critical) {
				crilog = "  **치명타** ";
				num1 *= 1.5;
			}
			double result = (1-res)*num3;
			System.out.println(res);
			double result2 = num1 - Math.abs(result);
			resultLabel.setText("피해량:  "+ crilog + String.format("%.2f", result) + " !!"); // 소수점 둘째 자리까지 표시
			resultLabel2.setText("잔여 HP:  " + String.format("%.2f", result2)); // 소수점 둘째 자리까지 표시
			textField1.setText(String.valueOf(result2));
		} catch (NumberFormatException ex) {
			// 숫자가 아닌 값이 입력된 경우 처리
			resultLabel.setText("숫자를 입력하세요!");
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

	public static void main(String[] args) {
		Home h = new Home();
	}
}
