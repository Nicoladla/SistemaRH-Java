package exceptions;

public class ConflitoException extends RuntimeException {
    public ConflitoException(String mensagem){
        super(mensagem);
    }
}
