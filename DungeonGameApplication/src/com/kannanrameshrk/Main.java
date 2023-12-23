package com.kannanrameshrk;

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
		Pits pit=new Pits();
		//pit.startGame(row,col,input);
	}

	private void startGame(int row, int col, Scanner input) {
		char[][] arr = new char[row][col];
		fillArray(arr);
		
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
		int triggerStep=Math.abs(adventRow-triggerRow)+Math.abs(adventCol-triggerCol);
		int triggerStepGold=Math.abs(triggerRow-goldRow)+Math.abs(triggerCol-goldCol);
		
		printArray(arr);

		resultGame(adventstep, monsterStep,adventRow,adventCol, monsterRow, monsterCol,goldRow,goldCol,triggerRow,triggerCol,triggerStep,triggerStepGold);
	}

	private void fillArray(char[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]='#';
			}
		}
	}

	private void printArray(char[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private void resultGame(int adventStep, int monsterStep, int adventRow, int adventCol, int monsterRow, int monsterCol, int goldRow, int goldCol, int triggerRow, int triggerCol, int triggerStep, int triggerStepGold) {
		if (adventStep > monsterStep) {
			int steps=triggerStep+triggerStepGold;
			System.out.println("Minimum Step Of "+steps);
		} else {
			System.out.println("Minimum Number Of Steps:" + adventStep);
			findPath(adventRow, adventCol, goldRow, goldCol,adventStep,monsterRow,monsterCol);
		}
	}

	private void findPath(int adventRow, int adventCol, int goldRow, int goldCol, int step, int monsterRow, int monsterCol) {
		System.out.print("Path:");
		for(int i=0;i<step;i++) {
			System.out.print("("+adventRow+","+adventCol+")->");
			
			 // Move the adventurer towards the gold cell
	        if (adventRow != goldRow || adventCol != goldCol) {
	            if (adventRow != goldRow) {
	                adventRow += (adventRow < goldRow) ? 1 : -1;
	            }
	            if (adventCol != goldCol) {
	                adventCol += (adventCol < goldCol) ? 1 : -1;
	            }
	        } else {
	            // The adventurer has reached the gold cell
	            // Move the monster towards the gold cell
	            if (monsterRow != goldRow || monsterCol != goldCol) {
	                if (monsterRow != goldRow) {
	                    monsterRow += (monsterRow < goldRow) ? 1 : -1;
	                }
	                if (monsterCol != goldCol) {
	                    monsterCol += (monsterCol < goldCol) ? 1 : -1;
	                }
	            }
	        }
		}
	}
}
