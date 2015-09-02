package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question implements Serializable {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int questionId;

    @Column(name = "question")
    private String question;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private Set<Answer> answers;

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
