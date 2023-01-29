package br.com.ada.validacoes;

public class ValidarInput {
    private ValidacaoString validarString;
    private ValidarCnpj validarCnpj;
    private ValidarCpf validarCpf;
    private ValidarSenha validarSenha;

    public ValidarInput() {
        this.validarString = new ValidacaoString();
        this.validarCnpj = new ValidarCnpj();
        this.validarCpf = new ValidarCpf();
        this.validarSenha = new ValidarSenha();
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
}
