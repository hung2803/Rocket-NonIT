
public class Ford extends Car {

	/*
	 * Tạo 1 Class con của Class Car và có tên là Ford, bao gồm các thuộc tính
	 * và phương thức như sau:  int year;  int manufacturerDiscount;  double
	 * getSalePrice(); // Lấy giá sale từ Class Car, sau đó trừ đi
	 * manufacturerDiscount.
	 */

	int year;
	int manufacturerDiscount;

	public Ford(int speed, double regularPrice, String color, int manufacturerDiscount) {
		super(speed, regularPrice, color);
		this.manufacturerDiscount = manufacturerDiscount;
	}

	double getSalePrice() {
		double salePrice = super.regularPrice - manufacturerDiscount;

		return salePrice;
	}

}
