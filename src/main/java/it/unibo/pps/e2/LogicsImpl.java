package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	private final Pair<Integer,Integer> pawn;
	private final Random random = new Random();
	private final int size;
	private Knight knight;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = new KnightImpl(this.randomEmptyPosition());
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
        this.size = size;
        this.knight = new KnightImpl(knight);
        this.pawn = pawn;
    }
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		Pair<Integer, Integer> moveKnight = new Pair<>(row, col);
		if(this.knight.checkMoveKnight(moveKnight)){
			this.knight.setKnight(moveKnight);
			return this.pawn.equals(this.knight.getKnight());
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getKnight().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
