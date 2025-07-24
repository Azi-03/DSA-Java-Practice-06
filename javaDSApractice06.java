import java.util.*;
public class Main{
    //Method to Print Array
    static void PrintArr(int[]arr){
       int n= arr.length;
        for(int i=0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //Method to swap 2 elemets in an array
    static void swap(int arr[], int i, int j){
        int swap=arr[i];
            arr[i]=arr[j];
            arr[j]=swap;
    }
    //Method to Reverse a given Array
    static void RevArr(int[] arr){
        System.out.print("Given Array: ");
        PrintArr(arr);
        int n= arr.length;
        int swap=0;
        int j=n-1;
        for(int i=0; i<n/2;i++){
            swap(arr,i,j);
            j--;
        }
        System.out.print("Reversed Array: ");
        PrintArr(arr);
    }
    // Common elements in 3 sorted arrays
    static void commanin3array(int arr1[], int arr2[], int arr3[]){
        System.out.print("Given Array 1: ");
        PrintArr(arr1);
        int n1=arr1.length;
        System.out.print("Given Array 2: ");
        int n2=arr2.length;
        PrintArr(arr2);
        System.out.print("Given Array 3: ");
        int n3=arr3.length;
        PrintArr(arr3);
        int i=0;
        int j=0;
        int k=0;
        
      while (i < n1 && j < n2 && k < n3) {
        // If all three elements are equal
        if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
            System.out.print(arr1[i] + " ");
            i++; j++; k++;
        }
         else if (arr1[i] < arr2[j]) {
            i++;
        } else if (arr2[j] < arr3[k]) {
            j++;
        } else {
            k++;
        }
    }
    System.out.println();
}
// Triplets that sum to target
static void tripletthatsumtoK(int a[],int target){
    System.out.print("Given Array 1: ");
        PrintArr(a);
        int n= a.length;
        int count =0;
        for(int i=0; i<n;i++){
            for(int j=i+1; j<n;j++){
                for(int k=j+1; k<n;k++){
                    if(a[i]+a[j]+a[k]==target){
                        count++;
                        System.out.println("Triplet found: " + a[i] + ", " + a[j] + ", " + a[k]);
                    }
                   
                }
                
            }
            
        }
         if (count == 0) {
        System.out.println("No triplet found.");
    } else {
        System.out.println("Total triplets found: " + count);
    }
}
 // Median of two arrays of equal size
static void  Medianof2arraysofequalsize(int a[], int b[]){
    System.out.print("Given Array 1: ");
        PrintArr(a);
        int n=a.length;
        System.out.print("Given Array 2: ");
        PrintArr(b);
        int[] ans= new int[2*n];
        for(int i=0; i<n;i++){
            ans[i]=a[i];
        }
        for(int i=0; i<n;i++){
            ans[n+i]=b[i];
        }
        Arrays.sort(ans);
        
       double  median =(ans[n-1]+ans[n])/2.0;
        
        System.out.println("The median of 2 arrays is: "+ median);
    
}
// Median of two arrays of different sizes
static void  Medianof2arraysofdiffsize(int a[], int b[]){
    System.out.print("Given Array 1: ");
        PrintArr(a);
        int n=a.length;
        System.out.print("Given Array 2: ");
        PrintArr(b);
        int m=b.length;
        int[] ans= new int[m+n];
        for(int i=0; i<n;i++){
            ans[i]=a[i];
        }
        for(int i=0; i<m;i++){
            ans[n+i]=b[i];
        }
        Arrays.sort(ans);
          double median;
        if((m+n)%2==0){
           median= (ans[(m+n)/2 - 1] + ans[(m+n)/2]) / 2.0;
        }
        else{
      median=ans[(m+n)/2];
        }
        System.out.println("The median of 2 arrays is: "+ median);
    
}
// Chocolate distribution problem
    static void choclateproblem(int a[], int m){
        System.out.print("Given Array 1: ");
        PrintArr(a);
        int n=a.length;
        Arrays.sort(a);
        int minDiff=Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
    int diff = a[i + m - 1] - a[i]; 
    if (diff < minDiff) {
        minDiff = diff;
    }
}
   System.out.println("Minimum difference is: " + minDiff);
 }   
 // Print all subarrays
static void printSubarrays(int a[]) {
    System.out.print("Given Array: ");
    PrintArr(a);
    int n = a.length;

    System.out.println("All Subarrays:");
    for (int start = 0; start < n; start++) {
        for (int end = start; end < n; end++) {
            // print subarray from start to end
            for (int k = start; k <= end; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }
}
// Rearrange with +ve at even, -ve at odd indices
static void rearrange(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      
        if ((i % 2 == 0 && arr[i] >= 0) || (i % 2 != 0 && arr[i] < 0)) {
            continue; 
        }

        int j = i + 1;
        while (j < n) {
            if ((i % 2 == 0 && arr[j] >= 0) || (i % 2 != 0 && arr[j] < 0)) {
                // Found the needed element
                break;
            }
            j++;
        }

        if (j == n) break; 

        int swap = arr[i];
        arr[i]=arr[j];
        arr[j]=swap;
    }

    PrintArr(arr);
}

// Subarray with zero sum
static void subarrayWithZeroSumBrute(int[] arr) {
    System.out.print("Given Array: ");
    PrintArr(arr);
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum += arr[j];

            if (sum == 0) {
                System.out.println("Yes, a subarray with sum 0 exists between index " + i + " and " + j);
                return;
            }
        }
    }

    System.out.println("No subarray with sum 0 exists.");
}
// Kadane's Algorithm for max subarray sum
      static void maxSubarraySumKadane(int[] arr) {
    System.out.print("Given Array: ");
    PrintArr(arr);
    
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for (int i = 0; i < arr.length; i++) {
        int num = arr[i];
        currentSum += num;
        if (currentSum > maxSum) {
            maxSum = currentSum;
        }
        if (currentSum < 0) {
            currentSum = 0;
        }
    }

    System.out.println("Maximum Subarray Sum is: " + maxSum);
}
      // Big factorial
static void bigfactorial(int n) {
    int[] res = new int[1000];
    res[0] = 1;
    int resSize = 1;

    for (int x = 2; x <= n; x++) {
        int carry = 0;
        for (int i = 0; i < resSize; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry > 0) {
            res[resSize] = carry % 10;
            carry /= 10;
            resSize++;
        }
    }

    // Print result
    for (int i = resSize - 1; i >= 0; i--) {
        System.out.print(res[i]);
    }
    System.out.println();
}

    public static void main(String args[]){
        
    int[] A = {1, 5, 10, 20, 40, 80};
    int[] B = {6, 7, 20, 80, 100};
    int[] C = {3, 4, 15, 20, 30, 70, 80, 120};
    int[] D = {1, 4, 6, 8, 10, 45};
    int[] E = {1, 3, 5};
    int[] F= {2, 4, 6};
    int[] G = {1, 3};
    int[] H = {2, 4, 5};
    int[] I = {7, 3, 2, 4, 9, 12, 56};
    int[] J = {1, 2, -3, -4, 5};
    int[] K = {4, 2, -3, 1, 6};
 
    commanin3array(A,B,C);
     tripletthatsumtoK(D,22);
     Medianof2arraysofequalsize(E,F);
     Medianof2arraysofdiffsize(G,H);
     choclateproblem(I,3);
     printSubarrays(F);
     rearrange(J);
     subarrayWithZeroSumBrute(K);
     maxSubarraySumKadane(K);
     bigfactorial(100);
    }
}