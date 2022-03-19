package quicksort;

import java.util.Scanner;

public class TestSequential {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Lütfen datanýn boyutunu giriniz : ");
		int boyut = scanner.nextInt();
		SequentialQuickSort sequentialQuickSort = new SequentialQuickSort();
		long startTime = sequentialQuickSort.startTime();
		int dizi [] = sequentialQuickSort.randomData(boyut);
		sequentialQuickSort.partition(dizi, 0, (boyut-1));
		sequentialQuickSort.sort(dizi, 0, (boyut-1));
		System.out.println();
		System.out.println("Dizinin sýralanmýþ son 10 elamaný;");
		for (int i = (boyut-10); i < dizi.length; i++) {
			System.out.println(dizi[i]);
		}
		long endTime = sequentialQuickSort.endTime();
		System.out.println();
		sequentialQuickSort.speed(startTime, endTime);
	}

}
