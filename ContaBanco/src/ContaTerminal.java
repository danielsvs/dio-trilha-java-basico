import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    String nomeCliente;
    int numero;
    String agencia;
    double saldo;

    void obterDados () {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o seu nome:");
        nomeCliente = scanner.next();

        System.out.println("Digite o número da conta: ");
        numero = scanner.nextInt();

        System.out.println("Digite o número da agência: ");
        agencia = scanner.next();

        System.out.println("Digite o seu saldo: ");
        saldo = scanner.nextDouble();
    }

    void exibirMensagem () {
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " +
                agencia + ", conta " + numero + " e seu saldo " + String.format(Locale.US,"%.2f", saldo) +
                " já está disponível para saque.");
    }

}