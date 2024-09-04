public class ContaPoupanca extends Conta {

    private static final double TAXA_JUROS = 0.01;

    public ContaPoupanca(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    public void aplicarJuros() {
        double juros = saldo * TAXA_JUROS;
        saldo += juros;
        adicionarTransacao("Aplicação de juros: R$ " + juros);
    }
}
