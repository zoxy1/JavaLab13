package lab13;

/**
 * This class describes the calculation of several functions. The function can
 * be selected when creating a class object, putting into the constructor
 * function number. You see formula in lab #13.
 * 
 * @author Andrey Kudryavtsev
 * 
 */
public class Calculation {
	private double a;
	private double b;
	private double c;
	private double d;
	private double x;
	private int numberEquation = 1;

	/**
	 * The function can be selected when creating a class object, putting into
	 * the constructor function number. You see formula in lab #13.
	 * 
	 * @param numberEquation
	 *            - function number
	 * 
	 */

	public Calculation(int numberEquation) {
		this.setNumberEquation(numberEquation);
	}

	private double lg(double a, double b) {
		return Math.log(b) / Math.log(b);
	}

	private double ln(double a) {
		return Math.log10(a) / Math.log10(Math.E);
	}

	private double ctg(double a) {
		return 1.0 / Math.tan(a);
	}

	/**
	 * This method calculates the value of a function depending on the
	 * coefficients a, b, c, d
	 * 
	 * @param a
	 *            - function coefficient;
	 * @param b
	 *            - function coefficient;
	 * @param c
	 *            - function coefficient;
	 * @param d
	 *            - function coefficient;
	 * @param x
	 *            - function parameter;
	 * @return Return value have type double
	 */
	public double calculateFunction(double a, double b, double c, double d,
			double x) {
		this.setA(a);
		this.setB(b);
		this.setC(c);
		this.setD(d);
		this.setX(x);
		switch (this.numberEquation) {
		case 1:
			return this.a * Math.pow(this.x, 2) + this.b * this.x + this.c
					* Math.pow(this.x, -2) + this.d;

		case 2:
			return (double) Math.acos(this.a * Math.pow(this.x, 2)
					+ Math.sqrt(this.b * Math.pow(this.x, 3)));
		case 3:
			return this.a * Math.pow(this.x, 4)
					- Math.pow(Math.sin(this.c * this.x), -0.5)
					+ Math.pow(Math.cos(this.d * this.x), 2.1) + b;
		case 4:
			return (Math.pow(
					(Math.cos(this.a * Math.pow(x, 2) + this.b * this.x)), 3) + this.c)
					/ this.d + +lg(6, this.d);
		case 5:
			return this.a * Math.sin(Math.pow(this.x, 2)) + this.b * this.x
					+ this.c * Math.cos(Math.pow(this.x, -2)) + ln(this.d);
		case 6:
			return ctg(this.a * Math.pow(this.x, 2)
					+ ln(this.b * Math.pow(this.x, 3)) + this.c * this.x - 1.0
					/ this.d);

		default:

			return 0;

		}

	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public int getNumberEquation() {
		return numberEquation;
	}

	public void setNumberEquation(int numberEquation) {
		if (numberEquation >= 1 && numberEquation <= 20) {
			this.numberEquation = numberEquation;
		} else {
			System.out
					.println("Ќомер уравнени€ должен быть от 1 до 20, по умолчанию выводитс€ значени€ уравнени€ є1");
		}
	}

}
