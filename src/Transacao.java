import java.math.BigDecimal;

public class Transacao {
    public enum Tipopagamento {
        PIX, // 0
        CARTAO_DEBITO, // 1
        CARTAO_CREDITO, // 2
        DINHEIRO; // 3
    }

    private Tipopagamento tipo;
    private BigDecimal valor;
    private String cpfOrigem;
    private String cpfDestino;

    public Transacao(Tipopagamento tipo, BigDecimal valor, String cpfOrigem, String cpfDestino) {
        this.tipo = tipo;
        this.valor = valor;
        this.cpfOrigem = cpfOrigem;
        this.cpfDestino = cpfDestino;
    }

    public Tipopagamento getTipo() {
        return this.tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getCpfOrigem() {
        return cpfOrigem;
    }

    public String getCpfDestino() {
        return cpfDestino;
    }

    public void imprimirComprovante() {
        System.out.println("[COMPROVANTE] Tipo: " + this.tipo + " | Valor: R$" + this.valor +
                " | De: " + this.cpfOrigem + " -> Para: " + this.cpfDestino);
    }
}
