package tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Integer> playerPosition = new ArrayList<Integer>();
        ArrayList <Integer> computerPosition = new ArrayList<Integer>();


        //desiging the gameboard
        char [][] board =  {{' ',' ',' '},
                            {' ',' ',' '},
                            {' ',' ',' '}};
        printBoard(board);

        while (true) 
        {
            //player turn
            playerTurn(board, scanner, playerPosition);
            printBoard(board);

            //checking for win
            checkWinner(playerPosition, computerPosition);
            
            // computer turn
            computerTurn(board, computerPosition);
            printBoard(board);

            //checking for win
            checkWinner(playerPosition, computerPosition);

        }

    }

    //check winner
    private static void checkWinner (ArrayList<Integer> playerPosition, ArrayList<Integer> computerPosition)
    {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if(playerPosition.containsAll(l))
            {
                System.out.println("Player Wins !!!");
                System.exit(0);
            }
            else if (computerPosition.containsAll(l))
            {
                System.out.println("Computer Wins !!!");System.exit(0);
            }
            else if (playerPosition.size()+computerPosition.size() == 9)
            {
                System.out.println("No one wins !! Get the fuck outta here !!!1");System.exit(0);
            }
            else
            {
                continue;
            }
        }


    }


    //computer's move to 
    private static void computerTurn(char[][] board, ArrayList<Integer> computerPosition) {
        Random random = new Random(); 
        int computerMove;
        while(true)
        {
            computerMove = random.nextInt(9) + 1;
            if(isValid(board, computerMove)){
                computerPosition.add(computerMove);
                break;
            }      
        }
        System.out.println("Computer move, computer chose +" +computerMove);
        placeMove(board,Integer.toString(computerMove), 'O');
    }


    // checking if the computer generated a correct value or not
    private static boolean isValid(char[][] board, int position)
    {
        switch(position){
            case 1: return (board[0][0] == ' ');
    
            case 2: return (board[0][1] == ' ');

            case 3: return (board[0][2] == ' ');

            case 4: return (board[1][0] == ' ');

            case 5: return (board[1][1] == ' ');

            case 6: return (board[1][2] == ' ');

            case 7: return (board[2][0] == ' ');

            case 8:return ( board[2][1] ==  ' ');

            case 9: return (board[2][2] == ' ');

            default:
            System.out.println("Is not a valid move"); return false;
        }
    }


    //player turn
    private static void playerTurn(char[][] board, Scanner scanner, ArrayList<Integer> playerPosition) {

        System.out.println("Where would you like to play 1-9: ");
        String userInput;

        while(true)
        {
            userInput = scanner.nextLine();
            if(isValid(board, Integer.parseInt(userInput)))
            {
                playerPosition.add(Integer.parseInt(userInput));
                break;
            }
            else{
                System.out.println("Occupied please enter a new value");
                continue;
            }
        }
        
        placeMove(board, userInput, 'X');
 
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position){
            case "1": board[0][0] = symbol;
            break;
            case "2": board[0][1] = symbol;
            break;
            case "3": board[0][2] = symbol;
            break;
            case "4": board[1][0] = symbol;
            break;
            case "5": board[1][1] = symbol;
            break;
            case "6": board[1][2] = symbol;
            break;
            case "7": board[2][0] = symbol;
            break;
            case "8": board[2][1] = symbol;
            break;
            case "9": board[2][2] = symbol;
            break;
            default:
            System.out.println("Wrong input :(");
        }
    }

    // to print the entier board everytime
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0]+ "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+ "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+ "|" + board[2][1] + "|" + board[2][2]);
    }
}
