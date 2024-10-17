package com.tharindi.question3;

import com.tharindi.question3.model.LotteryResultTharindi;
import com.tharindi.question3.service.LotteryResultTharindiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class Question3Application implements CommandLineRunner {

	private final LotteryResultTharindiService lotteryResultTharindiService;

	@Autowired
	public Question3Application(LotteryResultTharindiService lotteryResultTharindiService) {
		this.lotteryResultTharindiService = lotteryResultTharindiService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Question3Application.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			String lotteryURL = "https://results.govdoc.lk/results/lagna-wasana-4310";
			String[] urlParts = lotteryURL.split("-");
			Long winningSession = Long.parseLong(urlParts[urlParts.length - 1]);

			URL url = new URL(lotteryURL);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				if (inputLine.contains("Today's winning numbers are")) {
					int startIndex = inputLine.indexOf("Today's winning numbers are") + "Today's winning numbers are".length();
					String result = inputLine.substring(startIndex).trim();

					result = result.replaceFirst("^:\\s*", "");

					String[] parts = result.split(", ");
					String zodiacSign = parts[0].substring(parts[0].indexOf("Zodiac Sign") + "Zodiac Sign".length()).trim(); // Extract zodiac sign

					LotteryResultTharindi lotteryResult = new LotteryResultTharindi();
					lotteryResult.setWinningSession(winningSession);
					lotteryResult.setZodiacSign(zodiacSign);

					for (int i = 1; i < parts.length; i++) {
						String number = parts[i].substring(parts[i].indexOf("Number") + "Number".length()).trim(); // Extract the number
						number = stripHtmlTags(number);
						switch (i) {
							case 1:
								lotteryResult.setNumber1(number);
								break;
							case 2:
								lotteryResult.setNumber2(number);
								break;
							case 3:
								lotteryResult.setNumber3(number);
								break;
							case 4:
								lotteryResult.setNumber4(number);
								break;
							default:
								break;
						}
					}

					lotteryResultTharindiService.saveLotteryResult(lotteryResult);
					System.out.println("Lottery results saved to the database.");
					break;
				}
			}

			reader.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private String stripHtmlTags(String input) {
		return input.replaceAll("<[^>]*>", "").trim();
	}
}
