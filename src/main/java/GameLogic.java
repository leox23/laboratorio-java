
import dao.DAO;
import model.Player;
import model.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Esta clase contiene los metodos que establecen las reglas del juego
 */
public class GameLogic {

    public static final Logger log = Logger.getLogger(String.valueOf(GameCommanlineInt.class));

    private Integer round;

    public GameLogic() {
        this.round = 0;
    }

    public GameLogic(Integer round) {
        this.round = round;
    }

    /**
     * Este metodo valida si la respuesta seleccionada es la correcta o si el jugador desea retirarse
     * del juego
     * @param answer tipo Integer que representa la respuesta seleccionada
     * @param myQuestion tipo Question que representa la pregunta de la ronda actual
     * @throws IOException  posible error al conectar con la base de datos
     */
    public void gameAnswerValidator(Integer answer, Question myQuestion) throws IOException {
        if(answer==0){
            if (this.round == 0){
                GameCommanlineInt.gameInit();
            } else {
                victory("Tu puntaje fue de: ");
            }
        } else {
            Integer respuestaCorrecta = myQuestion.getAnswers().get(answer - 1).getIsRight();
            if (respuestaCorrecta == 1) {
                log.info("Su respuesta es correcta!");
                this.round++;
                if (this.round == 5) {
                    victory("Has respondido todas las preguntas! tu puntaje es: ");
                } else {
                    nextQuestion(this.round);
                }
            } else {
                GameCommanlineInt.gameOverInterface();
            }
        }
    }

    /**
     * Este metodo permite guardar el puntaje y nombre del jugador actual en la base de datos y mostrar los
     * puntajes de los otros jugadores
     * @param message tipo String que representa el mensaje a mostrar en pantalla dependiendo de si llego a la
     *                ultima ronda o si se retiro en medio de alguna.
     */
    private void victory(String message) {
        DAO dao = new DAO();
        Player playerObj;
        Scanner scan = new Scanner(System.in);

        Integer playerPoints = getFinalPoints(this.round);
        String stringResult =  message.concat(playerPoints.toString()).concat("pts");
        log.info(stringResult);
        log.info("Denos su nombre para registrar su puntaje:" +
                ">");
        String playerName = scan.nextLine();

        playerObj = new Player(playerName, playerPoints);

        dao.createPlayer(playerObj);

        GameCommanlineInt.highScores();
    }

    /**
     * Este metodo calcula el puntaje obtenido en cada ronda
     * @param round tipo Integer que representa la ronda actual
     * @return un Integer que represeta el puntaje obtenido en la ronda
     */
    private Integer getFinalPoints(Integer round) {
        return (int) Math.pow(10, round);
    }

    /**
     * Este metodo carga las preguntas de la siguente ronda desde la base datos
     * @param round tipo Integer que representa la ronda a la que se quiere continuar
     * @throws IOException  posible error al conectar con la base de datos
     */
    public static void nextQuestion(Integer round) throws IOException {
        DAO myDAO = new DAO();
        ArrayList<Question> contentQA = myDAO.readQuestions(round);
        GameCommanlineInt.gameInterface(contentQA, round);

    }

    /**
     * Este metodo permite actualizar la ronda en la que esta el jugador
     * @param round tipo Integer que representa la ronda
     */
    public void setRound(Integer round) {
        this.round = round;
    }
}
