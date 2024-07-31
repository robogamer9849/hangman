package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Controller {


    private String answer;
    private char[] word;
    private char[] hiddenWord;
    private int guessed = 0;
    private int hasToGuess;
    private int chars;

    private Stage stage;

    @FXML
    public Label co;
    @FXML
    public Label lb2;
    @FXML
    Button btn;
    @FXML
    private TextField tf;
    @FXML
    public Label lb;

    public Controller(Stage stage) {
        this.stage = stage;
    }
    public Controller() {
    }


    public void close (){
        if (stage != null) {
            stage.close();
        }
        System.exit(0);
    }
    @FXML
    public void check() throws InterruptedException {
        lb2.setText("guess");
        String guess = tf.getText().toLowerCase();
        tf.clear(); // Clear the guess field after each attempt

        if (answer.contains(guess)) {
            lb2.setText("right!");
            guessed++;
            System.out.println(guessed);
            for (int i = 0; i < word.length; i++) {
                if (word[i] == guess.charAt(0)) {
                    hiddenWord[i] = guess.charAt(0);
                }
            }
        }
        else {
            lb2.setText("wrong!");
        }

        updateHiddenWordLabel(hiddenWord);
        co.setText(guessed + "/" + chars);

        if (guessed >= hasToGuess) {
            lb2.setText("you won!");
            Timeline timer = new Timeline();
            KeyFrame keyFrame = new KeyFrame(
                    Duration.millis(500),
                    ae -> close()
            );
            timer.getKeyFrames().add(keyFrame);
            timer.play();
        }
    }

    private void updateHiddenWordLabel(char[] hiddenWord) {
        String displayedWord = new String(hiddenWord);
        lb.setText(displayedWord);
    }
    @FXML
    private void start() {
        ChooseWord wordGet = new ChooseWord();
        answer = wordGet.getWord().toLowerCase();
        word = answer.toCharArray();
        hasToGuess = new counter().countUniqueChars(answer);
        chars = hasToGuess;
        System.out.println("answer is " + answer);
        lb2.setText("");
        co.setText("you have to guess " + chars + " characters");

        hiddenWord = answer.toCharArray();
        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord[i] != ' ') {
                hiddenWord[i] = '_';
            }
        }

        guessed = 0;
        updateHiddenWordLabel(hiddenWord);
    }

    public void initialize() {
        start();
    }


}