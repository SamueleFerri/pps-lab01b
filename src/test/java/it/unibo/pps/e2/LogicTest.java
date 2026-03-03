package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private Logics logics;
    private static final int SIZE = 5;
    private static final Pair<Integer, Integer> PAWN = new Pair<>(1,2);;
    private int knightPosX;
    private int knightPosY;

    @BeforeEach
    public void init() {
        this.logics = new LogicsImpl(SIZE, new Pair<>(knightPosX, knightPosY), PAWN);
    }

    @Test
    public void testInitialKnightPosition() {
        assertTrue(logics.hasKnight(knightPosX, knightPosY));
    }

    @Test
    public void testInitialPawnPosition() {
        assertTrue(logics.hasPawn(PAWN.getX(), PAWN.getY()));
    }

    @Test
    public void testInvalidKnightMove() {
        int wrongNightPosX = 1;
        int wrongKnightPosY = 1;
        assertFalse(logics.hasKnight(wrongNightPosX, wrongKnightPosY));
        assertTrue(logics.hasKnight(knightPosX, knightPosY));
    }

    @Test
    public void testValidKnightMove() {
        knightPosX = 2;
        knightPosY = 1;
        logics.hit(knightPosX, knightPosY);
        assertFalse(logics.hit(knightPosX, knightPosY));
        assertTrue(logics.hasKnight(knightPosX, knightPosY));
    }

    @Test
    public void testKnightCapturePawn() {
        knightPosX = PAWN.getX();
        knightPosY = PAWN.getY();
        assertTrue(logics.hit(knightPosX, knightPosY));
        assertTrue(logics.hasKnight(knightPosX, knightPosY));
    }

    @Test
    public void testHitOutOfBounds() {
        knightPosX = -1;
        knightPosY = 0;
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(knightPosX, knightPosY));
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(SIZE, SIZE));
    }
}
