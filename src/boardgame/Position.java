package boardgame;

public class Position {
	//classe que manipula as posições das peças
	private int row, column;
	
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	//para imprimir a posição na tela
	@Override
	public String toString() {
		return row + "," + column;
	}
}
