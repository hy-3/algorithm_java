class HeapSort {

	static void sort(int arr[]) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n - 1; i > 0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapify(arr, i, 0);
		}
	}

	static void heapify(int arr[], int n, int i) {
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[max]) {
			max = left;
		}
		if (right < n && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			int tmp = arr[i];
			arr[i] = arr[max];
			arr[max] = tmp;
			heapify(arr, n, max);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String args[]) {
		int[] arr = {10, 7, 8, 9, 1, 5};
		int n = arr.length;
		HeapSort.sort(arr);
		HeapSort.printArray(arr);
	}
}