import dao.DAO;
import model.Answer;
import model.Player;
import model.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Esta clase contiene los metodos para mostrar el texto de la interfaz del juego
 */
public class GameCommanlineInt {
    public static final Logger log = Logger.getLogger(String.valueOf(GameCommanlineInt.class));

    /**
     * Metodo que muestra el menu principal del juego
     * @throws IOException posible error al conectar con la base de datos
     */
    public static void gameInit() throws IOException {
        GameLogic game = new GameLogic();
        Scanner scan = new Scanner(System.in);
        log.info("¿Quien quiere ser millonario?" +
                "\n1. Jugar!" +
                "\n2. Ver puntajes" +
                "\nElige una opcion:" +
                "\n>");
        Integer respuesta = Integer.valueOf(scan.nextInt());

        if (respuesta == 1) {
            game.nextQuestion(0);
        } else {
            highScores();
        }
    }

    /**
     * Metodo que muestra em pantalla la pregunta seleccionada y su respuestas asociadas, pide elegir
     * una respuesta y manda a validarla
     * @param contentQA tipo ArrayList<Question> contiene las preguntas de la ronda actual
     * @param round tipo Integer representa la ronda actual
     * @throws IOException posible error al conectar con la base de datos
     */
    public static void gameInterface(ArrayList<Question> contentQA, Integer round) throws IOException {
        Collections.shuffle(contentQA);
        Question myQuestion = contentQA.get(0);
        myQuestion.loadAnswer();
        ArrayList<Answer> answers = myQuestion.getAnswers();
        Collections.shuffle(answers);
        Scanner scan = new Scanner(System.in);
        GameLogic game = new GameLogic(round);
        log.info(myQuestion.getText() +
                "\n1." + answers.get(0).getText() +
                "\n2." + answers.get(1).getText() +
                "\n3." + answers.get(2).getText() +
                "\n4." + answers.get(3).getText() +
                "\n0. Si deseas retirarte");
        Integer respuesta = Integer.valueOf(scan.nextInt());

        game.gameAnswerValidator(respuesta, myQuestion);
    }

    /**
     * Metodo que muestra en pantalla el menu de Game Over y regresa al jugadro al menu principal
     * @throws IOException  posible error al conectar con la base de datos al reiniciar el juego
     */
    public static void gameOverInterface() throws IOException {
        log.info("has perdido, intenta nuevamente ");
        GameLogic gameState = new GameLogic();
        gameState.setRound(0);
        gameInit();
    }

    /**
     * Metodo que muestra en pantalla los puntajes de los juegadores alamcenados en la base de datos
     */
    public static void highScores() {
        log.info("Puntajes maximos!");
        DAO dao = new DAO();
        ArrayList<Player> players = dao.readPlayers();

        for (int i = 0; i < players.size(); i++) {
            log.info("id: " + players.get(i).getId() + " | Nombre: " + players.get(i).getName() + " | Puntos: " + players.get(i).getScore());
        }
    }
}
