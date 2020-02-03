
public class Car {
	/*
	 * 1) Tạo 1 Class cha có tên là Car, bao gồm các thuộc tính và phương thức
	 * như sau:  int speed;  double regularPrice;  String color;  double
	 * getSalePrice();
	 */

	int speed;
	double regularPrice;
	String color;

	public Car(int speed, double regularPrice, String color) {
		this.speed = speed;
		this.regularPrice = regularPrice;
		this.color = color;
	}

	double getSalePrice() {
		return regularPrice;
	};
}
