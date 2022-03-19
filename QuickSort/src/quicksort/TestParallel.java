package quicksort;
import java.util.Scanner;
public class TestParallel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Lütfen datanýn boyutunu giriniz : ");
		int boyut = scanner.nextInt(); 
		ParallelQuickSort parallelQuickSort = new ParallelQuickSort();
		long startTime = parallelQuickSort.startTime();
		int dizi[] = parallelQuickSort.randomData(boyut);
		int start = 0, end = boyut-1;
		parallelQuickSort = new ParallelQuickSort(dizi,start,end);
		int s = parallelQuickSort.partition(dizi,start,end);
		Thread t1=new Thread(new ParallelQuickSort(dizi,0,s-1));
        Thread t2=new Thread(new ParallelQuickSort(dizi,s+1,dizi.length-1));
        t1.start();
        t2.start();
        try {
        	t1.join();
        	t2.join();
        }catch(InterruptedException e){
            System.out.println(e);
        }   
        System.out.println();
		System.out.println("Dizinin sýralanmýþ son 10 elamaný;");
        for (int i = (boyut-10) ; i < dizi.length; i++) {
			System.out.println(dizi[i]);
		} 
        long endTime = parallelQuickSort.endTime();
        System.out.println();
        parallelQuickSort.speed(startTime, endTime);	
	}

}
