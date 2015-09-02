package ejb;

import entity.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class QuestionBean implements QuestionBeanRemote{

	@PersistenceContext
	EntityManager em;

    public List<Question> getQuestions() {
        return em.createQuery("From Question").getResultList();
    }
}
