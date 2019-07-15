package baekjoon0710;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main16957 {
	static int r, c;
	static List<Point>[][] listmap;
	static List<Point>[][] clistmap;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		listmap = new ArrayList[r][c];
		clistmap = new ArrayList[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				listmap[i][j] = new ArrayList<>();
				clistmap[i][j] = new ArrayList<>();
				listmap[i][j].add(new Point(i, j, sc.nextInt()));
			}
		}
		
		
		
		
	}
	
	public static class Point{
		int x;
		int y;
		int val;
		public Point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
	}

}
