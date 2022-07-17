
import dao.DAO;
import model.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class GameLogic {

    public static final Logger log = Logger.getLogger(String.valueOf(GameCommanlineInt.class));

    private Integer round;
    private String playerName;
    private Integer points;

    public GameLogic(){
        this.round = 0;
        this.playerName = null;
        this.points = 0;
    }

    public void gameAnswerValidator(Integer answer) throws IOException {
        GameCommanlineInt gameInterface = new GameCommanlineInt();
        //todo data lorem mientra se espera DB
        Integer respuestaCorrecta = 2;

        if (answer == respuestaCorrecta){
            log.info("la respuesta es correcta");
            this.round++;
            nextQuestion(this.round);
        } else {
            gameInterface.gameOverInterface();
        }


    }

    public static void nextQuestion(Integer round) throws IOException {
        DAO myDAO = new DAO();
        GameCommanlineInt gameInterface = new GameCommanlineInt();
        ArrayList<Question> contentQA = myDAO.readQuestions(round);
        gameInterface.gameInterface(contentQA);

    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }




}
