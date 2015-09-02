package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
public class Answer implements Serializable{

	@Id
    @GeneratedValue
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "correctness")
    private boolean correctness;

    @Column(name = "answer")
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public boolean isCorrectness() {
        return correctness;
    }

    public void setCorrectness(boolean trueOrFalse) {
        this.correctness = trueOrFalse;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
