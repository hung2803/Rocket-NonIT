
public class Truck extends Car {
	/*
	 * Tạo 1 Class con của Class Car và có tên là Truck, bao gồm các thuộc tính
	 * và phương thức như sau:  int weight;  double getSalePrice(); // nếu
	 * weight > 2000 thì discount 10%. Nếu không thì discount 20%.
	 */

	int weight;

	public Truck(int speed, double regularPrice, String color, int weight) {
		super(speed, regularPrice, color);
		this.weight = weight;
	}

	double getSalePrice() {
		double realPrice;
		if (weight > 2000) {
			realPrice = 0.9 * regularPrice;
		} else {
			realPrice = 0.8 * regularPrice;
		}

		return realPrice;
	}

}
