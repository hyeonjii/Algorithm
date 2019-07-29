package beakjoon0729;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main17143 {
	static int r, c, m, ans;
	static List<Point> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		m = sc.nextInt();
		list = new LinkedList<>();
		
		for (int i = 0; i < m; i++) {
			list.add(new Point(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		for (int i = 1; i <= c; i++) {
			humanmove(i);
			for (int j = 0; j < list.size(); j++) {
				sharkmove(j);
			}
			for (int k = 0; k < list.size(); k++) {
				System.out.println(list.get(k).r+" "+list.get(k).c+" "+list.get(k).s+" "+list.get(k).d+" "+list.get(k).z);
			}
			System.out.println();
		}
		System.out.println(ans);
	}
	
	public static void sharkmove(int num) {
		Point shark = list.get(num);
		
		if(shark.d == 1) {
			int s = shark.s;
			
			while(s > 0) {
				if(shark.d == 1) {
					s -= (shark.r-1);
					shark.d =2;
					shark.r = 1;
				}else {
					s-= (r - shark.r);
					shark.d =1;
					shark.r = r;
				}
			}
			
			if(shark.d == 1) {
				shark.r = shark.r - s;
				list.set(num, new Point(shark.r, shark.c, shark.s, shark.d, shark.z));
			}else {
				shark.r = r - s;
				list.set(num, new Point(shark.r, shark.c, shark.s, shark.d, shark.z));
			}
			
		}else if(shark.d == 2) {
			int s = shark.s;
			s -= (r - shark.r);
//			System.out.println(s);
			
			while(s > 0) {
				if(shark.d == 1) {
					s -= (r-1);
					shark.d = 2;
				}else {
					s -= (r-1);
					shark.d = 1;
				}
			}
			if(shark.d == 1) {
				shark.r = shark.r - s;
				list.set(num, new Point(shark.r, shark.c, shark.s, shark.d, shark.z));
			}else {
				shark.r = r - s;
				list.set(num, new Point(shark.r, shark.c, shark.s, shark.d, shark.z));
			}
			
		}
		else if(shark.d == 3 || shark.d == 4) {
			int s = shark.s;
			s -= (c - shark.c);
			
			while(s > 0) {
				if(shark.d == 3) {
					s -= (c-1);
					shark.d = 4;
				}else {
					s -= (c-1);
					shark.d = 3;
				}
			}
			if(shark.d == 4) {
				shark.c = shark.c - s;
				list.set(num, new Point(shark.r, shark.c, shark.s, shark.d, shark.z));
			}else {
				shark.c = c - s;
				list.set(num, new Point(shark.r, shark.c, shark.s, shark.d, shark.z));
			}
				
		}
	}
	
	public static void humanmove(int num) {
		int min = 101;
		int mini = -1;
		int minz = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).c != num) {
				continue;
			}else {
				if(min > list.get(i).r ) {
					min = list.get(i).r;
					mini = i;
					minz = list.get(i).z;
				}
			}
		}
		if(mini != -1) {
			ans += minz;
			list.remove(mini);
		}
		
	}
	
	public static class Point {
		int r;
		int c;
		int s;
		int d;
		int z;
		public Point(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
