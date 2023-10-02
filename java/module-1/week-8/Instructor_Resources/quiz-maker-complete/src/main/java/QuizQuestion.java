public class QuizQuestion {
    private String question;
    private String[] answers;
    private String correctAnswer;

    public QuizQuestion (String lineOfText){
        String[] questionParts = lineOfText.split("\\|");
        this.answers = new String[questionParts.length - 1];
        this.question = questionParts[0];
        for (int i = 1; i < questionParts.length; i++){
            String answer = questionParts[i];
            if (answer.endsWith("*")){
                answer = answer.substring(0, answer.length() - 1); // remote asterisk
                this.correctAnswer = answer;
            }
            this.answers[i - 1] = answer;
        }
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers.clone(); // a copy so original can't be modified.
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrectAnswer (String answer) {
        return this.correctAnswer.equals(answer);
    }
}
