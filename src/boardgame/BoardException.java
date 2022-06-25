package boardgame;

public class BoardException extends RuntimeException{
	//RuntimeException > implementa esta interface para indicar que a exceção é opcional de ser tratada
	
	//própria IDE pediu para acrescentar o nro da versão
	private static final long serialVersionUID = 1L;
	
	//construtor abaixo vai enviar a mensagem para o construtor super (do RuntimeException)
	public BoardException(String msg) {
		super(msg);
	}
}
