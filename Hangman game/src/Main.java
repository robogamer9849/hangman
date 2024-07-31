import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChooseWord wordGet = new ChooseWord();
        counter counter = new counter();
        Scanner input = new Scanner(System.in);
        int guessed = 0;
        String answer = wordGet.getWord().toLowerCase();
        char[] word = answer.toCharArray();
        int hasToGuess = counter.countUniqueChars(answer);

        //make hidden word
        char[] hiddenWord = answer.toCharArray();
        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord[i] != ' ') {
                hiddenWord[i] = '_';
            }
        }

        while (guessed < hasToGuess) {
            System.out.println("");
            for (int i = 0; i < hiddenWord.length; i++) {
                System.out.print(hiddenWord[i]);
            }
            System.out.println("");


            //guess
            System.out.println("guess a character:");
            String guess = input.nextLine().toLowerCase();


            if (answer.contains(guess)) {
                guessed++;
                for (int i = 0; i < word.length; i++) {
                    if (word[i] == guess.charAt(0)) {
                        hiddenWord[i] = guess.charAt(0);
                    }
                }
            }
            else {
                System.out.println("\nIncorrect guess. Try again!");
            }
        }


        System.out.println("you won!!\n the word is: ");
        for (int i = 0; i < hiddenWord.length; i++) {
            System.out.print(hiddenWord[i]);
        }
        System.out.println("");


    }
}