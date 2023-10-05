import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        QuizMaker quizMaker = new QuizMaker();
        quizMaker.run();
    }

    public void run(){
        File inputFile = null;

        do {
            System.out.print("Where is the quiz file? ");
            String path = userInput.nextLine();
            inputFile = new File (path);

            if(!inputFile.exists()){
                System.out.println("The file doesn't exist");
                inputFile = null;
            } else if(!inputFile.isFile()) {
                System.out.println(path + " is not a file");
                inputFile = null;
            }
        } while (inputFile == null);

        List<QuizQuestion> quizQuestions = new ArrayList<>();

        try(Scanner fileScanner = new Scanner (inputFile)){
            while (fileScanner.hasNext()){
                String lineOfText = fileScanner.nextLine();
                QuizQuestion question = new QuizQuestion(lineOfText);
                quizQuestions.add(question);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        int questionsAsked = 0;
        int numberCorrect = 0;

        for (QuizQuestion quizQuestion : quizQuestions) {
            questionsAsked++;
            System.out.print("\nQuestion #" + questionsAsked + ": ");
            System.out.println(quizQuestion.getQuestion());

            // print possible  answer
            for (String possibleAnswer : quizQuestion.getAnswers()){
                System.out.println(possibleAnswer);
            }

            System.out.println("Your answer: ");
            String userAnswer = userInput.nextLine();

            if (quizQuestion.isCorrectAnswer(userAnswer)){
                System.out.println("CORRECT!");
                numberCorrect++;
            } else {
                System.out.println("WRONG!");
            }

            System.out.println("You got " + numberCorrect + " correct out of " + questionsAsked);

        }


    }



}
