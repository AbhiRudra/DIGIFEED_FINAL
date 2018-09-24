package create_survey;

import java.util.List;

public class Question {


   String questiontype_id;

   String question;
   List<String> subquestions;
   List<String> suboptions;


    public String getQuestiontype_id() {
        return questiontype_id;
    }

    public void setQuestiontype_id(String questiontype_id) {
        this.questiontype_id = questiontype_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getSubquestions() {
        return subquestions;
    }

    public void setSubquestions(List<String> subquestions) {
        this.subquestions = subquestions;
    }

    public List<String> getSuboptions() {
        return suboptions;
    }

    public void setSuboptions(List<String> suboptions) {
        this.suboptions = suboptions;
    }
}
