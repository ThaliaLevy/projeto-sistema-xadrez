package chess;

import boardgame.Board;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {
	//regras do jogo de xadrez

	private Board board; 
	
	public ChessMatch() {
		//cria o tabuleiro
		board = new Board(8, 8);
		initialSetup();
	}
	
	//Program precisa ter acesso somente às peças desta camada (chess) e, portanto,
	//não poderá acessar as peças da matriz em Piece (boardgame). acessará:
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for(int i = 0; i < board.getRows(); i++){
			for(int j = 0; j < board. getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j);
			}
		}
		return mat;
	}
	
	//colocar peça passando as coordenadas do xadrez. ex.: b2
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	//iniciar a partida
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board,  Color.WHITE));
		placeNewPiece('e', 8, new King(board,  Color.BLACK));
		placeNewPiece('e', 1, new King(board,  Color.WHITE));
	}
}
