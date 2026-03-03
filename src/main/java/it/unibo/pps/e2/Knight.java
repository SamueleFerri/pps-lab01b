package it.unibo.pps.e2;

public interface Knight {

    void setKnight(Pair<Integer, Integer> knightPosition);

    Pair<Integer, Integer> getKnight();

    boolean checkMoveKnight(Pair<Integer, Integer> knightPosition);
}
