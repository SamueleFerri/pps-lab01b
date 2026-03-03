package it.unibo.pps.e2;

public class KnightImpl implements Knight {
    private Pair<Integer,Integer> knight;

    public KnightImpl(Pair<Integer, Integer> knight) {
        this.knight = knight;
    }

    @Override
    public void setKnight(Pair<Integer, Integer> knightPosition) {
        if(checkMoveKnight(knightPosition)) {
            this.knight = knightPosition;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Pair<Integer, Integer> getKnight() {
        return this.knight;
    }

    @Override
    public boolean checkMoveKnight(Pair<Integer, Integer> knightPosition) {
        int x = knightPosition.getX() - this.knight.getX();
        int y = knightPosition.getY() - this.knight.getY();
        return x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3;
    }
}
