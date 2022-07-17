package model;

import dao.DAO;

import java.io.IOException;
import java.util.ArrayList;

public class Question {
    private Integer  id;
    private Integer round;
    private String text;
    private ArrayList<Answer> answers;

    public Question(Integer id, Integer round, String text) {
        this.id = id;
        this.round = round;
        this.text = text;
        this.answers = new ArrayList<Answer>();
    }

    public Question() {

    }

    public void loadAnswer() throws IOException {
        DAO myDAO = new DAO();
        this.answers = myDAO.readAnswers(this.id);
    }

    public String getText() {
        return text;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
