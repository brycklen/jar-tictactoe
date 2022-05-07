package tictactoe;

import java.util.Scanner;
import java.lang.Math;

public class TicTacToe {
	private String userMarker;
	private String compMarker;
	private int userLocation;
	private String[][] board;
	private int turnCount;

	public TicTacToe() {
		turnCount = 0;
		board = new String[3][3];
		int place = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = String.valueOf(place);
				place++;
			}
		}
	}

	public void playGame() {
		Scanner input = new Scanner(System.in);
		System.out.print("Which letter would you like (X or O): ");
		String choice = input.nextLine();
		while (!(choice.equals("X") || choice.equals("O"))) {
			System.out.print("Input Invalid. Which letter would you like (X or O): ");
			choice = input.nextLine();
		}

		userMarker = choice;

		if (userMarker.equals("X")) {
			compMarker = "O";
		} else {
			compMarker = "X";
		}

		printBoard();

		System.out.print("Would you like to go first or second: ");
		String turnOrder = input.nextLine();

		while (!(turnOrder.equals("first") || turnOrder.equals("second"))) {
			System.out.print("Input Invalid. Would you like to go first or second: ");
			turnOrder = input.nextLine();
		}

		if (turnOrder.equals("first")) {
			while (turnCount < 9) {
				System.out.print("Where would you like to place your move: ");
				userLocation = input.nextInt();
				placeMove(userLocation);
				if (didWin()) {
					printBoard();
					System.out.println("USER HAS WON!");
					return;
				}
				turnCount++;

				if (turnCount == 9) {
					System.out.println("TIE!");
					return;
				}

				if (turnCount != 9) {
					computerMove();
					printBoard();
					turnCount++;
					if (didWin()) {
						System.out.println("COMPUTER HAS WON!");
						return;
					}
				}
			}
		}

		if (turnOrder.equals("second")) {
			while (turnCount < 9) {
				computerMove();
				printBoard();
				if (didWin()) {
					System.out.println("COMPUTER HAS WON!");
					return;
				}
				turnCount++;

				if (turnCount == 9) {
					System.out.println("TIE!");
					return;
				}

				if (turnCount != 9) {
					System.out.print("Where would you like to place your move: ");
					userLocation = input.nextInt();
					placeMove(userLocation);
					if (didWin()) {
						printBoard();
						System.out.println("USER HAS WON!");
						return;
					}
					turnCount++;
				}
			}
		}
	}

	public void placeMove(int location) {
		switch (location) {
		case 1:
			if (board[0][0].equals("1")) {
				board[0][0] = userMarker;
			}
			break;
		case 2:
			if (board[0][1].equals("2")) {
				board[0][1] = userMarker;
			}
			break;
		case 3:
			if (board[0][2].equals("3")) {
				board[0][2] = userMarker;
			}
			break;
		case 4:
			if (board[1][0].equals("4")) {
				board[1][0] = userMarker;
			}
			break;
		case 5:
			if (board[1][1].equals("5")) {
				board[1][1] = userMarker;
			}
			break;
		case 6:
			if (board[1][2].equals("6")) {
				board[1][2] = userMarker;
			}
			break;
		case 7:
			if (board[2][0].equals("7")) {
				board[2][0] = userMarker;
			}
			break;
		case 8:
			if (board[2][1].equals("8")) {
				board[2][1] = userMarker;
			}
			break;
		case 9:
			if (board[2][2].equals("9")) {
				board[2][2] = userMarker;
			}
			break;
		default:
			System.out.print("INVALID");
			break;
		}
	}

	public void computerMove() {
		int row = (int) (Math.random() * 3);
		int col = (int) (Math.random() * 3);
		if (board[row][col].matches("1|2|3|4|5|6|7|8|9")) {
			board[row][col] = compMarker;
		} else {
			computerMove();
		}
	}

	public void printBoard() {
		System.out.println("-----------------------");
		System.out.println("|      |       |      |");
		System.out.println("|  " + board[0][0] + "   |   " + board[0][1] + "   |   " + board[0][2] + "  |");
		System.out.println("-------|-------|-------");
		System.out.println("|      |       |      |");
		System.out.println("|  " + board[1][0] + "   |   " + board[1][1] + "   |   " + board[1][2] + "  |");
		System.out.println("-------|-------|-------");
		System.out.println("|      |       |      |");
		System.out.println("|  " + board[2][0] + "   |   " + board[2][1] + "   |   " + board[2][2] + "  |");
		System.out.println("-----------------------");
	}

	public boolean didWin() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
				return true;
			}

			if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
				return true;
			}
		}

		if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
			return true;
		}

		if (board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])) {
			return true;
		}

		return false;
	}
}