package br.com.ada.views.banco;

import br.com.ada.validacoes.ValidarInput;
import br.com.ada.views.View;

public class BancoView extends View {
    private static final BancoView INSTANCE = new BancoView();

    public static BancoView getInstance() {
        return INSTANCE;
    }

    public void inicialBancoView() {
        MenuCadastroView menuCadastroView = new MenuCadastroView();
        MenuLoginView menuLoginView = new MenuLoginView();
        MenuInciarView menuInciarView = new MenuInciarView(menuCadastroView, menuLoginView);
        menuInciarView.menuInicial();
    }
}
