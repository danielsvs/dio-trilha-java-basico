package implementacao;

public class iPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{

    private boolean tela;
    private final String botaoHome = "Tela inicial";
    private boolean botaoLigaDesliga;
    private int volume;
    private final int botaoAumentarVolume = +1;
    private final int botaoDiminuirVolume = -1;
    private boolean altoFalantes;
    private boolean microfone;
    private boolean camera;

    public iPhone() {
        tela = false;
        botaoLigaDesliga = false;
        volume = 5;
        altoFalantes = false;
        microfone = false;
        camera = false;
    }

    public void ligarIPhone() {
        botaoLigaDesliga = true;
        tela = true;
        System.out.println("LIGANDO...");
    }

    public void desligarIPhone() {
        botaoLigaDesliga = false;
        tela = false;
        System.out.println("ATÉ LOGO...");
    }

    @Override
    public void tocar() {
        altoFalantes = true;
        System.out.println("TOCANDO MÚSICA!");
    }

    @Override
    public void pausar() {
        altoFalantes = false;
        System.out.println("MÚSICA PAUSADA!");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("MÚSICA " + musica + " FOI SELECIONADA!");
    }

    @Override
    public void ligar(String numero) {
        microfone = true;
        altoFalantes = true;
        System.out.println("LIGANDO PARA " + numero);
    }

    @Override
    public void atender() {
        altoFalantes = true;
        microfone = true;
        System.out.println("LIGAÇÃO RECEBIDA!");

    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("CORREIRO DE VOZ INICIADO");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("PÁGINA " + url + "EXIBIDA");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("NOVA ABA ADICIONADA");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("ATUALIZAR PÁGINA!");
    }
}
