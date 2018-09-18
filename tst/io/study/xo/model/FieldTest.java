package io.study.xo.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getSize() throws Exception {
        final Field field = new Field();
        int actualValue = field.getSize();
        int expectedValue = 3;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);
        final Figure expectedFigure = Figure.O;

        assertEquals(expectedFigure, actualFigure);
    }

}