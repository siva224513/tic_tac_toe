package tic_tac_toe;

import java.awt.color.ICC_ColorSpace;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char board[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

		printBoard(board);
		while (true) {
			playerTurn(board, scanner);
			if (isGameOver(board)) {
				break;
			}
			printBoard(board);
			computerTurn(board);
			if (isGameOver(board)) {
				break;
			}
			printBoard(board);

		}

		scanner.close();

	}

	private static boolean isGameOver(char[][] board) {
		if (hasContestentWon(board, 'X')) {
			printBoard(board);
			System.out.println("Player Wins");
			return true;
		}
		if (hasContestentWon(board, 'O')) {
			printBoard(board);
			System.out.println("Computer Wins");
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == ' ')
					return false;
			}
		}
		printBoard(board);
		System.out.println("The game ended in tie!..");
		return true;
	}

	private static boolean hasContestentWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)
				|| (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)
				|| (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

				(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)
				|| (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)
				|| (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

				(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
				|| (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
			return true;
		}
		return false;
	}

	private static void computerTurn(char[][] board) {
		Random random = new Random();
		int computerMove;
		while (true) {
			computerMove = random.nextInt(9) + 1;
			if (isValidMove(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer choose " + computerMove);
		placeMove(board, Integer.toString(computerMove), 'O');
	}

	private static void playerTurn(char[][] board, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Where would you like to place? (1-9) ");
			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)) {
				break;
			} else {
				System.out.println(userInput + " is not a valid move");
			}
		}
		placeMove(board, userInput, 'X');
	}

	private static void placeMove(char[][] board, String userInput, char c) {
		switch (userInput) {
		case "1":
			board[0][0] = c;
			break;
		case "2":
			board[0][1] = c;
			break;
		case "3":
			board[0][2] = c;
			break;
		case "4":
			board[1][0] = c;
			break;
		case "5":
			board[1][1] = c;
			break;
		case "6":
			board[1][2] = c;
			break;
		case "7":
			board[2][0] = c;
			break;
		case "8":
			board[2][1] = c;
			break;
		case "9":
			board[2][2] = c;

		}
	}

	private static boolean isValidMove(char[][] board, String userInput) {
		switch (userInput) {
		case "1":
			return board[0][0] == ' ';
		case "2":
			return board[0][1] == ' ';
		case "3":
			return board[0][2] == ' ';
		case "4":
			return board[1][0] == ' ';
		case "5":
			return board[1][1] == ' ';
		case "6":
			return board[1][2] == ' ';
		case "7":
			return board[2][0] == ' ';
		case "8":
			return board[2][1] == ' ';
		case "9":
			return board[2][2] == ' ';
		}
		return false;
	}

	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("-+-+-");
		System.out.println();
	}

}
