package baekjoon0709;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main17281 {
	
	static int n, ans = 0;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n][9];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int[] cnt = new int[5];
			arr[i][3] = sc.nextInt();
			
			for (int j = 0; j < 8; j++) {
				cnt[sc.nextInt()]++;
			}
			int a = 0;
			for (int k = 1; k < 5; k++) {
				for (int j = 0; j < cnt[k]; j++) {
					if(a != 3) {
						arr[i][a] = k;
					}else {
						arr[i][a+1] = k;
					}
					a++;
				}
			}
			for (int j = 0; j < cnt[0]; j++) {
				if(a != 3) {
					arr[i][a] = 0;
				}else {
					arr[i][a+1] = 0;
				}
				a++;
			}
		}
		
		for (int j = 0; j < arr.length; j++) {
			System.out.println(Arrays.toString(arr[j]));
			
		}
		int outcnt = 0;
		
		for (int i = 0; i < n; ) {
			for (int j = 0; j < 9; j++) {
				if(arr[i][j] == 0) {
					outcnt++;
				}else {
					for (int k = 0; k < list.size(); k++) {
						if(list.get(k)+ arr[i][j] >= 4) {
							ans++;
							list.remove(k);
						}
					}
					list.add(arr[i][j]);
				}
				if(outcnt == 3) {
					if(i+1 != n) {
						i++;
					}else {
						System.out.println(ans);
						return;
					}
				}
				
				
					
			}
		}
		
		
	}
	


}
