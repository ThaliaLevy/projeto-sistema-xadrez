package boardgame;

public class Piece {
	protected Position position;
	private Board board;

	// para criar a peça é preciso informar o board em que ela se encontra
	public Piece(Board board) {
		// position não obrigatorio informar, ja que por padrão seria null. porém, é de
		// melhor entendimento pois indica que a posição da peça é null inicialmente
		this.position = null;
		this.board = board; 
	}

	// não será possível fazer alterações de tabuleiro, por isso não haverá set
	// protegido para que o acesso seja limitado
	protected Board getBoard() {
		return board;
	}

}
