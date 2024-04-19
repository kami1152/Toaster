package Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Home.DATA.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Home {

	static User user;

	public static void main(String[] args) {
		// 크롤링할 웹 페이지의 URL
		String url = "https://12ayo22.notion.site/5e21c29209d64b4fbd7c19d9c5c85d73";

		// 크롬 드라이버 경로 설정
		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		// Headless 모드로 WebDriver 초기화
		WebDriver driver = new ChromeDriver(options);
		// 웹 페이지로 이동
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		user = new User();

		// 이미지 요소들 찾기
		List<WebElement> imageElements = driver.findElements(By.cssSelector(
				"#notion-app > div > div:nth-child(1) > div > div:nth-child(2) > main > div > div > div.whenContentEditable > div > div:nth-child(3) > div > div:nth-child(10) > div:nth-child(3) > div > div > div > div img"));
		//System.out.println(imageElements.size());
		// 이미지 정보 출력
		for (WebElement element : imageElements) {
			// 이미지의 src 속성 가져오기
			String imageUrl = element.getAttribute("src");
			// 이미지의 다른 속성들 가져오기 가능 (예: width, height 등)
			String imageAlt = element.getAttribute("alt");
			// 이미지 정보 출력
			user.userset.add(imageUrl);
			String str = imageUrl;
			if (user.usermap.get(str) == null) {
				user.usermap.put(str, 1);
			} else {
				user.usermap.put(str, user.usermap.get(str) + 1);
			}
			// System.out.println("Image URL: " + imageUrl);
			// System.out.println("Image Alt: " + imageAlt);
		}

		List<WebElement> divElements = driver.findElements(By.xpath("//div[contains(text(),'M')]"));
		String M = "M";
		user.userset.add(M);
		user.usermap.put(M, divElements.size());

		user.setMap();
		System.out.println("프로그래머스 문제 푼 수");
		for (String str : user.userset) {
			
			System.out.println(  user.list.get(str)+": " + user.usermap.get(str));
		}


		// WebDriver 종료
		driver.quit();
	}
}
