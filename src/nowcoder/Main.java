package nowcoder;

import java.io.*;
public class Main{
    public static void main(String[] arges) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s=bf.readLine())!=null) {
             
            int n = Integer.valueOf(s);
           
            String[] arrStr = bf.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.valueOf(arrStr[i]);
            }
            System.out.println(mergeSort(arr));
        }
    }
    
    public static long mergeSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return 0;
        }
        return mergeSort(arr, 0, arr.length-1);
    }
    
    public static long mergeSort(int[] arr, int l, int r){
    	if (l == r) {
			return 0;
		}
    	int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid+1, r) + merge(arr, l, mid, r);
    }

    public static long merge(int[] arr, int l ,int mid, int r){
        int[] help = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int rst = 0;
        int i = 0;
        while(p1<=mid && p2<=r){
            rst += arr[p1] < arr[p2] ? (r-p2+1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] :arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=r){
            help[i++] = arr[p2++];
        }
        for(int j=0; j<help.length; j++){
            arr[l+j] = help[j];
        }
        return rst;
    }
}