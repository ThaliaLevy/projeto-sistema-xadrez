package chess;

import boardgame.Board;

public class ChessMatch {
	//regras do jogo de xadrez

	private Board board; 
	
	public ChessMatch() {
		//nesta classe deve ser criado o tabuleiro
		board = new Board(8, 8);
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
}
