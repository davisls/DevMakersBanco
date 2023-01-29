package br.com.ada.validacoes;

public class ValidarInput {
    public ValidacaoString validarString;
    public ValidarCnpj validarCnpj;
    public ValidarCpf validarCpf;
    public ValidarSenha validarSenha;

    public ValidarInput() {
        this.validarString = new ValidacaoString();
        this.validarCnpj = new ValidarCnpj();
        this.validarCpf = new ValidarCpf();
        this.validarSenha = new ValidarSenha();
    }
}
