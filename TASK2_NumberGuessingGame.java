import java.util.*;
class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessingGame Changemethod = new NumberGuessingGame();
        Changemethod.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame Changemethod = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Welcome To The Number Game");
        System.out.println("1) Play the Game ");
        System.out.println("2) Score Board ");
        System.out.println("3) Exit the Game ");
        System.out.println("-----------------------------------");

        try{
            System.out.println("From the above actions, what action would you like to do? ");
            int menuOption = input.nextInt();

            switch(menuOption) {
                case 1:
                        System.out.println("\n"+"What would you like the range of the numbers to be? ");
                        int numberRange = input.nextInt();
                        int randomNumber = Changemethod.randomNumber(numberRange);
                        Changemethod.guessNumber(randomNumber);
                        break;
                case 2:
                        Changemethod.displayScoreBoard();
                        break;
                case 3:
                        System.out.println("\n"+"Thank you for playing the game!");
                        System.exit(1);
                        break;
                default:
                        throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        }catch(InputMismatchException e) {
            System.err.println("\n"+e.getMessage()+"\n");
            menu(scoreBoard);
        }
    }
    public int randomNumber(int numberRange){
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int Guess = 0;

        do{
            System.out.println("Enter you guess number: ");
            userGuess = input.nextInt();
            Guess++;

            if(userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        }while(randomNumber != userGuess);
        System.out.println(" ");
        if(Guess == 1) {
            System.out.println("You answered number is rigt in "+Guess+" try!");
        }else {
            System.out.println("You answered number is right in "+Guess+" tries!");
        }
        scoreBoard.add(Guess);
        System.out.println(" ");

        menu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("-------------------------------------");
        System.out.println("Score Board");
        System.out.println("-------------------------------------");
        System.out.println("Your fastest games today out of all tries is: "+ "\n");
        Collections.sort(scoreBoard);

        for(Integer scores : scoreBoard) {
            System.out.println("Finished the number game in "+scores+" tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }

}


