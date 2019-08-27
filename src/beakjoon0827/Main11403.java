package beakjoon0827;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11403 {
	static int n;
	static int[][] map;
	static int[][] ans;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		ans = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				solve(i, j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static void solve(int s, int f ) {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[n];
		
		for (int i = 0; i < map.length; i++) {
			if(map[s][i] == 1) {
				q.add(i);
				visit[i] = true;
			}
		}
		
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			if(p == f) {
				ans[s][f] = 1;
				return;
			}
			
			for (int i = 0; i < map.length; i++) {
				if(map[p][i] == 1 && !visit[i]) {
					q.add(i);
				}
			}
			
		}	
	}
}
