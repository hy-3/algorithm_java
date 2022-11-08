public class QuickSort {
	static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static void quicksort(int arr[], int low, int high) {
		if (low < high) {
			int pos_pivot = partition(arr, low, high);

			quicksort(arr, low, pos_pivot - 1);
			quicksort(arr, pos_pivot + 1, high);
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
		QuickSort.quicksort(arr, 0, n - 1);
		QuickSort.printArray(arr);
	}
}