package io.study.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void getPlayers() throws Exception {
        final Player player1 = new Player("Alex", Figure.X);
        final Player player2 = new Player("Boss", Figure.O);
        final Player[] actualValuePlayers = {player1, player2};
        final Player[] expectedValuePlayers = actualValuePlayers;
        final Game game = new Game(actualValuePlayers, null, null);
        assertEquals(expectedValuePlayers, game.getPlayers());

    }

    @Test
    public void getField() throws Exception {
        final Field actualField = new Field(3);
        final Field expectedField = actualField;
        final Game game = new Game(null, actualField, null);
        assertEquals(expectedField, game.getField());
    }

    @Test
    public void getName() throws Exception {
        final String actualName = new String("Alex");
        final String expectedName = actualName;
        final Game game = new Game(null, null, expectedName);
        assertEquals(expectedName, game.getName());
    }

}