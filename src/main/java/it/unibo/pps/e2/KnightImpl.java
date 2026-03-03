package it.unibo.pps.e2;

public class KnightImpl implements Knight {
    private Pair<Integer,Integer> knight;

    public KnightImpl(Pair<Integer, Integer> knight) {
        this.knight = knight;
    }

    @Override
    public void setKnight(int positionX, int positionY) {
        if(checkMoveKnight(positionX, positionY)) {
            this.knight = new Pair<>(positionX, positionY);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Pair<Integer, Integer> getKnight() {
        return this.knight;
    }

    @Override
    public boolean checkMoveKnight(int positionX, int positionY) {
        int x = positionX - this.knight.getX();
        int y = positionY - this.knight.getY();
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            return true;
        }
        return false;
    }
}
