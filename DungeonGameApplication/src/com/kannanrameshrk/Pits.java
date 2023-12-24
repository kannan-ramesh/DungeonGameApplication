package com.kannanrameshrk;

import java.util.Scanner;

public class Pits {
	static int step=999;
	public void startGame(int row, int col, Scanner input) {
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
		
		System.out.println("Position Of Gold:");
		int goldRow = input.nextInt();
		int goldCol = input.nextInt();
		arr[goldRow - 1][goldCol - 1] = 'G';
		
		System.out.println("Enter Number of pits:");
		int n=input.nextInt();
		int i=0;
	
		while(i<n) {
			System.out.println("Position Of Pit:");
			int pitRow = input.nextInt();
			int pitCol = input.nextInt();
			arr[pitRow - 1][pitCol - 1] = 'P';
			i++;
		}
		
		printArray(arr);
		int monsterStep=monsterToGold(monsterRow,monsterCol,goldRow,goldCol);
		
		 int minSteps = findMinSteps(arr, adventRow - 1, adventCol - 1, goldRow - 1, goldCol - 1);
	        if (minSteps == step) {
	            System.out.println("No Possible Solution..");
	        } else {
	        	if(monsterStep>minSteps) {
	        		System.out.println("Min number of steps: " + minSteps);
	        	}else {
	        		 System.out.println("No Possible Solution..");
	        	}
	        }
	}

	private int monsterToGold(int monsterRow, int monsterCol, int goldRow, int goldCol) {
		return  Math.abs(monsterRow - goldRow) + Math.abs(monsterCol - goldCol);
	}

	private int findMinSteps(char[][] arr, int curRow, int curCol, int goldRow, int goldCol) {
		if (curRow == goldRow && curCol == goldCol) {
            return 0; 
        }

        if (curRow < 0 || curRow >= arr.length || curCol < 0 || curCol >= arr[0].length
                || arr[curRow][curCol] == 'P' || arr[curRow][curCol] == '-') {
            return step; 
        }

        arr[curRow][curCol] = '-'; 

       
        int up = findMinSteps(arr, curRow - 1, curCol, goldRow, goldCol);
        int right = findMinSteps(arr, curRow, curCol + 1, goldRow, goldCol);
        int down = findMinSteps(arr, curRow + 1, curCol, goldRow, goldCol);
        int left = findMinSteps(arr, curRow, curCol - 1, goldRow, goldCol);

       
        arr[curRow][curCol] = '.';
      
        int minSteps = Math.min(Math.min(up, down), Math.min(left, right));
       
        if (minSteps != step) {
            minSteps++;
        }
        return minSteps;
	}

	private void printArray(char[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private void fillArray(char[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]='#';
			}
		}
	}
	
}
