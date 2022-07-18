package dao;

import connection.DBConnection;
import interfaces.Idao;
import model.Player;
import model.Question;
import model.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Clase que contiene todos los metodos posibles para interactuar con la base de datos.
 */
public class DAO implements Idao {
    private static final Connection CONNECTION = DBConnection.getConnection();
    public static final Logger log = Logger.getLogger(String.valueOf(DAO.class));

    String queryError = "Query fallido ";

    /**
     * Metodo designado a la creacion de nuevo jugador en la lista de puntajes maximos.
     *
     * @param player Tipo Player
     */
    @Override
    public void createPlayer(Player player) {
        String query = "INSERT INTO questionchallenge.player( name, score) VALUES(?,?)";
        try (PreparedStatement ps = CONNECTION.prepareStatement(query)) {
            ps.setString(1, player.getName());
            ps.setInt(2, player.getScore());
            ps.executeUpdate();
            log.info("El jugador fue guardado exitosamente");
        } catch (SQLException e) {
            log.info(queryError.concat(e.toString()));
        }
    }

    /**
     * Metodo dedicado a la lectura de todos los jugadores con sus puntajes en la base de datos.
     *
     * @return ArrayList<Player> Array de Player
     */
    @Override
    public ArrayList<Player> readPlayers() {
        ResultSet rs;
        String query = "SELECT  player.id, player.name, player.score FROM player";
        ArrayList<Player> players = new ArrayList<>();
        try (PreparedStatement ps = DAO.CONNECTION.prepareStatement(query)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer score = rs.getInt("score");
                Player player = new Player(id, name, score);
                players.add(player);
            }
        } catch (SQLException e) {
            log.info(queryError.concat(e.toString()));
        }
        return players;
    }

    /**
     * Metodo asignado a la lectura de las preguntas pertenecientes al raund que entra el jugador.
     *
     * @param round Recibe entero de el round actual del jugador.
     * @return ArrayList<Question> Devueve la lista de Question, son las preguntas y respuestas del round.
     */
    @Override
    public ArrayList<Question> readQuestions(Integer round) {
        ResultSet rs;
        String query = "SELECT  question.id, question.text, question.category FROM question WHERE question.category = ?";
        ArrayList<Question> questions = new ArrayList<>();
        try (PreparedStatement ps = DAO.CONNECTION.prepareStatement(query)) {
            ps.setInt(1, round + 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String text = rs.getString("text");
                Question myQuestion = new Question(id, text);
                questions.add(myQuestion);
            }
        } catch (SQLException e) {
            log.info(queryError.concat(e.toString()));
        }
        return questions;
    }

    /**
     *  Metodo dedicado a leer las respuestas de la pregunta seleccionada.
     * @param idQuestion El index de la pregunta seleccionada.
     * @return ArrayList<Answer> Lista de respuestas.
     */
    @Override
    public ArrayList<Answer> readAnswers(Integer idQuestion) {
        ResultSet rs;
        String query = "SELECT  answer.id, answer.text, answer.isRigth FROM question INNER JOIN answer on question.id=answer.question_id WHERE answer.question_id = ?";
        ArrayList<Answer> answers = new ArrayList<>();
        try (PreparedStatement ps = DAO.CONNECTION.prepareStatement(query)) {
            ps.setInt(1, idQuestion);
            rs = ps.executeQuery();
            while (rs.next()) {
                String text = rs.getString("text");
                Integer isRigth = rs.getInt("isRigth");
                Answer myAnswer = new Answer(text, isRigth);
                answers.add(myAnswer);
            }
        } catch (SQLException e) {
            log.info(queryError.concat(e.toString()));
        }
        return answers;
    }
}
