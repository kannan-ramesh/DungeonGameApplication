package com.kannanrameshrk;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Row:");
		int row = input.nextInt();
		System.out.println("ENter Col:");
		int col = input.nextInt();

		main.startGame(row, col, input);
	}

	private void startGame(int row, int col, Scanner input) {
		char[][] arr = new char[row][col];

		System.out.println("Position Of adventure:");
		int addventRow = input.nextInt();
		int addventCol = input.nextInt();
		arr[addventRow - 1][addventCol - 1] = 'A';

		System.out.println("Position Of monster:");
		int monsterRow = input.nextInt();
		int monsterCol = input.nextInt();
		arr[monsterRow - 1][monsterCol - 1] = 'M';

		System.out.println("Position Of Gold:");
		int goldRow = input.nextInt();
		int goldCol = input.nextInt();
		arr[goldRow - 1][goldCol - 1] = 'G';

		int adventstep = Math.abs(addventRow - goldRow) + Math.abs(addventCol - goldCol);
		int monsterStep = Math.abs(monsterRow - goldRow) + Math.abs(monsterCol - goldCol);
		System.out.println(Arrays.deepToString(arr));
//		
//		System.out.println("Min number of steps:"+adventstep);
//		System.out.println("monster Step"+monsterStep);

		resultGame(adventstep, monsterStep);
	}

	private void resultGame(int adventStep, int monsterStep) {
		if (adventStep > monsterStep) {
			System.out.println("No Possible Solution..");
		} else {
			System.out.println("Minimum Number Of Steps:" + adventStep);
		}
	}

}
