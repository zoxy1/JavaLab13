package lab13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Functions {

	public Functions() {

	}

	public static void write(String fileName, String text) {
		// Определяем файл
		File file = new File(fileName);

		try {
			// проверяем, что если файл не существует то создаем его
			if (!file.exists()) {
				file.createNewFile();
			}

			// PrintWriter обеспечит возможности записи в файл
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {
				// Записываем текст у файл
				out.print(text);
			} finally {
				// После чего мы должны закрыть файл
				// Иначе файл не запишется
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> stringList = new ArrayList<>();
		String file = "E:/2/in.txt";
		int numberLines = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);

				numberLines++; //
				stringList.add(line);

			}
			// System.out.println(numberLines);
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Calculation variableCalculation = new Calculation(1);
		ArrayList<Double> doubleList = new ArrayList<>();
		for (int i = 0; i < numberLines; i++) {

			String[] isParts = stringList.get(i).split(" ");

			for (int j = 0; j < isParts.length; j++) {
				doubleList.add(j, Double.parseDouble(isParts[j]));

			}
			Double x = doubleList.get(4);
			Double y = 0.0d;

			while (x <= doubleList.get(5)) {

				y = variableCalculation.calculateFunction(doubleList.get(0), doubleList.get(1), doubleList.get(2), doubleList.get(3), x);
				System.out.printf("%1$.2f", y);
				System.out.print(" ");
				y.toString();
				sb.append(String.format("%.2f ", y) + " ");
				x = x + doubleList.get(6);

			}
			System.out.print("\n");
			sb.append("\n");
		}

		Functions.write("E:/2/out.txt", sb.toString());
	}

}
