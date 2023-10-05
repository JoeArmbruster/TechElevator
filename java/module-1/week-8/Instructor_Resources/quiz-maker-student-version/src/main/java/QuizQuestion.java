import java.util.List;

public class QuizQuestion {

    private String question;
    private String[] answers;
    private String correctAnswer;

    public QuizQuestion (String lineOfText){
    String[] questionParts = lineOfText.split("\\|");
    this.question = questionParts[0];
    this.answers = new String[questionParts.length - 1];

    for (int i = 1; i < questionParts.length; i++){
        String answer = questionParts[i];
        if (answer.endsWith("*")){
            this.correctAnswer = answer.substring(0, answer.length() - 1); // removes asterisk
        } else {
            this.answers[i - 1] = answer;
        }
        }
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers.clone(); // a copy so original can't be modified
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrectAnswer(String answer){
        return this.correctAnswer.equals(answer);
    }

    @Override
    public String toString(){
        String questionInfo = "";
        questionInfo += "Question: " + question;
        questionInfo += "\nPossible answers: ";
        for (String answer : answers) {
            questionInfo += "\n" + answer;
        }
        questionInfo += "\nCorrect answer: " + correctAnswer;

        return questionInfo;
    }

}
