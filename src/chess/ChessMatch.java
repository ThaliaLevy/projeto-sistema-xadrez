package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	//iniciar a partida
	private void initialSetup() {
		board.placePiece(new Rook(board,  Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board,  Color.BLACK), new Position(6, 4));
		board.placePiece(new King(board,  Color.WHITE), new Position(0, 1));
	}
}
