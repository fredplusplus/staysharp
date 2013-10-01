public class QuickSort {
	public void sort(int[] num) {
		sort(num, 0, num.length - 1);
	}

	private void sort(int[] num, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int pivot = num[end];
			int index = start;
			for (int i = start; i < end; i++) {
				if (num[i] < pivot) {
					int temp = num[i];
					num[i] = num[index];
					num[index++] = temp;
				}
			}
			int temp = num[index];
			num[index] = num[end];
			num[end] = temp;
			sort(num, start, index - 1);
			sort(num, index + 1, end);
		}
	}
}
