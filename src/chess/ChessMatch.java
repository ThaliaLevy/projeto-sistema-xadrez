package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source  = sourcePosition.toPosition();
		Position target  = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}
	
	//"capturar peça", inserindo a que captura no lugar da capturada
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	//validar se há uma peça na posição de origem 
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position.");
		}
		
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece.");
		}
	}
	
	//validar se o movimento da peça de origem é válido para a posição de destino
	private void validateTargetPosition(Position source, Position target){
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	//colocar peça passando as coordenadas do xadrez. ex.: b2
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	//iniciar a partida
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board,  Color.WHITE));
		placeNewPiece('c', 2, new Rook(board,  Color.WHITE));
		placeNewPiece('d', 2, new Rook(board,  Color.WHITE));
		placeNewPiece('e', 2, new Rook(board,  Color.WHITE));
		placeNewPiece('e', 1, new Rook(board,  Color.WHITE));
		placeNewPiece('d', 1, new King(board,  Color.WHITE));
		
		placeNewPiece('c', 7, new Rook(board,  Color.BLACK));
		placeNewPiece('c', 8, new Rook(board,  Color.BLACK));
		placeNewPiece('d', 7, new Rook(board,  Color.BLACK));
		placeNewPiece('e', 7, new Rook(board,  Color.BLACK));
		placeNewPiece('e', 8, new Rook(board,  Color.BLACK));
		placeNewPiece('d', 8, new King(board,  Color.BLACK));
	}
}
