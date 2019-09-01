package beakjoon0901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main15661 {
	static int n;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		powerset(arr, new boolean[n], 0);
		
	}
	
	public static void powerset(int[] arr, boolean[] sel, int idx) {
		if(idx == arr.length) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < sel.length; i++) {
				if(sel[i] == true) {
					list1.add(i);
				}
			}
			for (int i = 0; i < sel.length; i++) {
				if(sel[i] != true) {
					list2.add(i);
				}
			}
			solve(list1, list2);
			return;
		}
		
		sel[idx] = false;
		powerset(arr, sel, idx+1);
		sel[idx] = true;
		powerset(arr, sel, idx+1);
		
	}

	public static void solve(List<Integer> list1, List<Integer> list2) {
		if(list1.size() == 0 || list1.size() == n) {
			return;
		}
		
		int[] arr1 = new int[list1.size()];
		int[] arr2 = new int[list2.size()];
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = list1.get(i);
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = list2.get(i);
		}
		
		comb(arr1, new int[2], 0, 0);
		
		
	}
	
	public static void comb(int[] arr, int[] sel, int idx, int cnt) {
		if(cnt == sel.length) {
			int sum = 0;
			
			sum += map[sel[0]][sel[1]];
			sum += map[sel[1]][sel[0]];
		}
		if(idx ==  arr.length) {
			return;
		}
		
		sel[cnt] = 0;
		comb(arr, sel, idx+1, cnt);
		sel[cnt] = arr[idx];
		comb(arr, sel, idx+1, cnt+1);
	}
}
