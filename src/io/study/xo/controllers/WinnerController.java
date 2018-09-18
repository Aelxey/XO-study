package io.study.xo.controllers;

import io.study.xo.model.Field;
import io.study.xo.model.Figure;
import io.study.xo.model.exeptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++)
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(i, 0));

            for (int i = 0; i < field.getSize(); i++)
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(0, i));

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(1, 1));

/*=========================================================
            for (int i = 0; i < field.getSize(); i++)
            if (check(field, new Point(i,0), new Point(i, 1), new Point(i, 2)))
                return field.getFigure(new Point(i,0));

            for (int i = 0; i < field.getSize(); i++)
                if (check(field, new Point(0,i), new Point(1, i), new Point(2, i)))
                    return field.getFigure(new Point(0,i));

            if (check(field, new Point(0, 0), new Point(1, 1), new Point(2,2)))
                return field.getFigure(new Point(0,0));

            if (check(field, new Point(0, 2), new Point(1, 1), new Point(2,0)))
                return field.getFigure(new Point(0,2));
*///========================================================
//-------------------------------------------------
/* First bad implementation for rows
//            if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(0, 1)) &&
//                    field.getFigure(new Point(0, 0)) == field.getFigure(new Point(0, 2)))
//                return field.getFigure(new Point(0, 0));
//
//            if (field.getFigure(new Point(1, 0)) == field.getFigure(new Point(1, 1)) &&
//                    field.getFigure(new Point(1, 0)) == field.getFigure(new Point(1, 2)))
//                return field.getFigure(new Point(1, 0));
//
//            if (field.getFigure(new Point(2, 0)) == field.getFigure(new Point(2, 1)) &&
//                    field.getFigure(new Point(2, 0)) == field.getFigure(new Point(2, 2)))
//                return field.getFigure(new Point(2, 0));
*/
//----------------------------------------------------------------

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {

        Point next(final Point point);
    }
}
