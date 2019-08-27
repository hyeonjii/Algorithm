package beakjoon0827;

import java.util.Arrays;
import java.util.Scanner;

public class Main10974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 1; i <= arr.length; i++) {
			arr[i-1] = i;
		}
		perm(0, arr);
	}
	
	public static void perm(int idx, int[] arr) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(arr));
		}
		for (int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			perm(idx+1, arr);
			swap(arr, idx, i);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
