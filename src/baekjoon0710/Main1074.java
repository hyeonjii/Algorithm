package baekjoon0710;

import java.util.Arrays;
import java.util.Scanner;

public class Main1074 {
	static int num = -1, r, c;
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int size = (int) Math.pow(2, n);
		
		solve(size, 0, size, 0, size);
	}
	
	public static void solve(int size, int startx, int endx, int starty, int endy) {
		if( !(starty <= r && r < starty + size && startx <= c && c < startx + size) ) {
			num += size * size;
			return;
		}
		
		int rsize = (endx-startx)/2;
		

		if(rsize == 1) {
			if(starty == r && startx == c) {
				++num;
				System.out.println(num);
				System.exit(0);
			}else {
				++num;
			}
			
			if(starty== r && startx+rsize== c) {
				++num;
				System.out.println(num);
				System.exit(0);
			}else {
				++num;
			}
			
			if(starty+rsize== r &&startx== c) {
				++num;
				System.out.println(num);
				System.exit(0);
			}else {
				++num;
			}
			
			if(starty+rsize== r &&startx+rsize== c) {
				++num;
				System.out.println(num);
				System.exit(0);
			}else {
				++num;
			}
		}
		
		if( rsize != 1) {
			solve(rsize, startx, startx+rsize, starty, starty+rsize);
			solve(rsize, startx+rsize, endx, starty, starty+rsize);
			solve(rsize, startx, startx+rsize, starty+rsize, endy);
			solve(rsize, startx+rsize, endx, starty+rsize, endy);
		}
		
		
	}

}
