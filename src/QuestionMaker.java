import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class QuestionMaker {
    private String[] pianoKeyPictures = new String[] {"C1", "D1", "E1", "F1", "G1", "A1", "B1", "C2", "D2", "E2", "F2", "G2", "A2", "B2", "C3", "D3", "E3"};
    private char[] pianoKeyAnswers = new char[] {'C' ,'D' , 'E', 'F', 'G', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'A', 'B', 'C', 'D', 'E'};
    private HashMap questions = new HashMap<String, Character>();
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private generateImage g = new generateImage();
    private Scanner s = new Scanner(System.in);

    QuestionMaker(){
        //populate the hashmap. Using hashmap in case i ever implement ability to add questions
        //i know its not used now.
        for(int i = 0; i < pianoKeyAnswers.length; i++){
            questions.put(pianoKeyPictures[i],pianoKeyAnswers[i]);
        }
    }

    public void startQuiz(){
        while(true) {
            Random rand = new Random();
            int questionNum =rand.nextInt(pianoKeyAnswers.length);
            generateQuestion(questionNum);
            getAnswer(questionNum);
            g.closeImage();
            printScore();
        }
    }

    private void generateQuestion(int questionNum){
        System.out.println("What note is shown in the picture?");
        g.showImage(pianoKeyPictures[questionNum]);
    }

    private void getAnswer(int questionNum){
        char userAnswer = s.next().charAt(0);
        char answer = pianoKeyAnswers[questionNum];
        if (Character.toUpperCase(userAnswer) == answer){
            System.out.println("Correct\n");
            correctAnswers++;
            return;
        }
        System.out.println("Incorrect\n");
        incorrectAnswers++;
    }

    private void printScore(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        float score = ((float) correctAnswers/(correctAnswers+incorrectAnswers)) * 100;
        System.out.println("Current Score = " + df.format(score) + "%");
        System.out.println("Correct = " + correctAnswers + "\nIncorrect = " + incorrectAnswers);
        System.out.println();
    }

}
