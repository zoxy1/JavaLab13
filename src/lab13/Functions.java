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

	/**
	 * Function writes to file string
	 * 
	 * @param fileName
	 *            - path to file, for example "c:/text.txt"
	 * @param text
	 *            - this string will write to file
	 */
	public static void write(String fileName, String text) {
		// Определяем файл
		File file = new File(fileName);

		try {
			// если файла нет, то создаем его
			if (!file.exists()) {
				file.createNewFile();
			}

			// определяем переменную out типа PrintWriter, и создаем экземпляр
			// объекта
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {
				// с помощью метода print записываем строку text в файл
				out.print(text);
			} finally {
				// закрываем файл, если не закрыть, то данные не запишутся
				out.close();
			}
		} catch (IOException ewr) {

			System.out.println(ewr.getMessage());
		}
	}

	/**
	 * Function writes to file string
	 * 
	 * @param fileName
	 *            - path to file, for example "c:/text.txt"
	 * @param text
	 *            - this string will write to file
	 */
	public static void writeThrows(String fileName, String text) throws IOException {
		// Определяем файл
		File file = new File(fileName);

		// если файла нет, то создаем его
		if (!file.exists()) {
			file.createNewFile();
		}

		// определяем переменную out типа PrintWriter, и создаем экземпляр
		// объекта
		PrintWriter out = new PrintWriter(file.getAbsoluteFile());

		// с помощью метода print записываем строку text в файл
		out.print(text);

		// закрываем файл, если не закрыть, то данные не запишутся
		out.close();

	}

	/**
	 * Function reads file and writes rows to the Arraylist
	 * 
	 * @param fileName
	 *            - path to file, for example "c:/text.txt"
	 * @return - ArrayList<String> contains strings
	 */
	public static ArrayList<String> read(String fileName) {

		ArrayList<String> stringList = new ArrayList<>();
		// использование try-with-resources
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {

				stringList.add(line);
			}

			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return stringList;
	}

	public static void main(String[] args) throws IOException {

		// создаем объект класса Calculation и присваиваем ссылкуна него
		// переменной variableCalculation
		// в конструкторе передаем номер уравнения по которому будут выполняться
		// вычисления
		Calculation variableCalculation = new Calculation(1);

		ArrayList<Double> doubleList = new ArrayList<>();

		ArrayList<String> stringList = new ArrayList<>();
		// переменная stringList хранит список строк прочитанных из файла in.txt
		stringList = read("E:/2/in.txt");
		// в переменную sb записываем все полученные результаты
		StringBuilder sb = new StringBuilder();
		// пробегаем по все му списку stringList(каждый элемент списка содержит
		// одну строку)
		for (int i = 0; i < stringList.size(); i++) {

			// все числа в строке записываем отдельно в массив isParts
			String[] isParts = stringList.get(i).split(" ");
			// пробегаем по всему массиву isParts и преобразуем в Double и
			// добавляем в список doubleList
			for (int j = 0; j < isParts.length; j++) {
				doubleList.add(j, Double.parseDouble(isParts[j]));

			}
			// минимальное значение аргумента х которое находится в списке
			// doubleList по индексу 4
			Double x = doubleList.get(4);
			Double y = 0.0d; // переменная, значение вычисленной функции
			// выполняем пока аргумент х <= максимальному аргументу х
			while (x <= doubleList.get(5)) {
				// вычисляем уравнение
				y = variableCalculation.calculateFunction(doubleList.get(0), doubleList.get(1), doubleList.get(2), doubleList.get(3), x);
				// выводим значения уравнения для всег аргументов от
				// минимального до максимального значения с шагом
				// doubleList.get(6)
				// выводим с точностью 2 знака после запятой
				System.out.printf("%1$.2f", y);
				System.out.print(" ");
				// в переменную sb класса StringBuilder помещаем значение
				// уравнения через пробел
				sb.append(String.format("%.2f ", y) + " ");
				// прибавляем к начальному значению аргумента шаг
				// doubleList.get(6)
				x = x + doubleList.get(6);

			}
			// переводим на новую строку рассчет значений функции для других
			// коэффициентов
			System.out.print("\n");
			// в переменную sb класса StringBuilder символ окончания строки
			sb.append("\n");
		}
		// записываем в файл out.txt полученные результаты
		Functions.write("E:/2/out.txt", sb.toString());
		// записываем полученные результаты в файл out1.txt, используя метод
		// writeThrows,он сам не обрабатывает,он задает поведение так, 
		//чтобы вызывающий его код мог позаботиться об этом исключении.
		try {
			Functions.writeThrows("E:/2/out1.txt", sb.toString());
		} catch (IOException ewr) {
			System.out.println(ewr.getMessage());
		}

	}

}
