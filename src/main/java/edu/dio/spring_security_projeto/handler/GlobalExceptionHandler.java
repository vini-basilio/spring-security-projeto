package edu.dio.spring_security_projeto.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler global de exceções da aplicação.
 * Centraliza o tratamento de erros e padroniza as respostas HTTP.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Trata exceções de regras de negócio.
     * Retorna status 422 (Unprocessable Entity) com detalhes do erro.
     * 
     * @param ex Exceção de negócio lançada
     * @return ResponseEntity com status 422 e detalhes do erro
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseError> tratarRegraDeNegocio(BusinessException ex) {
        logger.error("Erro de negócio: {}", ex.getMessage());

        ResponseError responseError = new ResponseError();
        responseError.setError(ex.getMessage());
        responseError.setStatusCode(ex.getStatusCode());

        return ResponseEntity.status(responseError.getStatusCode()).body(responseError);
    }

    /**
     * Trata erros de parsing de JSON.
     * Retorna status 400 (Bad Request) com detalhes do erro.
     * 
     * @param ex Exceção de parsing de JSON
     * @return ResponseEntity com status 400 e detalhes do erro
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseError> handleJsonParseErrors(HttpMessageNotReadableException ex) {
        logger.error("Erro ao processar JSON: {}", ex.getMessage());

        ResponseError responseError = new ResponseError();
        responseError.setError("Erro ao processar o JSON enviado");
        responseError.setStatusCode(400);

        return ResponseEntity.status(responseError.getStatusCode()).body(responseError);
    }
}
