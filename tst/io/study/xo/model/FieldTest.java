package io.study.xo.model;

import io.study.xo.model.exeptions.AlredyOccupiedException;
import io.study.xo.model.exeptions.InvalidPointException;
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

    @Test
    public void testFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testFigureWhenXLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void testFigureWhenYLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void testFigureWhenXMoreThanSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void testFigureWhenYMoreThanSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void testFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlredyOccupiedException e){}
    }

}