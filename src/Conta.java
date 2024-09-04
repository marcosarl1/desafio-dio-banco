import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> transacoes;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
        cliente.adicionarConta(this);
        banco.adicionarCliente(cliente);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void adicionarTransacao(String descricao) {
        transacoes.add(descricao);
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da Conta " + numero);
        transacoes.forEach(System.out::println);
    }

    @Override
    public void sacar(double valor) {
        try {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                adicionarTransacao("Saque de: R$ " + valor);
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido, tente novamente.");
        }
    }

    @Override
    public void depositar(double valor) {
        try {
            if (valor > 0) {
                saldo += valor;
                adicionarTransacao("Depositó de: R$ " + valor);
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido, tente novamente.");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        try {
            if (valor > 0 && valor <= saldo) {
                this.sacar(valor);
                contaDestino.depositar(valor);
                adicionarTransacao("Transferência de: R$ " + valor + " para conta: " + contaDestino.getNumero());
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido, tente novamente.");
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", transacoes=" + transacoes +
                '}';
    }
}
