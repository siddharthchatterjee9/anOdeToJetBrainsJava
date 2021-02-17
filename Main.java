package tictactoe;
/* Author is 19BCE2249 Siddharth Chatterjee */
import java.util.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            int count1 = 0;
            int count2 = 0;
            char index = ' ';
            char variable = 'X';
            Scanner in = new Scanner(System.in);
            System.out.println("---------");
            char[][] myGrid = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            System.out.print("| ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(myGrid[i][j] + " ");
                }
                if (i != 2) {
                    System.out.print("|\n| ");
                } else {
                    System.out.println("|");
                }
            }
            System.out.println("---------");
            while (true) {
                System.out.print("Enter the coordinates: ");
                int row = 0;
                int column = 0;
                int indexRow = 0;
                int indexColumn = 0;
                boolean validInput = false;
                while (!validInput) {
                    try {
                        row = in.nextInt();
                        column = in.nextInt();
                        validInput = true;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("You should enter numbers!");
                        System.out.print("Enter the coordinates: ");
                        in.nextLine();
                    }
                }
                if (row == 1 && column == 1) {
                    indexRow = 0;
                    indexColumn = 0;
                } else if (row == 1 && column == 2) {
                    indexRow = 0;
                    indexColumn = 1;
                } else if (row == 1 && column == 3) {
                    indexRow = 0;
                    indexColumn = 2;
                } else if (row == 2 && column == 1) {
                    indexRow = 1;
                    indexColumn = 0;
                } else if (row == 2 && column == 2) {
                    indexRow = 1;
                    indexColumn = 1;
                } else if (row == 2 && column == 3) {
                    indexRow = 1;
                    indexColumn = 2;
                } else if (row == 3 && column == 1) {
                    indexRow = 2;
                    indexColumn = 0;
                } else if (row == 3 && column == 2) {
                    indexRow = 2;
                    indexColumn = 1;
                } else if (row == 3 && column == 3) {
                    indexRow = 2;
                    indexColumn = 2;
                }

                if (myGrid[indexRow][indexColumn] != ' ') {
                    System.out.println("The cell is occupied! Choose another one!");
                    continue;
                }
                if (row > 3 || column > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                System.out.println("---------");
                System.out.print("| ");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (myGrid[indexRow][indexColumn] == ' ') {
                            myGrid[indexRow][indexColumn] = variable;
                            if (variable == 'X') {
                                variable = 'O';
                            }
                            else {
                                variable = 'X';
                            }
                        }
                        if (myGrid[i][0] != ' ') {
                            if (myGrid[i][0] == myGrid[i][1] && myGrid[i][1] == myGrid[i][2]) {
                                count1 += 1;
                                if (count1 == 3) {
                                    index = myGrid[i][0];
                                }
                            }
                        }
                        if (myGrid[0][i] != ' ') {
                            if (myGrid[0][i] == myGrid[1][i] && myGrid[1][i] == myGrid[2][i]) {
                                count2 += 1;
                                if (count2 == 3) {
                                    index = myGrid[0][i];
                                }
                            }
                        }
                        System.out.print(myGrid[i][j] + " ");
                    }
                    if (i != 2) {
                        System.out.print("|\n| ");
                    } else {
                        System.out.println("|");
                    }
                }
                System.out.println("---------");
                if (myGrid[0][2] != ' ' && myGrid[0][2] == myGrid[1][1] && myGrid[1][1] == myGrid[2][0]) {
                    System.out.println(myGrid[0][2] + " wins");
                    exit(0);
                }
                else if (myGrid[0][0] != ' ' && myGrid[0][0] == myGrid[1][1] && myGrid[1][1] == myGrid[2][2]) {
                    System.out.println(myGrid[0][0] + " wins");
                    exit(0);
                }
                else if (index == 'X' || index == 'O') {
                    System.out.println(index + " wins");
                    exit(0);
                }
                count1 = 0;
                count2 = 0;
                int count3 = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (myGrid[i][j] != ' ') {
                            count3 += 1;
                        }
                    }
                }
                if (count3 == 9) {
                    System.out.println("Draw");
                    exit(0);
                    break;
                }
            }
        }
    }
}
