import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;

class PlayComputer{

    //scanner to get input
    Scanner scanner = new Scanner(System.in);

    //arraylist to store word list
    ArrayList<String> wordList = new ArrayList<>();

    //arraylist to store user entered characters;
    ArrayList<Character> userCharacters = new ArrayList<>();

    //checking incorrect guesses
    int incorrect = 0;

    //checking correct guesses
    int correct = 0;

    //defining constructor
    PlayComputer(){

        //reading words from text file and adding them to arraylist
        addWordList();

        //selecting random word from Arraylist
        String randomWord = selectWord();

        while(true) {

            //if wrong guesses are lesser than 5
            if(incorrect < 5) {

                System.out.println("Remaining Moves: "+( 5 - incorrect));
                printWord(randomWord);  //displaying word

                //finishing the game once the whole word is guesses
                if(correct != randomWord.length()) {

                    //getting user input
                    char userEnteredChar = userInput();

                    //storing user input in an array list
                    userCharacters.add(userEnteredChar);

                    //calling function
                    wrongCount(randomWord, userEnteredChar);
                }
                else{  //if the user made all guesses right
                    System.out.println();
                    System.out.println("You Won");
                    break;
                }
            }

            //if incorrect answers are more than 5 or equals to 5
            else{
                System.out.println();
                System.out.println("Out of moves");
                System.out.println("The Word Is: "+randomWord);
                break;
            }
        }
    }

    private void addWordList(){

        try {
            //using scanner to read the file
            Scanner readFile = new Scanner(new File("D:\\MyJava\\WordGuesser\\WordList.txt"));

            while(readFile.hasNext()){

                //storing words in an arraylist
                wordList.add(readFile.nextLine());
            }

            readFile.close();

            //catching exception
        }catch (Exception e){
            System.out.println("An Error Occurred");
        }
    }

    private String selectWord(){
        Random rand = new Random();  //object of random class

        //choosing random word from array list
        return (wordList.get(rand.nextInt(wordList.size())));
    }

    private char userInput(){

        System.out.println();  //leaving a line

        System.out.print("Enter Your Input: ");
        return scanner.next().charAt(0);  //prompting user to enter a char
    }

    private void printWord(String word){
        correct = 0;

        //using for loop to display the randomly chosen word
        for(int x =0; x<word.length();x++){
            if(userCharacters.contains(word.charAt(x))){

                //if the user made right guess the character will be shown
                System.out.print(word.charAt(x));
                correct++;
            }
            //printing dashes
            else{
                System.out.print(" - ");
            }
        }

    }

    //calculating wrong guesses
    private void wrongCount(String word, char userInput){
        if(!(word.indexOf(userInput) > 0)){
            incorrect++;
        }
    }

}