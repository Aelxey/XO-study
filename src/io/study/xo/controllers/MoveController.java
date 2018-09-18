package io.study.xo.controllers;

import io.study.xo.model.Field;
import io.study.xo.model.Figure;
import io.study.xo.model.exeptions.AlredyOccupiedException;
import io.study.xo.model.exeptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Point point,
                            final Field field,
                            final Figure figure) throws AlredyOccupiedException,
                                                        InvalidPointException {

        if (field.getFigure(point) != null){
            throw new AlredyOccupiedException();
        }

        field.setFigure(point, figure);

    }

}
