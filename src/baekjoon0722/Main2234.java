package baekjoon0722;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main2234 {
	static String[] tower = {"0000", "0001", "0010", "0011", "0100"
			,"0101" ,"0110", "0111", "1000", "1001", "1010"
			, "1011","1100","1101","1110", "1111"};
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int n, m;
	static List<Integer> ans = new ArrayList<Integer>();
	static String[][] map;
	static boolean[][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new String[n][m];
		visit = new boolean[4][n][m];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = tower[sc.nextInt()];
			}
		}
//		System.out.println(0%4);
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				String line = map[i][j];
//				System.out.println(line);
				for (int k = 0; k <4 ; k++) {
//					System.out.println(line.charAt(k));
					if(line.charAt(k) == '0' && !visit[k][i][j]) {
//						System.out.println(k);
						solve(i, j, k);
					}
				}
			}
		}
//		System.out.println(ans.size());
//		for (int i = 0; i < ans.size(); i++) {
//			System.out.println(ans.get(i));
//		}
	}
	
	public static void solve(int x, int y, int k) {
		int max = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, k, 1));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
//			if(p.cnt > max) {
//				max = p.cnt;
//			}
			int nx = p.x + dx[p.k];
			int ny = p.y + dy[p.k];
//			if(nx < 0 || ny < 0 || nx <= n || ny <= m) {
//				continue;
//			}
			int nk = (p.k+2) % 4;
//			System.out.println(nk);
			visit[p.k][p.x][p.y] = true;
			visit[nk][nx][ny] = true;
			String line = map[nx][ny];
			System.out.println(line);
			for (int i = 0; i < 4; i++) {
				if(line.charAt(i) == '0' && !visit[i][nx][ny]) {
					q.add(new Point(nx, ny, i, p.cnt+1));
//					System.out.println("a");
					max++;
				}
			}
		}
		System.out.println(max);
		ans.add(max);
	}

	public static class Point {
		int x;
		int y;
		int k;
		int cnt;
		public Point(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
}
