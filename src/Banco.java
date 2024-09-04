import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static final String NOME_BANCO = "Banco Daora";

    private String nome;
    private List<Cliente> clientes;

    public Banco() {
        this.nome = NOME_BANCO;
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void listarContas() {
        clientes.forEach(Cliente::listarContas);
    }

    public String getNome() {
        return nome;
    }
}
