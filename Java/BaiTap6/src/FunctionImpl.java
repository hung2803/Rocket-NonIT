import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class FunctionImpl implements IFunction {

	@Override
	public void search(List<CanBo> canBos, String fullName, String department) {

		for (int i = 0; i < canBos.size(); i++) {

			if ((department.equals("null") || department.isEmpty()) && canBos.get(i).fullName.equals(fullName)) {
				System.out.println("Tim kiem duoc can bo la: ");
				canBos.get(i).print();

			} else if (canBos.get(i).fullName.equals(fullName) && canBos.get(i).getDepartment().equals(department)) {
				System.out.println("Tim kiem duoc can bo la: ");
				canBos.get(i).print();

			} else if ((fullName.equals("null") || fullName.isEmpty())
					&& canBos.get(i).getDepartment().equals(department)) {
				System.out.println("Tim kiem duoc can bo la: ");
				canBos.get(i).print();

			}
		}
	}

	@Override
	public void sort(List<GiaoSu> giaoSus) {
		// sort
		Collections.sort(giaoSus);

		System.out.println("Day sau khi da sap xep la: ");
		// print
		for (int i = 0; i < giaoSus.size(); i++) {
			giaoSus.get(i).print();
		}
	}

}
