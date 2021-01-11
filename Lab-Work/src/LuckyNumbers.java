import java.util.ArrayList;
import java.util.Scanner;

public class LuckyNumbers {
    // tracks which question from the list the user is currently on
    public static int questionNum = 1;
    // arrayList of user answers to questions asked
    public static ArrayList<String> answers = new ArrayList<String>();
    //scanner to grab user input
    public static Scanner input = new Scanner(System.in);
    // max number that the MagicBall Number can be
    public static int magicBallNumMax= 75;
    //max number that the Lottery can be
    public static int lotteryNumMax= 65;
    // variable that stores user's most recent answer
    public static String answer;

    //list of questions that user will be asked during the course of the game
    public static String[] questions = {"Do you wish to continue to the interactive portion of the program? " +
            "(Enter Y or yes to continue; Enter N or no to quit)",
            "What is the name of your favorite pet?",
            "What is the age of your favorite pet?",
            "What is you lucky number?",
            "What is your favorite quarterback's Jersey Number?",
            "What is the two-digit model year of their car?",
            "What is the first name of their favorite actor or actress?",
            "Enter a random number between 1 and 50:"
            };

    // function initiates the user's Lucky Lotto Game
    private static void playGame(){
        System.out.println("Please enter your name: ");
        System.out.println("Oh! Hello, " + input.nextLine());
        System.out.println(questions[0]);
        answer = input.nextLine();
        askQuestions();
    }

    // returns boolean: if user inputs Y or Yes = true / N or No = false / anything else = error
    private static boolean doYouWishToCont(String userInput)
    {   //ask if user wants to continue
        //scan for Yes or Y input with scanner
        //Cont is now true with program if Y, cont is not false if N
        boolean cont;
        if (userInput.contains("Y") || userInput.contains("yes") || userInput.contains("Yes") || userInput.contains("y")){
            cont = true;
        } else if (userInput.contains("N") || userInput.contains("n") || userInput.contains("No") || userInput.contains("no")) {
            cont = false;
        } else {
            cont = false;
            System.out.println("ERROR- PLEASE RESTART");
        }
        return cont;
    }

    // prints final output to user before ending program
    private static void closeProgram() {
        System.out.println("Please return later to complete the survey!");
    }

    // resets number of questions user is on to 1, asks user if they want to play again, clears answers Array, assigns user input to answer and runs askQuestions() functions with answer
    private static void resetGame() {
        resetQuestionNum();
        System.out.println("Would you like to play again?");
        answers.clear();
        answer = input.nextLine();
        askQuestions();
    }

    // resets value of questionNum to 1 to start questions over
    private static void resetQuestionNum() {
        questionNum = 1;
    }

    // Prints lottoNumber() and magicBall() numbers to screen
    private static void displayLuckyNumbers() {
        System.out.println("Lotto Numbers:" + lottoNumbers() + " Magic Ball: " + magicBall());
    }

    // if questionNum is less than 8, question will print to screen for user and iterate questionNum/ otherwise, will displayLuckyNumbers and resetGame()
    private static void questionIterator() {
        if (questionNum < 8) {
            System.out.println(questions[questionNum]);
            questionNum++;
        } else {
            displayLuckyNumbers();
            resetGame();
        }
    }

    // if doYouWishToCont = true, loop through Questions, display to user, assign input to answer variable/
    // when the user answers questions 3,4,5,6, or 8 function checks if input is an integer-
    // if yes: add answer to answers Array // if no: Catch exception - "Please enter valid number" ,
    // questionNum and i are decremented and loop is broken with continue -- will not add item  to answersArray unless
    // it is an integer
    private static void askQuestions(){
        if(doYouWishToCont(answer)) {
            for (int i = 0; i <= questions.length; i++) {
                questionIterator();
                answer = input.nextLine();
                if (questionNum == 3 || questionNum == 4 || questionNum == 5 || questionNum == 6 || questionNum == 8){
                    try {
                        Integer.parseInt(answer);
                    } catch (Exception e){
                        System.out.println("Please enter a valid number");
                        questionNum--;
                        i--;
                        continue;
                    }
                }
                answers.add(answer);
            }
        } else {
            closeProgram();
        }
    }

    // returns random integer between 1 and 10
    private static int randomNum() {
        return (int)(Math.random() * 10);
    }

    // returns int : multiplies 4th answer by a random number / if the magicBallNum is greater than max-
    // will subtract Max until it is less
    private static int magicBall() {
        int magicBallNum = randomNum() * Integer.parseInt(answers.get(4));
        while (magicBallNum > magicBallNumMax) {
            magicBallNum = magicBallNum - magicBallNumMax;
        }
        return magicBallNum;
    }

    //returns String : creates 5 random numbers based on user answers and returns in a String List separated by commas
    private static String lottoNumbers() {
        String numList = "";
        int num1, num2, num3, num4, num5;
        // Answer 3 + answer 6
        num1 = Integer.parseInt(answers.get(3)) + Integer.parseInt(answers.get(6));
        // answer 2 + answer 6
        num2 = Integer.parseInt(answers.get(2)) + Integer.parseInt(answers.get(4));
        // random number * answer 6
        num3 = randomNum() * Integer.parseInt(answers.get(6));
        // random number * answer 1
        num4 = randomNum() * Integer.parseInt(answers.get(1));
        // answer 2 * answer 2
        num5 = Integer.parseInt(answers.get(2)) * Integer.parseInt(answers.get(2));
        ArrayList<Integer> lottoNumbs = new ArrayList<>();
        lottoNumbs.add(num1);
        lottoNumbs.add(num2);
        lottoNumbs.add(num3);
        lottoNumbs.add(num4);
        lottoNumbs.add(num5);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int num : lottoNumbs) {
            while (num > lotteryNumMax) {
                num = num - lotteryNumMax;
            }
            numbers.add(num);
            numList = numbers.toString().replace("["," ").replace("]"," ");
        }
        return numList;
    }

    // Main argument: playGame()
    public static void main (String[] arg){

        System.out.println("Hello World!");

        AsciiChars.printNumbers();
        AsciiChars.printUpperCase();
        AsciiChars.printLowerCase();

        playGame();
    }
}
