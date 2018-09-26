package io.study.xo.view;

import io.study.xo.controllers.CurrrentMoveController;
import io.study.xo.controllers.MoveController;
import io.study.xo.controllers.WinnerController;
import io.study.xo.model.Field;
import io.study.xo.model.Figure;
import io.study.xo.model.Game;
import io.study.xo.model.Player;
import io.study.xo.model.exeptions.AlredyOccupiedException;
import io.study.xo.model.exeptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrrentMoveController currrentMoveController = new CurrrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {

        printPlayersName(game);

        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currentFigure = currrentMoveController.currentMove(field);
        final Figure winner = winnerController.getWinner(field);
        if (winner != null){
            System.out.format("Winner is %s", winner);
            return false;
        }
        if (currentFigure == null) {
            if (winner == null) {
                System.out.println("No winner and no moves left");
                return false;
            }
        }
        System.out.format("Please enter move for %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(point, field, currentFigure);
        } catch (AlredyOccupiedException | InvalidPointException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint(){
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName){
        System.out.format("Please input %s ", coordinateName);
        Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e){
            System.out.println("Integers ONLY!!!!!");
            return askCoordinate(coordinateName);
        }
    }

    private  void printPlayersName(final Game game){
        System.out.format("Game name: %s\n", game.getName());

        System.out.println("Players:");
        for (Player player : game){
            System.out.format("Player name: %s figure: %s\n", player.getName(), player.getFigure());
        }
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator(){
        System.out.println("~~~~~~~~~~~");
    }

}
