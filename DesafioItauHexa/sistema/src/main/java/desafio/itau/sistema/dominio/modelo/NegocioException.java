package desafio.itau.sistema.dominio.modelo;

public class NegocioException extends RuntimeException{
    public NegocioException(String message) {
        super(message);
    }
}
