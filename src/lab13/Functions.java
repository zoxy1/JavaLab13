package lab13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Functions {

	public Functions() {

	}

	public static void main(String[] args) throws IOException {

		ArrayList<String> stringList = new ArrayList<>();
		int numberLines = 0;
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"D:/_JAVA_Tusur/Workspace/JavaLab13.git/src/lab13/in.txt"),
						StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);

				numberLines++;
				stringList.add(line);

			}
			// System.out.println(numberLines);
			reader.close();
		} catch (IOException e) {
			System.out.println("Ошибка ввода вывода");
		}
		ArrayList<Double> doubleList = new ArrayList<>();
		Calculation variableCalculation = new Calculation(1);
		for (int i = 0; i < numberLines; i++) {

			String[] isParts = stringList.get(i).split(" ");

			for (int j = 0; j < isParts.length; j++) {
				doubleList.add(j, Double.parseDouble(isParts[j]));

			}

			System.out.println(variableCalculation.calculateFunction(
					doubleList.get(0), doubleList.get(1), doubleList.get(2),
					doubleList.get(3), 10));
			System.out.println("\n");

		}

	}

}
