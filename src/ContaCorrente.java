public class ContaCorrente extends Conta {

    private static final double TAXA_MANUTENCAO = 12.0;

    public ContaCorrente(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    public void cobrarTaxa() {
        if (saldo >= TAXA_MANUTENCAO) {
            saldo -= TAXA_MANUTENCAO;
            adicionarTransacao("Cobrança de taxa de manutenção: R$ " + TAXA_MANUTENCAO);
        } else {
            System.out.println("Saldo insuficiente para cobrança de taxa de manutenção.");
        }
    }
}
