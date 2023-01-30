package br.com.ada.validacoes;

public class ValidarInput {
    private ValidacaoString validarString;
    private ValidarCnpj validarCnpj;
    private ValidarCpf validarCpf;
    private ValidarSenha validarSenha;

    private ValidarValoresPositivos validarValoresPositivos;

    public ValidarInput() {
        this.validarString = new ValidacaoString();
        this.validarCnpj = new ValidarCnpj();
        this.validarCpf = new ValidarCpf();
        this.validarSenha = new ValidarSenha();
        this.validarValoresPositivos = new ValidarValoresPositivos();
    }

    public ValidacaoString getValidarString() {
        return validarString;
    }

    public void setValidarString(ValidacaoString validarString) {
        this.validarString = validarString;
    }

    public ValidarCnpj getValidarCnpj() {
        return validarCnpj;
    }

    public void setValidarCnpj(ValidarCnpj validarCnpj) {
        this.validarCnpj = validarCnpj;
    }

    public ValidarCpf getValidarCpf() {
        return validarCpf;
    }

    public void setValidarCpf(ValidarCpf validarCpf) {
        this.validarCpf = validarCpf;
    }

    public ValidarSenha getValidarSenha() {
        return validarSenha;
    }

    public void setValidarSenha(ValidarSenha validarSenha) {
        this.validarSenha = validarSenha;
    }

    public ValidarValoresPositivos getValidarValoresPositivos() {
        return validarValoresPositivos;
    }

    public void setValidarValoresPositivos(ValidarValoresPositivos validarValoresPositivos) {
        this.validarValoresPositivos = validarValoresPositivos;
    }
}
