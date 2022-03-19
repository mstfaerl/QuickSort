package quicksort;

import java.util.Random;

public class SequentialQuickSort extends AbstractQuickSort {

	@Override
	int[] randomData(int n) {
		Random random = new Random();
        int[] data = new int[n];
        for(int i=0;i<data.length;i++)
            data[i]=random.nextInt(n-1) + 1;
        return data;
	}

	@Override
	int partition(int[] data, int start, int end) {
		if(start==end)
            return start;
        int pivot=data[end];
        int s=start-1;
        for(int i=start;i<end;i++)
            if(data[i]<=pivot)
                swap(data,++s,i);
        swap(data,++s,end);
        return s;
	}

	@Override
	void sort(int[] data, int start, int end) {
		// TODO Auto-generated method stub
		if (end<=start)
            return;
        int s=partition(data,start,end);
        sort(data,start,s-1);
        sort(data,s+1,end);
	}

	@Override
	void swap(int[] data, int i, int j) {
		// TODO Auto-generated method stub
		int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
	}
	
	long startTime() {
		long startTime = System.currentTimeMillis();
		return startTime;
	}
	
	long endTime() {
		long endTime = System.currentTimeMillis();
		return endTime;
	}

	@Override
	void speed(long startTime,long endTime) {
		// TODO Auto-generated method stub
		long time = endTime - startTime;
		System.out.println("Sequential Quick Sort Time : " + time);
	}

}
