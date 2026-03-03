package it.unibo.pps.e2;

public interface Knight {

    void setKnight(int positionX, int positionY);

    Pair<Integer, Integer> getKnight();

    boolean checkMoveKnight(int positionX, int positionY);
}
