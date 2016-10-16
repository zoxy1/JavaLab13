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
		// StringBuilder sb = new StringBuilder();
		ArrayList<String> stringList = new ArrayList<>();
		String[] lines = new String[10];
		int numberLines = 0;
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"D:/_JAVA_Tusur/Workspace/JavaLab13.git/src/lab13/in.txt"),
						StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				// lines[numberLines]=line;
				// System.out.println(lines[numberLines]);
				numberLines++;
				stringList.add(line);

			}
			// System.out.println(numberLines);
			reader.close();
		} catch (IOException e) {
			System.out.println("Ошибка ввода вывода");
		}
		int index = 0;
		//String[][] stringMy= new String[7][numberLines];
		Double[] doubleMy= new Double[7];
		Calculation variableCalculation=new Calculation(1);
		for (int i=0;i<numberLines;i++) {
			// System.out.println(string);
			String[] isbnParts = stringList.get(i).split(" ");
			//doubleMy[j]=Double.parseDouble(isbnParts[j]);
			
			for (int j=0;j<7;j++) {
			doubleMy[j]=Double.parseDouble(isbnParts[j]);
				
			//System.out.print(doubleMy[j]+" ");
			}	
			System.out.println(variableCalculation.calculateFunction(doubleMy[0], doubleMy[1], doubleMy[2], doubleMy[3], 10));
		System.out.println("\n");	
			
			
		}
		

		
		// index++;
		

		/*
		 * Path path =
		 * Paths.get("D:/_JAVA_Tusur/Workspace/JavaLab13.git/src/lab13/in.txt");
		 * Scanner scanner = new Scanner(path); //читаем построчно
		 * 
		 * while(scanner.hasNextLine()){ String line = scanner.nextLine();
		 * System.out.println(line);
		 * 
		 * }
		 */
		// scanner.

		
		// String line="85 45 96";
		/*
		 * String[] strNumbers = line.split(" "); Integer[] numbers = new
		 * Integer[strNumbers.length]; for (int i = 0; i < numbers.length; i++)
		 * { numbers[i] = Integer.valueOf(strNumbers[i]); }
		 * System.out.println(Arrays.toString(numbers));
		 */
	}

}
