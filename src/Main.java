public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("Clara");
        Cliente cliente2 = new Cliente("Olivia");

        Conta cc = new ContaCorrente(cliente1, banco);
        Conta cp = new ContaPoupanca(cliente2, banco);

        cc.depositar(500);
        cp.depositar(1000);

        cc.sacar(100);
        cp.sacar(50);

        cc.transferir(200, cp);

        ((ContaCorrente) cc).cobrarTaxa();
        ((ContaPoupanca) cp).aplicarJuros();

        banco.listarContas();

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
