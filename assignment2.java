import java.util.Random;
import java.util.Scanner;

public class assignment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple","table","house","lemon","night","cloud","stone","music","dream","river"};
        System.out.println("Welcome to the game Wordle.");
        System.out.println("The game chooses a secret word that contains 5-letters and your job is to guess it. You only got 6 tries to guess it.");
        System.out.println("Press Enter to continue.");
        String enter = scanner.nextLine();
        System.out.println("Good luck!");
        String secretWord = picksSecretWord(words);
        int attempts=0;
        int maxAttempts=6;
        while(attempts<maxAttempts) {
            System.out.println("Please enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();
            if (guess.length() != 5) {
                System.out.println("Please enter a 5-letter word.");
            } else if (!isCorrectWord(guess, words)) {
                System.out.println("Your guess does not contain any word from the list, try again.");
            }else{
                String feedback = feedback(secretWord, guess);
                System.out.println(feedback);
                if(feedback.equals("GGGGG")) {
                    System.out.println("You guessed correctly!");
                    break;
                }
                attempts++;
            }
            if(attempts==maxAttempts) {
                System.out.println("You have used all your guesses. The secret word is "+secretWord+". Better luck next time!");
            }
        }
    }
    public static String picksSecretWord (String[] words){
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
    public static String feedback(String secretWord, String guess) {
        String feedback = "";
        for(int i=0; i<secretWord.length(); i++) {
            if(secretWord.charAt(i)==guess.charAt(i)) {
                feedback += 'G';
            }else if (isCharInSecretWord(guess.charAt(i), secretWord)) {
                feedback += 'Y';
            }else{
                feedback += '_';
            }
        }
        return feedback;
        }
    public static boolean isCharInSecretWord(char guessChar, String secretWord) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i)==guessChar) {
                return true;
            }
        }
        return false;
    }
    public static boolean isCorrectWord (String word,String[] words){
        for(int i=0;i<words.length;i++){
            if(word.equals(words[i])){
                return true;
            }
        }
        return false;
    }
}
