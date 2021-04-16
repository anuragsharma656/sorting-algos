

public class SortingAlgos
{
	public static void main(String[] args)
	{


	}

	/**
	 * Bubble Sort.
	 * Time Complexity  : O(n^2)
	 * Space Complexity : O(1)
	 * <p>
	 * Note : Time complexity is always O(n^2) if we do not use sorted check in the iterations.
	 */
	public static void bubbleSort(int[] a)
	{
		boolean sorted = false;
		while (!sorted)
		{
			sorted = true;
			for (int i = 0; i < a.length - 1; i++)
			{
				if (a[i] > a[i + 1])
				{
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					sorted = false;
				}
			}
		}
	}

	/**
	 * Insertion Sort.
	 * Time Complexity : O(n^2)
	 * Space Complexity : O(1)
	 */

	public static void insertionSort(int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int current = array[i];
			int j = i - 1;
			while (j >= 0 && current < array[j])
			{
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = current;
		}
	}

	/**
	 * Selection Sort.
	 * Time Complexity : O(n^2)
	 * Space Complexity : O(1)
	 */
	public static void selectionSort(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int min = array[i];
			int minId = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[j] < min)
				{
					min = array[j];
					minId = j;
				}
			}
			// swapping
			int temp = array[i];
			array[i] = min;
			array[minId] = temp;
		}
	}

	/**
	 * Merge Sort.
	 * Time Compexity : O(nlog n)
	 * Space Complexity : O(n)
	 */
	public static void mergeSort(int[] array, int left, int right)
	{
		if (right <= left)
			return;
		int mid = (left + right) / 2;
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, mid, right);
	}

	void merge(int[] array, int left, int mid, int right)
	{
		int lengthLeft = mid - left + 1;
		int lengthRight = right - mid;

		int leftArray[] = new int[lengthLeft];
		int rightArray[] = new int[lengthRight];

		for (int i = 0; i < lengthLeft; i++)
			leftArray[i] = array[left + i];
		for (int i = 0; i < lengthRight; i++)
			rightArray[i] = array[mid + i + 1];

		int leftIndex = 0;
		int rightIndex = 0;

		for (int i = left; i < right + 1; i++)
		{
			if (leftIndex < lengthLeft && rightIndex < lengthRight)
			{
				if (leftArray[leftIndex] < rightArray[rightIndex])
				{
					array[i] = leftArray[leftIndex];
					leftIndex++;
				}
				else
				{
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			}
			else if (leftIndex < lengthLeft)
			{
				array[i] = leftArray[leftIndex];
				leftIndex++;
			}
			else if (rightIndex < lengthRight)
			{
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}

	/**
	 * Quick Sort.
	 * Time Compexity : O(nlog n)
	 */
	public static void quickSort(int[] array, int begin, int end)
	{
		if (end <= begin)
			return;
		int pivot = partition(array, begin, end);
		quickSort(array, begin, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	static int partition(int[] array, int begin, int end)
	{
		int pivot = end;

		int counter = begin;
		for (int i = begin; i < end; i++)
		{
			if (array[i] < array[pivot])
			{
				int temp = array[counter];
				array[counter] = array[i];
				array[i] = temp;
				counter++;
			}
		}
		int temp = array[pivot];
		array[pivot] = array[counter];
		array[counter] = temp;

		return counter;
	}
}
