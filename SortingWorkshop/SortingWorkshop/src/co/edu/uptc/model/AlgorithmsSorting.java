package co.edu.uptc.model;

public class AlgorithmsSorting {
	private Array array;

	public AlgorithmsSorting() {
		array = new Array();
		array.fillArray();
	}

	public int[] selectionMethod() {
		int[] sortedArray = array.returnArray();
		int constant = 0;
		for (int i = 0; i < sortedArray.length; i++) {
			for (int j = i + 1; j < sortedArray.length; j++) {
				if (sortedArray[i] > sortedArray[j]) {
					constant = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = constant;
				}
			}

		}
		return sortedArray;
	}

	public long measureSelectionMethodTime() {
		long startTime = System.currentTimeMillis();
		selectionMethod();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public int[] exchangeMethod() {
		int[] sortedArray = array.returnArray();
		for (int i = 0; i < sortedArray.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < sortedArray.length; j++) {
				if (sortedArray[j] < sortedArray[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				int temp = sortedArray[i];
				sortedArray[i] = sortedArray[minIndex];
				sortedArray[minIndex] = temp;
			}
		}
		return sortedArray;
	}

	public long measureExchangeMethodTime() {
		long startTime = System.currentTimeMillis();
		exchangeMethod();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public int[] burbbleMethod() {
		int[] sortedArray = array.returnArray();
		for (int j = 0; j < sortedArray.length; j++) {
			int[] newArray = new int[sortedArray.length];
			for (int i = 0; i < sortedArray.length - 1; i++) {
				if (sortedArray[i] > sortedArray[(i + 1)]) {
					newArray[i] = sortedArray[(i + 1)];
					sortedArray[(i + 1)] = sortedArray[i];
					newArray[(i + 1)] = sortedArray[i];
				} else {
					newArray[i] = sortedArray[i];
					newArray[(i + 1)] = sortedArray[(i + 1)];
				}
			}
			sortedArray = newArray;
		}
		return sortedArray;
	}

	public long measureBurbbleMethodTime() {
		long startTime = System.currentTimeMillis();
		burbbleMethod();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public int[] mergeSortMethod() {
		int[] sortedArray = array.returnArray();
		mergesort(sortedArray, 0, sortedArray.length - 1);
		return sortedArray;
	}

	public void mergesort(int receivedArray[], int left, int right) {
		if (left < right) {
			int midle = (left + right) / 2;
			mergesort(receivedArray, left, midle);
			mergesort(receivedArray, midle + 1, right);
			merge(receivedArray, left, midle, right);
		}
	}

	public void merge(int receivedArray[], int left, int midle, int right) {
		int counter1, counter2, counter3;
		int[] newArray = new int[receivedArray.length];
		for (counter1 = left; counter1 <= right; counter1++)
			newArray[counter1] = receivedArray[counter1];

		counter1 = left;
		counter2 = midle + 1;
		counter3 = left;

		while (counter1 <= midle && counter2 <= right)
			if (newArray[counter1] <= newArray[counter2])
				receivedArray[counter3++] = newArray[counter1++];
			else
				receivedArray[counter3++] = newArray[counter2++];

		while (counter1 <= midle)
			receivedArray[counter3++] = newArray[counter1++];
	}
	
	public long measureMergeSortMethodTime() {
		long startTime = System.currentTimeMillis();
		mergeSortMethod();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
