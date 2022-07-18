package app;

import dao.DAO;
import model.Answer;
import model.Player;
import model.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        Scanner scan = new Scanner(System.in);
        log.info("""
                ¿Quien quiere ser millonario?
                1. Jugar!
                2. Ver puntajes
                Elige una opcion:
                >
                """);
        Integer respuesta = scan.nextInt();

        if (respuesta == 1) {
            GameLogic.nextQuestion(0);
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
    public static void gameInterface(List<Question> contentQA, Integer round) throws IOException {
        Collections.shuffle(contentQA);
        Scanner scan = new Scanner(System.in);
        GameLogic game = new GameLogic(round);
        Question myQuestion = contentQA.get(0);
        myQuestion.loadAnswer();
        List<Answer> answers = myQuestion.getAnswers();
        Collections.shuffle(answers);
        log.info(myQuestion.getText() +
                "\n1." + answers.get(0).getText() +
                "\n2." + answers.get(1).getText() +
                "\n3." + answers.get(2).getText() +
                "\n4." + answers.get(3).getText() +
                "\n0. Si deseas retirarte");
        Integer respuesta = scan.nextInt();

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
        Scanner scan = new Scanner(System.in);
        log.info("Puntajes maximos!");
        DAO dao = new DAO();
        ArrayList<Player> players = dao.readPlayers();

        for (Player player : players) {
            log.info("id: " + player.getId() + " | Nombre: " + player.getName() + " | Puntos: " + player.getScore());
        }
        log.info("""
                Deseas ir al menu principal?
                1. Si  |  Cualquier otro numero para salir del juego.
                """);
        Integer response = Integer.valueOf(scan.nextLine());
        if(response == 1){
            try {
                gameInit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
