import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {
		/* Your code goes here */
		try (userInput){
			// get correct path
			File inputFile = null;

			do {
				System.out.print("Where is the quiz file? ");
				String path = userInput.nextLine(); // test_quiz.txt
				System.out.println(); // added line break
				// Validate the input file
				inputFile = new File (path);

				if (!inputFile.exists()){
					System.out.println("The file doesn't exist");
					inputFile = null;
				} else if (!inputFile.isFile()){
					System.out.println(path + " is not a file");
					inputFile = null;
				}
			} while (inputFile == null);

			List<QuizQuestion> quizQuestions = new ArrayList<>();

			// Read through the input file and pull out each line
			try (Scanner fileScanner = new Scanner(inputFile)){
				while (fileScanner.hasNextLine()) {
					String lineOfText = fileScanner.nextLine();
					QuizQuestion question = new QuizQuestion(lineOfText);
					quizQuestions.add(question);
				}

			} catch (FileNotFoundException e) {
				e.getMessage();
			}

			// Deliver the quiz by displaying the questions along with
			// their possible answers one question at a time. Keep track
			// of the number of questions asked, and the number of correct answers.
			int questionsAsked = 0;
			int numberCorrect = 0;

			for (QuizQuestion quizQuestion : quizQuestions) {
				questionsAsked++;
				System.out.print("\nQuestion #" + questionsAsked + ": ");
				System.out.println(quizQuestion.getQuestion());

				// print possible answers
				String[] possibleAnswers = quizQuestion.getAnswers();
				for (String possibleAnswer : possibleAnswers) {
					System.out.println(possibleAnswer);
				}

				System.out.print("Your answer: ");
				String userAnswer = userInput.nextLine();
				if (quizQuestion.isCorrectAnswer(userAnswer)){
					System.out.println("Correct!");
					numberCorrect++;
				} else {
					System.out.println("Incorrect");
				}
			}
			System.out.println("You got " + numberCorrect + " correct out of " + questionsAsked + " questions asked");
		} // end try





	}

}
