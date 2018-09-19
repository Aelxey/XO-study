import io.study.xo.model.Field;
import io.study.xo.model.Figure;
import io.study.xo.model.Game;
import io.study.xo.model.Player;
import io.study.xo.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Alex";
        final String name2 = "Boss";
        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        final Game gameXO = new Game(players, new Field(3), "XO");
        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(gameXO);

        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }

    }
}
