package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    private Knight knight;
    private int knightPositionX;
    private int knightPositionY;
    private static final Pair<Integer, Integer> INITIAL_KNIGHT_POSITION = new Pair<>(0, 0);
    private static final int PAW_POSITION_X = 1;
    private static final int PAW_POSITION_Y = 2;
    private static final Pair<Integer, Integer> PAWN = new Pair<>(PAW_POSITION_X,PAW_POSITION_Y);
    private Pair<Integer, Integer> knightNewPosition;
    private int wrongKnightPositionX = 1;
    private int wrongKnightPositionY = 1;
    Pair<Integer, Integer> wrongKnightNewPosition;

    @BeforeEach
    void init() {
        knight = new KnightImpl(INITIAL_KNIGHT_POSITION);
        knightPositionX = 2;
        knightPositionY = 1;
        knightNewPosition = new Pair<>(knightPositionX, knightPositionY);
        wrongKnightNewPosition = new Pair<>(wrongKnightPositionX, wrongKnightPositionY);
    }

    @Test
    public void testMoveKnight() {
        assertTrue(knight.checkMoveKnight(knightNewPosition));
    }

    @Test
    public void testSetPositionKnight() {
        knight.setKnight(knightNewPosition);
        assertEquals(knightNewPosition, knight.getKnight());
    }

    @Test
    public void testInvalidKnightMove() {
        assertFalse(knight.checkMoveKnight(wrongKnightNewPosition));
    }

    @Test
    public void testInvalidSetPositionKnight() {
        assertThrows(IllegalArgumentException.class, () -> knight.setKnight(wrongKnightNewPosition));
        assertEquals(INITIAL_KNIGHT_POSITION, knight.getKnight());
    }
}
