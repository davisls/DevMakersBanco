package br.com.ada.views.banco;

import br.com.ada.views.View;

public class MenuInciarView extends View {
    private final MenuCadastroView menuCadastroView;
    private final MenuLoginView menuLoginView;

    public MenuInciarView(MenuCadastroView menuCadastroView, MenuLoginView menuLoginView) {
        this.menuCadastroView = menuCadastroView;
        this.menuLoginView = menuLoginView;
    }

    public void menuInicial() {
        boolean sair = false;
        do {
            System.out.println();
            System.out.println("~~~~<💰>~~~~ 🏟 ADAÚ 🏟 ~~~~<💰>~~~~");
            System.out.println("     Feito por você, para você! ");
            System.out.println();
            System.out.println("Digite 1 para abrir conta.");
            System.out.println("Digite 2 para acessar sua conta.");
            System.out.println("Digite 3 para encerrar a sessão.");
            int opcaoMenu = pedirOpcao();
            switch (opcaoMenu) {
                case 1:
                    menuCadastroView.menuCadastro();
                    break;
                case 2:
                    menuLoginView.menuLogin();
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
            }
        } while(!sair);
    }

}
