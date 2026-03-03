package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    private Knight knight;
    private int knightPositionX;
    private int knightPositionY;
    private static final int PAW_POSITION_X = 1;
    private static final int PAW_POSITION_Y = 2;
    private static final Pair<Integer, Integer> PAWN = new Pair<>(PAW_POSITION_X,PAW_POSITION_Y);;

    @BeforeEach
    void init() {
        knight = new KnightImpl(new Pair<>(knightPositionX, knightPositionY));
        knightPositionX = 2;
        knightPositionY = 1;
    }

    @Test
    public void testMoveKnight() {
        assertTrue(knight.checkMoveKnight(knightPositionX, knightPositionY));
    }

    @Test
    public void testSetPositionKnight() {
        knight.setKnight(knightPositionX, knightPositionY);
        assertEquals(new Pair<>(knightPositionX, knightPositionY), knight.getKnight());
    }

    @Test
    public void testInvalidKnightMove() {
        knightPositionX = 1;
        knightPositionY = 1;
        assertFalse(knight.checkMoveKnight(knightPositionX, knightPositionY));
    }
}
