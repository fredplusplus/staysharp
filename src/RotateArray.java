import java.util.Arrays;

public class RotateArray {
	public Integer[] rotateArray(Integer[] array, int k) {
		k = k % array.length;
		if (k > 0) {
			rotateArray(array, 0, k);
			rotateArray(array, k + 1, array.length - 1);
			rotateArray(array, 0, array.length - 1);
		}
		return array;
	}

	private void rotateArray(Integer[] array, int start, int end) {
		while (start < end) {
			int temp = array[start];
			array[start++] = array[end];
			array[end--] = temp;
		}
	}
}
