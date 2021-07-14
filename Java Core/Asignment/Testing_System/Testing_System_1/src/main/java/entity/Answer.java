package entity;

public class Answer {
    private int answerID;
    private String content;
    private String questionID;
    private boolean isCorrect;

    public Answer(){}

    public Answer(int answerID, String content, String questionID, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.questionID = questionID;
        this.isCorrect = isCorrect;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", content='" + content + '\'' +
                ", questionID='" + questionID + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
