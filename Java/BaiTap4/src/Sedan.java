
public class Sedan extends Car {
	/*
	 * Tạo 1 Class con của Class Car và có tên là Sedan, bao gồm các thuộc tính
	 * và phương thức như sau:  int length;  double getSalePrice(); //Nếu
	 * length > 20 feet thì discount 5%, nếu không discount 10%
	 */

	int length;

	public Sedan(int speed, double regularPrice, String color, int length) {
		super(speed, regularPrice, color);
		this.length = length;
	}

	double getSalePrice() {

		double price;
		if (length > 20) {

			price = 0.95 * regularPrice;
		} else {
			price = 0.9 * regularPrice;

		}
		return price;
	}

}
