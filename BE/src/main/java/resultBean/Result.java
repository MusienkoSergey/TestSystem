package resultBean;

import java.io.Serializable;

public class Result implements Serializable{
	
    private final int amountQuestions;
    private int amountRightAnswers;
    private int numberCurrentQuestion;

    public Result(int amountQuestion) {
        this.amountQuestions = amountQuestion;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public int getAmountRightAnswers() {
        return amountRightAnswers;
    }

    public void incrementRightAnswer() {
        amountRightAnswers++;
    }

    public int getNumberCurrentQuestion() {
        return numberCurrentQuestion;
    }

    public void incrementCurrentQuestion() {
        if (numberCurrentQuestion < amountQuestions) {
            numberCurrentQuestion++;
        }
    }
}
