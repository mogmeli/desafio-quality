package com.example.desafioquality.dto;

public class ErrorProprietyFormDto {
    private final String campo;
    private final String erro;

    public ErrorProprietyFormDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

}