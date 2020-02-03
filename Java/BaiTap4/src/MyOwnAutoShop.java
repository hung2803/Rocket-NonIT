
public class MyOwnAutoShop {

	public static void main(String[] args) {
		/*
		 * Tạo class MyOwnAutoShop có chứa phương thức main(), làm những điều
		 * sau: a) Tạo 1 instance của class Sedan và khởi tạo tất cả các thuộc
		 * tính với giá trị thích hợp. Sử dụng phương thức super(...) trong hàm
		 * khởi tạo để khởi tạo các thuộc tính của class cha. b) Tạo 2 instance
		 * của class Ford và khởi tạo tất cả các thuộc tính với giá trị thích
		 * hợp. Sử dụng phương thức super(...) trong hàm khởi tạo để khởi tạo
		 * các thuộc tính của class cha. c) Tạo 1 instance của class Car và khởi
		 * tạo tất cả các thuộc tính với giá trị thích hợp. d) Hiển thị giá sale
		 * của tất cả các instance.
		 */

		Sedan xe = new Sedan(150, 5000, "red", 3);
		Ford f1 = new Ford(100, 6000, "green", 4000);
		Ford f2 = new Ford(150, 7000, "blue", 6000);
		Car car = new Car(120, 8000, "red");

		System.out.println(xe.getSalePrice());
		System.out.println(f1.getSalePrice());
		System.out.println(f2.getSalePrice());
		System.out.println(car.regularPrice);

	}

}
