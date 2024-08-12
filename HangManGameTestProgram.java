import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//N.k Nkidi 45979278
/**
 * Write a description of class HangManGameTestProgram here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HangManGameTestProgram
{
    public static void main(String[] args) {
        MyArrayList<String> listOfWords = new MyArrayList<>();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"))) {
            String word;
            //Initializing Index to 0
            int index = 0; 
            while ((word = bufferedReader.readLine()) != null) {
                //Adding a word on the list of words as reading the file
                listOfWords.add(index++, word); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Generation of random
        Random random = new Random();
        String wordSelected = listOfWords.get(random.nextInt(listOfWords.size()));
        MyArrayList<characterWrapperClass> listOfCharacters = loadWord(wordSelected);

        //Allow player to play game
        playGame(listOfCharacters);
    }

    //Loaad word method
    public static MyArrayList<characterWrapperClass> loadWord(String word) {
        MyArrayList<characterWrapperClass> chararaterList = new MyArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            chararaterList.add(i, new characterWrapperClass(word.charAt(i)));
        }
        return chararaterList;
    }

    //Methof to allow player to play Game
    public static void playGame(MyArrayList<characterWrapperClass> listOfCharacters) {
        Scanner scanner = new Scanner(System.in);
        
        //Setting the isGameRunning to true until proven false
        boolean isGameRunning = true;

        while (isGameRunning) {
            //Displaying the word to guess dashes
            System.out.println("Word to guess: " + listOfCharacters);

            // Prompt the user for a letter
            System.out.print("Enter a letter to guess (or type 'quit' to stop): ");
            String input = scanner.nextLine();

            //If user wants to quit game
            if (input == "quit") {
                isGameRunning = false;
            } else if (input.length() == 1) {
                char letterGuessed = input.charAt(0);
                letterGuessed(listOfCharacters, letterGuessed);
                System.out.println("Word after guessing '" + letterGuessed + "': " + listOfCharacters);

                //If word guessed is true then diplayal is put then game ends
                if (isWordGuessed(listOfCharacters)) {
                    System.out.println("Congratulations! You have successfully gueessed the word " + listOfCharacters);
                    isGameRunning = false;
                }
            } else {
                //If a single letter is not inputed , then displayal of message
                System.out.println("Please enter a single letter.");
            }
        }
        
        scanner.close();
    }

    //Method Guess letter
    public static void letterGuessed(MyArrayList<characterWrapperClass> charList, char guess) {
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i).getCharacter() == guess) {
                charList.get(i).setGuessed(true);
            }
        }
    }

    //Method to check if word is fully guessed
    public static boolean isWordGuessed(MyArrayList<characterWrapperClass> charList) {
        for (int i = 0; i < charList.size(); i++) {
            if (!charList.get(i).isGuessed()) {
                return false;
            }
        }
        return true;
    }
}

        
        
        
        
    
    

