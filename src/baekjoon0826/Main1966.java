package baekjoon0826;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] ans = new int[T];
		for (int t = 0; t < T; t++) {
			Queue<Point> q = new LinkedList<>();
			int cnt = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			for (int i = 0; i < n; i++) {
				q.add(new Point(i, sc.nextInt()));
			}
			while(!q.isEmpty()) {
				boolean flag = false;
				Point p = q.poll();
				for (int i = 0; i < q.size(); i++) {
					Point p1 = q.poll();
					if(p.doc < p1.doc) {
						flag = true;
					}
					q.add(p1);
				}
				if(flag == true) {
					q.add(p);
				}else {
					cnt++;
					if(p.num == m ) {
						ans[t] = cnt;
						break;
					}
				}
				
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static class Point {
		int num;
		int doc;
		public Point(int num, int doc) {
			super();
			this.num = num;
			this.doc = doc;
		}
	}
}
