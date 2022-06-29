package boardgame;

public abstract class Piece {
	//classe das peças do jogo
	
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
	
	//movimentos possíveis de uma peça genérica
	public abstract boolean[][] possibleMoves();
	
	//verificar se uma peça pode ser movida para uma determinada posição
	//função só vai fazer sentido quando existir uma classe concreta que implementar a função abstrata
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	//verificar se a peça tem pelo menos 1 movimento possível
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
