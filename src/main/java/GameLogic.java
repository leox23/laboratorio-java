
import dao.DAO;
import model.Player;
import model.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class GameLogic {

    public static final Logger log = Logger.getLogger(String.valueOf(GameCommanlineInt.class));

    private Integer round;
    private String playerName;
    private Integer points;

    public GameLogic() {
        this.round = 0;
        this.playerName = null;
        this.points = 0;
    }

    public GameLogic(Integer round) {
        this.round = round;
        this.playerName = null;
        this.points = 0;
    }

    public void gameAnswerValidator(Integer answer, Question myQuestion) throws IOException {
        GameCommanlineInt gameInterface = new GameCommanlineInt();

        if(answer==0){
            if(this.round == 0){
                gameInterface.gameInit();
            }else{
                victory("Tu puntaje fue de: ");
            }
        }else {

            Integer respuestaCorrecta = myQuestion.getAnswers().get(answer - 1).getIsRight();
            if (respuestaCorrecta == 1) {
                log.info("Su respuesta es correcta!");

                this.round++;
                if (this.round == 4) {
                    victory("Has respondido todas las preguntas! tu puntaje es: ");
                } else {
                    nextQuestion(this.round);
                }
            } else {
                gameInterface.gameOverInterface();
            }
        }
    }

    private void victory(String message) {
        DAO dao = new DAO();
        GameCommanlineInt game = new GameCommanlineInt();
        Player playerObj;
        Scanner scan = new Scanner(System.in);

        Integer playerPoints = getFinalPoints(this.round);
        log.info(message + playerPoints.toString() + "pts");
        log.info("Denos su nombre para registrar su puntaje:" +
                ">");
        playerName = scan.nextLine();

        playerObj = new Player(playerName, playerPoints);

        dao.createPlayer(playerObj);

        //Thread.sleep(200); todo pendiente espera por si en realidad es necesario para que de tiempo de guardar en DB
        game.highScores();
    }

    private Integer getFinalPoints(Integer round) {
        return Integer.valueOf((int) Math.pow(100, round));
    }

    public static void nextQuestion(Integer round) throws IOException {
        DAO myDAO = new DAO();
        GameCommanlineInt gameInterface = new GameCommanlineInt();
        ArrayList<Question> contentQA = myDAO.readQuestions(round);
        gameInterface.gameInterface(contentQA, round);

    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
