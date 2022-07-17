import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class GameCommanlineInt {
    public static final Logger log = Logger.getLogger(String.valueOf(GameCommanlineInt.class));

    public static void gameInit()  {
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

    public static void gameInterface(ArrayList<String> constentQA){
        Scanner scan = new Scanner(System.in);
        GameLogic game = new GameLogic();
        log.info(constentQA.get(0) +
                "\n1." + constentQA.get(1) +
                "\n2." + constentQA.get(2) +
                "\n3." + constentQA.get(3) +
                "\n4." + constentQA.get(4));
        Integer respuesta = Integer.valueOf(scan.nextInt());

        game.gameAnswerValidator(respuesta);

    }

    public static void gameOverInterface(){
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
