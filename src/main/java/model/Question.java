package model;

import dao.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase tipo Question, contiene atributos de id, el round actual, el texto de la pregunta, y el listadeo de respuestas.
 */
public class Question {
    private final Integer id;
    private final String text;
    private ArrayList<Answer> answers;

    public Question(Integer id, String text) {
        this.id = id;
        this.text = text;
        this.answers = new ArrayList<>();
    }

    public void loadAnswer(){
        DAO myDAO = new DAO();
        this.answers = myDAO.readAnswers(this.id);
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
