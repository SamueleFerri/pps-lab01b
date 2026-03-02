package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private Logics logics;
    private static final int SIZE = 5;
    private Pair<Integer, Integer> knight;
    private Pair<Integer, Integer> pawn;

    @BeforeEach
    public void init() {
        knight = new Pair<>(0,0);
        pawn = new Pair<>(1,2);
        this.logics = new LogicsImpl(SIZE, knight, pawn);
    }

    @Test
    public void testInitialKnightPosition() {
        assertTrue(logics.hasKnight(knight.getX(),knight.getY()));
    }

    @Test
    public void testInitialPawnPosition() {
        assertTrue(logics.hasPawn(pawn.getX(),pawn.getY()));
    }
}
