import java.util.Scanner;
public class Main {

    //main function
    public static void main(String[] args){

        //calling function
        new Main().startup();
    }

    private void startup(){

        //scanner to get input
        Scanner scanner = new Scanner(System.in);

        System.out.println("The player will get only 5 turns to guess a word. Good luck.");

        //using loop if user want to play game again
        while(true) {
            new PlayComputer();  //calling constructor

            System.out.print("Enter 'Y' to play again: ");
            char choice = scanner.next().charAt(0);  //getting char

            //if char is 'y' the loop will continue
            if (choice == 'y'|| choice == 'Y'){
                 continue;
            }

            //breaking loop if char is not 'y'
            else{
                System.out.println();  //leaving a line
                System.out.println("Thanks for playing");
                break;
            }
        }
    }
}
