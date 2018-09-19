package io.study.xo.controllers;

import io.study.xo.model.Field;
import io.study.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrrentMoveControllerTest {

    @Test
    public void currentMoveWhenNextMoveIsO() throws Exception {
        final CurrrentMoveController currrentMoveController = new CurrrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertEquals(Figure.O, currrentMoveController.currentMove(field));
        }
    }

    @Test
    public void currentMoveWhenNextMoveIsX() throws Exception {
        final CurrrentMoveController currrentMoveController = new CurrrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            assertEquals(Figure.X, currrentMoveController.currentMove(field));
        }
    }

    @Test
    public void currentMoveWhenNoNextMove() throws Exception {
        final CurrrentMoveController currrentMoveController = new CurrrentMoveController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(currrentMoveController.currentMove(field));

    }

}