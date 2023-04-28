

public class Sorting{

	
	/**
	 * Sorts a given array using the quick sort algorithm.
	 * At each stage the pivot is chosen to be the rightmost element of the subarray.
	 * 
	 * Should run in average complexity of O(nlog(n)), and worst case complexity of O(n^2)
	 * 
	 * @param arr - the array to be sorted
	 */
	
	public static void quickSort(double[] arr){
        int p = 0;
        int r = arr.length-1;
        quickSort(arr, p, r);
}
public static void quickSort(double[] arr, int p, int r) {
    if (p<r) {
        int q = Partition(arr,p,r);
        quickSort(arr,p,q-1);
        quickSort(arr,q+1,r);
    }
    
}
public static int Partition(double[] arr,int p, int r){
    double x = arr[r];
    int i=p-1;
	for(int j=p;j<r;j++){
		if(arr[j]<x) {
			i++;
			double temp = arr[i];
			arr[i]= arr[j];
			arr[j] = temp;
		}
	}
	double temp = arr[i+1];
	arr[i+1] = arr[r];
	arr[r] = temp;
	return (i+1);
    
    }


	


	/**
	 * Given an array arr and an index i returns the the i'th order statstics in arr. 
	 * In other words, it returns the element with rank i in the array arr.
	 * 
	 * At each stage the pivot is chosen to be the rightmost element of the subarray.
	 * 
	 * Should run in average complexity of O(n), and worst case complexity of O(n^2)
	 * 
	 **/
	public static double QuickSelect(double[] arr, int i){
		int p=0;
        int r = arr.length-1;
       return QuickSelect(arr,p,r,i-1);
	}
    public static double QuickSelect(double[] arr,int p,int r,int i) {
        if(p==r) return arr[p];
        int q = Partition(arr,p,r);
      
      	 int m=i;
		if(i==q) return arr[q];
        if(m<q) return QuickSelect(arr,p,q-1,i);
        else return QuickSelect(arr,q+1,r,i);
        }
    
    

	
	
	
	
	/**
	 * Sorts a given array using the merge sort algorithm.
	 * 
	 * Should run in complexity O(nlog(n)) in the worst case.
	 * 
	 * @param arr - the array to be sorted
	 */
	
	public static void mergeSort(double[] arr){
        int p=0;
        int r = arr.length-1;
        mergeSort(arr,p,r);

}
public static void mergeSort(double [] arr, int p, int r) {
    if (p<r) {
        int q = (p+r)/2;
        mergeSort(arr,p,q);
        mergeSort(arr,q+1,r);
        merge(arr,p,q,r);
    }
}
public static void merge(double [] arr, int p,int q,int r){
    int n1 = q-p+1;
    int n2 = r-q;
    double [] L = new double [n1+1];
    double [] R = new double [n2+1];
    for (int i=0;i<n1;i++) {
        L[i]=arr[p+i];
    }
    for(int j=0;j<n2;j++){
        R[j]=arr[q+j+1];
    }
    L[n1] = Double.POSITIVE_INFINITY;
    R[n2] = Double.POSITIVE_INFINITY;
    int i=0;
    int j=0;
    for(int k=p;k<=r;k++) {
        if(L[i]<=R[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
        }
    }   
}
	
	/**
	 * Sorts a given array using bubble sort.
	 * 
	 * The algorithm should run in complexity O(n^2).
	 * 
	 * @param arr - the array to be sorted
	 */
	
		public static void bubbleSort(double[] arr){
			int stop = 0;
			int swap = 0;
			for (int i=0;i<arr.length;i++) {
				if (stop==1) return;
				 else swap = 0;
				 for(int j=1;j<arr.length-i;j++) {
					 if(arr[j-1]>arr[j]) {
						 swap = 1;
						 double temp = arr[j-1];
						 arr[j-1] = arr[j];
						 arr[j] = temp;
					 } 
				 }
				 if (swap == 0) stop = 1;
				}
	} 
	
	/**
	 * Sorts a given array, using the counting sort algorithm.
	 * All elements in the array are between 0 and k (not including k).
	 * 
	 * Should run in complexity O(n + k) in the worst case.
	 * 
	 * @param arr - an array with possitive integers
	 * @param k - an upper bound for the values of all elements in the array.
	 */
	public static void countingSort(int[] arr, int k){
			int [] c = new int [k+1];
			for(int j=0;j<arr.length;j++) {
				c[arr[j]]++;
			}
			for(int j=1;j<c.length;j++){
				c[j] = c[j] + c[j-1];
			}
			int [] b = new int[arr.length];
			for(int j=arr.length-1;j>=0;j--){
				int num = arr[j];
				int counts = c[num];
				b[counts-1] = arr[j];
				c[arr[j]]--;
			}
			for(int i=0;i<arr.length;i++){
				arr[i]=b[i];
			}
		}
	
		/**
		 * Prints the array in one line.
		 * @param array
		 */
		public static void ToString(int [] array){
			for (int i=0;i<array.length-1;i++){
				System.out.print(array[i] + ",");
			}
			System.out.print(array[array.length-1]);
		}
		
		public static void ToString(double [] array){
			for (int i=0;i<array.length-1;i++){
				System.out.print(array[i] + ",");
			}
			System.out.print(array[array.length-1]);
		}
		
    
	public static void main(String[] args) {
	
		int [] a = {1,4,3,6,2,8,9};
		//System.out.println(QuickSelect(a,3));
		countingSort(a,100);
		ToString(a);		
	}
	
	
}
	
