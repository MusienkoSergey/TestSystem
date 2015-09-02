package service;

import ejb.QuestionBeanRemote;
import entity.Answer;
import entity.Question;
import flex.messaging.FlexContext;
import flex.messaging.FlexSession;
import resultBean.Result;

import javax.ejb.EJB;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class QuestionService {

    @EJB
    private QuestionBeanRemote questionBean;
    private static final int AMOUNT_QUESTION = 5;
    private FlexSession session;

    public Question startTest() {
        List<Question> questions = getRandomQuestions(AMOUNT_QUESTION);
        cacheQuestions(getRandomQuestions(AMOUNT_QUESTION));
        return questions.get(0);
    }

    @SuppressWarnings("unchecked")
    public Question getNextQuestion(int answerId) {
        session = FlexContext.getFlexSession();
        List<Question> questionList = (List<Question>) session.getAttribute("randomQuestion");
        Result result = (Result) session.getAttribute("result");
        saveResult(answerId, questionList, result);
        return nextQuestion(result, questionList);
    }

    public String getResult() {
        Result result = (Result) FlexContext.getFlexSession().getAttribute("result");
        return "You answered correctly on " + result.getAmountRightAnswers() + " of " + result.getAmountQuestions() + " questions";
    }

    private void saveResult(int answerId, List<Question> questionList, Result result) {
        Set<Answer> answers = questionList.get(result.getNumberCurrentQuestion()).getAnswers();
        for (Answer answer : answers) {
            if (answer.getAnswerId() == answerId) {
                if (answer.isCorrectness()) {
                    result.incrementRightAnswer();
                }
            }
        }
    }

    private Question nextQuestion(Result result, List<Question> questionList) {
        if (result.getNumberCurrentQuestion() == questionList.size() - 1) {
            return null;
        }
        result.incrementCurrentQuestion();
        return questionList.get(result.getNumberCurrentQuestion());
    }

    private List<Question> getRandomQuestions(int amount) {
        List<Question> list = questionBean.getQuestions();
        Collections.shuffle(list);
        return list.subList(0, amount);
    }

    private void cacheQuestions(List<Question> questions) {
        session = FlexContext.getFlexSession();
        session.setAttribute("randomQuestion", questions);
        session.setAttribute("result", new Result(AMOUNT_QUESTION));
    }
}