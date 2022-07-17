
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

    public void gameAnswerValidator(Integer answer)  {
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

    public static void nextQuestion(Integer round) {
        GameCommanlineInt gameInterface = new GameCommanlineInt();
        ArrayList<String> contentQA = new ArrayList<String>();
        //todo lore, en espera de la base de datos
        contentQA.add("pregunta lorm");
        contentQA.add("Lorem 1");
        contentQA.add("Lorem 2");
        contentQA.add("Lorem 3");
        contentQA.add("Lorem 4");

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
