package entity;

public class Answer {
    int answerID;
    String content;
    int[] questions;
    boolean isCorrect;

    public Answer() {
    }

    public Answer(int answerID, String content, int[] questions, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.questions = questions;
        this.isCorrect = isCorrect;
    }
}
