import java.util.Random;

class Algorithms{
	
	//Insertion algorithm
	public static void InsertionSort(int[] A, int n){
		for(int j=1; j<n;j++) {
			int key = A[j];  
            int i = j-1;  
            while ( (i > -1) && ( A [i] > key ) ) {  
                A [i+1] = A [i];  
                i--;  }
            A[i+1]=key;
		}
	}
	
	//Merge algorithm****
	public static void MergeSort(int[] A, int left, int right) {
		if(left<right) {
			int mid =(left+right)/2;
			MergeSort(A,left,mid);
			MergeSort(A,mid+1,right);
			Merge(A,left,mid,right);
		}
	}
	public static void Merge(int[] A, int p, int q, int r) {
		int[] L = new int[q-p+2];
		int[] R = new int[r-q+1];
		for(int i = 0; i<L.length-1;++i) {
			L[i]= A[p+i];
    	}
		for(int i = 0; i<R.length-1;++i) {
			R[i]= A[q+1+i];
    	}
		double inf = Double.POSITIVE_INFINITY;
		L[L.length-1]=(int)inf;
		R[R.length-1]=(int)inf;
		int i = 0;
		int j = 0;
		for(int k = p; k <=r;k++) {
			if(L[i]<=R[j]) {
				A[k]=L[i];
				i++;
			}
			else {
				A[k]=R[j];
				j++;
			}
		}
	}
	
	
	
