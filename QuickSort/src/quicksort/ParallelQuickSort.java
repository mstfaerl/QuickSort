package quicksort;
import java.util.Random;

public class ParallelQuickSort extends AbstractQuickSort implements Runnable {

	int[] data;
	int start, end;

	ParallelQuickSort() {
	}

	ParallelQuickSort(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	//Bize n de�eri kadar ve n de�erini max alacak �ekilde random datal� bir dizi olu�turur.
	@Override
	int[] randomData(int n) {
		Random random = new Random();
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++)
			data[i] = random.nextInt(n);
		return data;
	}

	//s�ralama i�lemi ger�ekle�tirdikten sonra swap i�lemleriyle beraber tekrar birle�tirme i�lemini sa�lar
	@Override
	int partition(int[] data, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end)
			return start;
		int pivot = data[end];
		int s = start - 1;
		for (int i = start; i < end; i++)
			if (data[i] <= pivot)
				swap(data, ++s, i);
		swap(data, ++s, end);
		return s;
	}
	
	//s�ralama i�lemini recursive �ekilde 
	@Override
	void sort(int[] data, int start, int end) {
		// TODO Auto-generated method stub
		if (end<=start)
            return;
        int s=partition(data,start,end);
        sort(data,start,s-1);
        sort(data,s+1,end);
	}
	
	//s�ralamaya uyabilmesi i�in yerlerinde de�i�iklik g�r�lebilecek de�erlerin yerlerini de�i�tirir
	@Override
	void swap(int[] data, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	//quick sortun ba�lang�� zaman�
	long startTime() {
		long startTime = System.currentTimeMillis();
		return startTime;
	}
	
	//quick sortun biti� zaman�
	long endTime() {
		long endTime = System.currentTimeMillis();
		return endTime;
	}
	
	//biti� ve ba�lang�� aras�nda kalan zaman
	@Override
	void speed(long startTime,long endTime) {
		// TODO Auto-generated method stub
		long time = endTime - startTime;
		System.out.println("Parallel Quick Sort Time : " + time);	
	}

	//threadlerin �al��mas�n� sa�lar, threadler i�in bir nevi ana program
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sort(this.data, this.start, this.end);
	}

}
