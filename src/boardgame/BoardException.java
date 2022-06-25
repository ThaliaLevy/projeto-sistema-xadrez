package boardgame;

public class BoardException extends RuntimeException{
	//RuntimeException > implementa esta interface para indicar que a exce��o � opcional de ser tratada
	
	//pr�pria IDE pediu para acrescentar o nro da vers�o
	private static final long serialVersionUID = 1L;
	
	//construtor abaixo vai enviar a mensagem para o construtor super (do RuntimeException)
	public BoardException(String msg) {
		super(msg);
	}
}
