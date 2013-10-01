public class QuickSort {
	public void sort(int[] num) {
		sort(num, 0, num.length - 1);
	}

	private void sort(int[] num, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int pivot = partition(num, start, end);
			sort(num, start, pivot - 1);
			sort(num, pivot + 1, end);
		}
	}

	private int partition(int[] num, int start, int end) {
		if (start >= end) {
			return start;
		} else {
			int pivot = num[end];
			int index = start;
			for (int i = start; i < end; i++) {
				if (num[i] < pivot) {
					int temp = num[index];
					num[index++] = num[i];
					num[i] = temp;
				}
			}
			int temp = num[index];
			num[index] = num[end];
			num[end] = temp;
			return index;
		}
	}
}
