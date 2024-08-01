package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class NumeroNaoAceito extends RuntimeException {
 
    public static final String DDD_INVALIDO = "Não é do ddd 81";

    public NumeroNaoAceito(String msg) {

	    super(String.format(msg));
    }

}
