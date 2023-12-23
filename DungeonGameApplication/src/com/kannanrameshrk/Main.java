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
		int adventRow = input.nextInt();
		int adventCol = input.nextInt();
		arr[adventRow - 1][adventCol - 1] = 'A';

		System.out.println("Position Of monster:");
		int monsterRow = input.nextInt();
		int monsterCol = input.nextInt();
		arr[monsterRow - 1][monsterCol - 1] = 'M';
		
		System.out.println("Position Of trigger:");
		int triggerRow = input.nextInt();
		int triggerCol = input.nextInt();
		arr[triggerRow - 1][triggerCol - 1] = 'T';

		System.out.println("Position Of Gold:");
		int goldRow = input.nextInt();
		int goldCol = input.nextInt();
		arr[goldRow - 1][goldCol - 1] = 'G';

		int adventstep = Math.abs(adventRow - goldRow) + Math.abs(adventCol - goldCol);
		int monsterStep = Math.abs(monsterRow - goldRow) + Math.abs(monsterCol - goldCol);
		int triggerStep=Math.abs(adventRow-triggerCol)+Math.abs(adventCol-goldCol);
		int triggerStepGold=Math.abs(triggerRow-goldRow)+Math.abs(triggerCol-goldCol);
		System.out.println(Arrays.deepToString(arr));
//		
//		System.out.println("Min number of steps:"+adventstep);
//		System.out.println("monster Step"+monsterStep);

		resultGame(adventstep, monsterStep,adventRow,adventCol, monsterRow, monsterCol,goldRow,goldCol,triggerRow,triggerCol,triggerStep,triggerStepGold);
	}

	private void resultGame(int adventStep, int monsterStep, int adventRow, int adventCol, int monsterRow, int monsterCol, int goldRow, int goldCol, int triggerRow, int triggerCol, int triggerStep, int triggerStepGold) {
		if (adventStep > monsterStep) {
			int steps=triggerStep+triggerStepGold;
			System.out.println("Minimum Step Of "+steps);
		} else {
			System.out.println("Minimum Number Of Steps:" + adventStep);
			//findPath(adventRow, adventCol, goldRow, goldCol,adventStep,monsterRow,monsterCol);
		}
	}

	private void findPath(int adventRow, int adventCol, int goldRow, int goldCol, int step, int monsterRow, int monsterCol) {
		for(int i=0;i<step;i++) {
			System.out.print("Path:("+adventRow+","+adventCol+")->");
			if((adventRow!= monsterRow) && (adventCol!=monsterCol)) {
				if(adventRow<goldRow) {
					adventRow++;
				}else if(monsterRow<goldRow) {
					monsterRow--;
				}
				if(adventCol>goldCol) {
					adventCol--;
				}else if(monsterCol>goldCol) {
					monsterCol++;
				}
				
			}else {
				if(adventRow>goldRow){
					adventRow--;
				}else if(monsterRow>goldRow) {
					monsterRow--;
				}
				if(adventCol<goldCol) {
					adventCol++;
					
				}else if( monsterCol<goldCol) {
					monsterCol--;
				}
			}
			
		}
	}
}
