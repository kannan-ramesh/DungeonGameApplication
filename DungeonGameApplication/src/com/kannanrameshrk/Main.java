package com.kannanrameshrk;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Row:");
		int row=input.nextInt();
		System.out.println("ENter Col:");
		int col=input.nextInt();
		
		startGame(row,col,input);
	}

	private static void startGame(int row, int col, Scanner input) {
		char[][] arr = new char[row][col];
		
		System.out.println("Position Of adventure:");
		int addventRow=input.nextInt();
		int addventCol=input.nextInt();
		arr[addventRow-1][addventCol-1]='A';
		
		System.out.println("Position Of Gold:");
		int goldRow=input.nextInt();
		int goldCol=input.nextInt();
		arr[goldRow-1][goldCol-1]='G';
		
		int step=Math.abs(addventRow-goldRow) + Math.abs(addventCol-goldCol);
		System.out.println(Arrays.deepToString(arr));
		
		System.out.println("Min number of steps:"+step);
	}

}
