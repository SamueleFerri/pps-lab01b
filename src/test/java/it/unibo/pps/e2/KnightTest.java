package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    private Knight knight;
    private static final Pair<Integer, Integer> INITIAL_KNIGHT_POSITION = new Pair<>(0, 0);
    private int knightNewPositionX;
    private int knightNewPositionY;
    private Pair<Integer, Integer> knightNewPosition;
    Pair<Integer, Integer> wrongKnightNewPosition = new Pair<>(1 ,1);

    @BeforeEach
    void init() {
        knight = new KnightImpl(INITIAL_KNIGHT_POSITION);
        knightNewPositionX = 2;
        knightNewPositionY = 1;
        knightNewPosition = new Pair<>(knightNewPositionX, knightNewPositionY);
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
