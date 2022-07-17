package dao;

import connection.DBConnection;
import interfaces.Idao;
import model.Player;
import model.Question;
import model.Answer;

import java.io.IOException;
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
            log.info("SQLException: " + e);
        }
    }

    /**
     * Metodo dedicado a la lectura de todos los jugadores con sus puntajes en la base de datos.
     *
     * @return ArrayList<Player> Array de Player
     */
    @Override
    public ArrayList<Player> readPlayers() {
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT  player.id, player.name, player.score FROM player";
        ArrayList<Player> players = new ArrayList<Player>();
        try {
            ps = this.CONNECTION.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer score = rs.getInt("score");
                Player player = new Player(id, name, score);
                players.add(player);
            }
            ps.close();
        } catch (SQLException e) {
            log.info("Query fallido" + e);
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
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT  question.id, question.text, question.category FROM question WHERE question.category = ?";
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            ps = this.CONNECTION.prepareStatement(query);
            ps.setInt(1, round + 1);
            rs = ps.executeQuery();
            log.info("respuesta cruda de query: " + rs);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String text = rs.getString("text");
                Integer category = rs.getInt("category");
                Question myQuestion = new Question(id, category, text);
                questions.add(myQuestion);
            }
            ps.close();
        } catch (SQLException e) {
            log.info("Query fallido" + e);
        }
        return questions;
    }

    /**
     *  Metodo dedicado a leer las respuestas de la pregunta seleccionada.
     * @param idQuestion El index de la pregunta seleccionada.
     * @return ArrayList<Answer> Lista de respuestas.
     * @throws IOException Error de falla en la lectura.
     */
    @Override
    public ArrayList<Answer> readAnswers(Integer idQuestion) throws IOException {
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT  answer.id, answer.text, answer.isRigth FROM question INNER JOIN answer on question.id=answer.question_id WHERE answer.question_id = ?";
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            ps = this.CONNECTION.prepareStatement(query);
            ps.setInt(1, idQuestion);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String text = rs.getString("text");
                Integer isRigth = rs.getInt("isRigth");
                Answer myAnswer = new Answer(id, text, isRigth);
                answers.add(myAnswer);
            }
            ps.close();
        } catch (SQLException e) {
            log.info("Query fallido" + e);
        }
        return answers;
    }
}
