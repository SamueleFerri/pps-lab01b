package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    private Knight knight;
    private int positionX;
    private int positionY;
    private static final Pair<Integer, Integer> PAWN = new Pair<>(1,2);;

    @BeforeEach
    void init() {
        knight = new KnightImpl(new Pair<>(positionX, positionY));
        positionX = 2;
        positionY = 1;
    }

    @Test
    public void testMoveKnight() {
        assertTrue(knight.checkMoveKnight(positionX, positionY));
    }

    @Test
    public void testSetPositionKnight() {
        knight.setKnight(positionX, positionY);
        assertEquals(new Pair<>(positionX, positionY), knight.getKnight());
    }

}
