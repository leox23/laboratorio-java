import model.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

public class GameCommanlineInt {
    public static final Logger log = Logger.getLogger(String.valueOf(GameCommanlineInt.class));

    public static void gameInit() throws IOException {
        GameLogic game = new GameLogic();
        Scanner scan = new Scanner(System.in);
        log.info("¿Quien quiere ser millonario?" +
                "\n1. Jugar!" +
                "\n2. Ver puntajes" +
                "\nElige una opcion:" +
                "\n>");
        Integer respuesta = Integer.valueOf(scan.nextInt());

        if (respuesta == 1){
            game.nextQuestion(0);
        } else {
            highScores();
        }
    }

    public static void gameInterface(ArrayList<Question> constentQA) throws IOException {
        Collections.shuffle(constentQA);
        Question myQuestion = constentQA.get(0);
        myQuestion.loadAnswer();
        Scanner scan = new Scanner(System.in);
        GameLogic game = new GameLogic();
        log.info(myQuestion.getText() +
                "\n1." + myQuestion.getAnswers().get(0).getText() +
                "\n2." + myQuestion.getAnswers().get(1).getText()  +
                "\n3." + myQuestion.getAnswers().get(2).getText()  +
                "\n4." + myQuestion.getAnswers().get(3).getText() );
        Integer respuesta = Integer.valueOf(scan.nextInt());

        game.gameAnswerValidator(respuesta);

    }

    public static void gameOverInterface() throws IOException {
        log.info("has perdido, intenta nuevamente ");
        GameLogic gameState = new GameLogic();
        gameState.setRound(0);
        gameInit();
    }

    public static void highScores() {
        log.info("Puntajes maximos!");
        // todo pendiente lista con resultados
    }
}
