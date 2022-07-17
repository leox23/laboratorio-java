package interfaces;

import model.Answer;
import model.Question;

import java.io.IOException;
import java.util.ArrayList;

public interface Idao {
    //void updatePlayer();
    //void createPlayer(Player player) throws IOException;
    //void readPlayer(String name) throws IOException;
    ArrayList<Question> readQuestions(Integer round) throws IOException ;
    ArrayList<Answer> readAnswers(Integer idQuestion) throws IOException ;


}
