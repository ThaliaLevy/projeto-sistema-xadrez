package chess;

import boardgame.Position;

public class ChessPosition {
	//Classe que mexe com a posição do xadrez
	private char column;
	private int row;
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
	
	//Convertendo posição de xadrez para posição de matriz
	protected Position toPosition() {
		return new Position (8 - row, column - 'a');
	}
	
	//Convertendo posição de matriz para posição de xadrez
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		// "" foi acrescentado para o compilador entender que é uma concatenação de strings
		return "" + column + row;
	}
}
