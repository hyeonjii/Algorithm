package beakjoon0812;

import java.util.Arrays;
import java.util.Scanner;

public class Main17406 {
	static int n, m, k, msum= 987654321;
	static int[][] map;
	static int[][] cmap;
	static rcs[] rcsmap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		cmap = new int[n+1][m+1];
		map = new int[n+1][m+1];
		rcsmap = new rcs[k];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				cmap[i][j] = sc.nextInt(); 
			}
		}
		for (int i = 0; i < k; i++) {
			rcsmap[i] = new rcs(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		perm(rcsmap, 0 );
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));			
//		}
		System.out.println(msum);
	}
	
	public static void copymap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = cmap[i][j];
			}
		}
	}
	
	public static void solve(int idx) {
		int nr = rcsmap[idx].r;
		int nc = rcsmap[idx].c;
		int ns = rcsmap[idx].s;
		int sr = nr - ns;
		int sc = nc - ns;
		int fr = nr + ns;
		int fc = nc + ns;
		
//		System.out.println(nr+" "+nc+" "+ns);
		while(sr != fr && sc != fc ) {
			int start = map[sr][sc];
			for (int i = sr+1; i <= fr; i++) {
				map[i-1][sc] = map[i][sc];
			}
			for (int i = sc+1; i <= fc; i++) {
				map[fr][i-1] = map[fr][i];
			}
			for (int i = fr-1; i >= sr; i--) {
				map[i+1][fc] = map[i][fc];
			}
			for (int i = fc-1; i > sc; i--) {
				map[sr][i+1] = map[sr][i];
			}
			map[sr][sc+1] = start;
			
			sr += 1;
			sc += 1;
			fr -= 1;
			fc -= 1;
		}
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));			
//		}
//		int msum = 987654321;
		
	}
	
	public static void checksum() {
		for (int i = 1; i < map.length; i++) {
			int sum = 0;
			for (int j = 1; j < map[i].length; j++) {
				sum += map[i][j];
//				System.out.println(sum);
			}
			if(msum > sum) {
				msum = sum;
			}
		}
	}
	
	static void perm(rcs[] arr, int idx) {
		if(idx == k) {
			copymap();
			for (int i = 0; i < k; i++) {
				solve(i);
			}
			checksum();
			return;
		}
		
		for(int i = idx; i< k; i++) {
			swap(arr, idx, i);
			perm(arr, idx+1);
			swap(arr, idx, i);
		}
		
	}
	static void swap(rcs[] arr, int a, int b) {
		rcs tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static class rcs{
		int r;
		int c;
		int s;
		public rcs(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
