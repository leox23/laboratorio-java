package interfaces;

import model.Answer;
import model.Player;
import model.Question;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface de definicion de los metodos de interaccion con la base de datos.
 */
public interface Idao {
    ArrayList<Player> readPlayers() throws IOException;

    void createPlayer(Player player) throws IOException;

    ArrayList<Question> readQuestions(Integer round) throws IOException;

    ArrayList<Answer> readAnswers(Integer idQuestion) throws IOException;

}
