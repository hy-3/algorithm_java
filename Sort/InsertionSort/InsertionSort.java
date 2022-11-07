public class InsertionSort {

	void insertionsort(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int j = i + 1;
				while (j > 0 && arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
					j--;
				}
			}
		}
	}

	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		InsertionSort is = new InsertionSort();
		is.insertionsort(arr);
		is.printArray(arr);
	}
}