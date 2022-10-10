package br.com.lucas.repository.exception;

import lombok.Builder;


public class ExceptionHandler {

    public static void check(int status){
        switch(status) {
            case 404:
                throw new ObjectNotFoundException("Erro. Não encontrado");
            case 400:
                throw new BadRequestException("Erro. Informação incorreta.");
            case 500:
              throw  new BadRequestException("Erro.Bad Request.");
        }
    }

}
