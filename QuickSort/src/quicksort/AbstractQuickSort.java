package quicksort;

public abstract class AbstractQuickSort {

	abstract int[] randomData(int n);

	abstract int partition(int[] data, int start, int end);

	abstract void sort(int[] data, int start, int end);

	abstract void swap(int[] data, int i, int j);

	abstract void speed(long startTime,long endTime);

}