	//Heap algorithm
	public static void HeapSort(int[] A) {
		BuildHeap(A);
		for(int i = A.length-1;i>=0; i--) {
			int temp = A[0];
			A[0]=A[i];
			A[i]=temp;
	        Heapify(A,0,i);
		}
	}
	public static void Heapify(int[] A, int i, int p) {
		int l = Left(i)+1, r = Right(i)+1, largest;
		if(l < p && A[l]>A[i]) {
			largest = l;}
		else {
			largest = i;}
		if (r < p && A[r] > A[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = A[largest];
			A[largest]=A[i];
			A[i]=temp;
			Heapify(A, largest, p);}
	}
	public static void BuildHeap(int[] A) {
		for(int i = (A.length/2)-1;i>=0;i--) {
			Heapify(A,i,A.length);
		}
	}
	public static int Left(int i) {
		return 2*i;
	}
	public static int Right(int i) {
		return 2*i+1;
	}
	
	
	//Quick algorithm
	public static void QuickSort(int[] A, int p, int r) {
		if(p<r) {
			int q = Partition(A, p, r);
			QuickSort(A, p, q-1);
			QuickSort(A, q+1, r);
		}
	}
	public static int Partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p-1;
		for(int j = p; j<r;j++) {
			if(A[j]<=x) {
				i++;
				int temp = A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
		int temp = A[i+1];
		A[i+1]=A[r];
		A[r]=temp;
		return i+1;
	}
	
	
	//Quick Random algorithm
	public static void RandomQuickSort(int[] A, int p, int r) {
		if(p<r) {
			int q = RandomPartition(A, p, r);
			RandomQuickSort(A, p, q-1);
			RandomQuickSort(A, q+1, r);
		}
	}
	public static int RandomPartition(int[] A, int p, int r) {
		int i = new Random().nextInt(r-p)+p;
		int temp = A[i];
		A[i]=A[r];
		A[r]=temp;
		return Partition(A,p,r);
	}
	
	
	//Radix Sort
	public static void CountingSort(int[] A, int[] B, int k,int l) {
		int[] C = new int[k+1];
		for(int i = 0;i <k; i++) {
			C[i]=0;
		}
		for(int i = 0;i <A.length; i++) {
			C[(int) ((int)(A[i]%(Math.pow(10, l+1)))/Math.pow(10, l))]++;
		}
		for(int i = 1;i <C.length; i++) {
			C[i]+=C[i-1];
		}
		for(int i = A.length-1;i>=0; i--) {
			B[C[(int) ((int)(A[i]%Math.pow(10, l+1))/Math.pow(10, l))]-1]=A[i];
			C[(int) ((int)(A[i]%Math.pow(10, l+1))/Math.pow(10, l))]--;
		}
		for(int i=0;i<A.length;i++) {
			A[i]=B[i];
		}
	}
	public static int[] RadixSort(int[] A, int d) {
		int[] B= new int[A.length];
		for(int i=0; i < d; i++) {
		    int k=0;
		    for(int j = 0; j < A.length; j++) {
		    	k=(int) Math.max(k, (A[j]%Math.pow(10, i+1))/Math.pow(10, i));
		    }
	    	CountingSort(A,B,k,i);
		}
		return B;
	}
	
    public static void main(String args[]){	
    	int n = 10;
    	System.out.println("N: " + n);
    	int[] A = new int[n];
    	for(int i = 0; i<n;i++) {
    		A[i]= new Random().nextInt(1000);
    	}
    	int[] B = new int[n];
    	int[] C = new int[n];
    	int[] D = new int[n];
    	int[] E = new int[n];
    	int[] F = new int[n];
    	int[] G = new int[n];
    	for(int l = 0; l < n; l++) {B[l]=A[l]; C[l]=A[l]; D[l]=A[l]; E[l]=A[l]; F[l]=A[l]; G[l]=A[l];}
    	//Insertion sort
        long InsertionStart = System.nanoTime(); 
        
        InsertionSort(A,n);
        
        long InsertionEnd = System.nanoTime();
        long InsertionTotal = InsertionEnd - InsertionStart;
        double InsertionSeconds = (double)InsertionTotal / 1000000000;
        System.out.println("Insertion sort: "+ "\n"+InsertionTotal+" nanoseconds : "+InsertionSeconds+" seconds"+"\n");   
        
        //Merge Sort
        long MergeStart = System.nanoTime();
        for(int i = 0; i< B.length; i++) {
        	System.out.print(B[i]+ " ");
        }
        System.out.print("\n");
        MergeSort(B,0,n-1);
        for(int i = 0; i< B.length; i++) {
        	System.out.print(B[i]+ " ");
        }
        System.out.print("\n");
        long MergeEnd = System.nanoTime();
        long MergeTotal = MergeEnd - MergeStart;
        double MergeSeconds = (double)MergeTotal / 1000000000;
        System.out.println("Merge sort: "+ "\n"+MergeTotal+" nanoseconds : "+MergeSeconds+" seconds"+"\n"); 
    	
        //Heap sort
        long HeapStart = System.nanoTime();  
        
        HeapSort(C);
        
        long HeapEnd = System.nanoTime();
        long HeapTotal = HeapEnd - HeapStart;
        double HeapSeconds = (double)HeapTotal / 1000000000;
        System.out.println("Heap sort: "+ "\n"+HeapTotal+" nanoseconds : "+HeapSeconds+" seconds"+"\n");   
        
        //Quick Sort
        long QuickStart = System.nanoTime(); 
        
        QuickSort(D,0,n-1);
        
        
        long QuickEnd = System.nanoTime();
        long QuickTotal = QuickEnd - QuickStart;
        double QuickSeconds = (double)QuickTotal / 1000000000;
        System.out.println("Quick sort: "+ "\n"+QuickTotal+" nanoseconds : "+QuickSeconds+" seconds"+"\n"); 
        
        //Quick sort (Random)
        long QuickRandomStart = System.nanoTime(); 
        
        RandomQuickSort(E,0,n-1);
        
        long QuickRandomEnd = System.nanoTime();
        long QuickRandomTotal = QuickRandomEnd - QuickRandomStart;
        double QuickRandomSeconds = (double)QuickRandomTotal / 1000000000;
        System.out.println("Quick sort (Random): "+ "\n"+QuickRandomTotal+" nanoseconds : "+QuickRandomSeconds+" seconds"+"\n");   
        
        //Radix Sort
        long RadixStart = System.nanoTime(); 
        
        int [] H = RadixSort(F,3);
        
        long RadixEnd = System.nanoTime();
        long RadixTotal = RadixEnd - RadixStart;
        double RadixSeconds = (double)RadixTotal / 1000000000;
        System.out.println("Radix sort: "+ "\n"+RadixTotal+" nanoseconds:"+RadixSeconds+" seconds"+"\n"); 
        
    }
}