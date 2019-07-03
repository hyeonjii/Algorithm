package baekjoon0703;

import java.util.Scanner;

public class Main14620 {
	static int n, ans = 987654321;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int fi = 1; fi < map.length-1; fi++) {
			for (int fj = 1; fj < map[fi].length-1; fj++) {
				for (int si = 1; si < map.length-1; si++) {
					for (int sj = 1; sj < map[fi].length-1; sj++) {
						for (int ti = 1; ti < map.length-1; ti++) {
							for (int tj = 1; tj < map[ti].length-1; tj++) {
								solve(fi, fj, si, sj, ti, tj);
//								System.out.println(fi+" "+fj+" "+si+" "+sj+" "+ti+" "+tj);
							}
						}
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void solve(int fi, int fj, int si, int sj, int ti, int tj) {
		int sum = map[fi][fj] + map[si][sj] + map[ti][tj];
		
		if(check(fi, fj, si, sj, ti, tj)) {
			
			for (int i = 0; i < dx.length; i++) {
				int fx = fi + dx[i];
				int fy = fj + dy[i];
				sum += map[fx][fy];
			}
			for (int i = 0; i < dx.length; i++) {
				int sx = si + dx[i];
				int sy = sj + dy[i];
				sum += map[sx][sy];
			}
			for (int i = 0; i < dx.length; i++) {
				int tx = ti + dx[i];
				int ty = tj + dy[i];
				sum += map[tx][ty];
			}
			
			if(ans > sum) {
				ans = sum;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	public static boolean check(int fi, int fj, int si, int sj, int ti, int tj) {
		if(Math.pow((fi-si), 2)+Math.pow((fj-sj), 2) < 5) {
			return false;
		}
		if(Math.pow((fi-ti), 2)+Math.pow((fj-tj), 2) < 5) {
			return false;
		}
		if(Math.pow((si-ti), 2)+Math.pow((sj-tj), 2) < 5) {
			return false;
		}
		return true;
	}

}
