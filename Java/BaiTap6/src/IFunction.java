import java.util.List;

public interface IFunction {
	void search(List<CanBo> canBos, String fullName, String department);

	void sort(List<GiaoSu> giaoSus);
}
