package io.study.xo.controllers;

import io.study.xo.model.Field;
import io.study.xo.model.Figure;
import io.study.xo.model.exeptions.InvalidPointException;

import java.awt.*;

public class CurrrentMoveController {

    public Figure currentMove(final Field field){
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++){
            for (int y = 0; y < field.getSize(); y++){
                try {
                    if (field.getFigure(new Point(x, y)) != null)
                        countFigure++;
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }

        if (countFigure == field.getSize() * field.getSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

}
