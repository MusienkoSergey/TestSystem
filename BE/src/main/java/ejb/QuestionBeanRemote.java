package ejb;

import entity.Question;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface QuestionBeanRemote {
    List<Question> getQuestions();
}
