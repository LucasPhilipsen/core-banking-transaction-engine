import java.math.BigDecimal;
import java.util.logging.*;

public class Conta {

    private static final Logger logger = Logger.getLogger(Conta.class.getName());
    private Cliente titular;
    private int idConta;
    private BigDecimal saldo;
    private StatusConta status;

    public enum StatusConta {ACTIVE, DISABLED}

    //2.1 metodos e construtores de Conta:
    public Conta(int idConta, Cliente titular, BigDecimal saldoinicial) {
        this.idConta = idConta;
        this.titular = titular;
        this.saldo = saldoinicial;
        this.status = StatusConta.ACTIVE;
    }


    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
        System.out.println("[LOG] Depositado com sucesso da conta de -> " + this.titular.getNomeCompleto() + " Saldo: R$" + this.saldo);
    }

    public void sacar(BigDecimal valor) {
        System.out.println("[LOG] Tentativa de saque de: R$" + valor + ", Saldo da conta: R$" + this.saldo);
        if (this.saldo.compareTo(valor) < 0) {
            throw new IllegalArgumentException("[LOG] Saldo indisponivel na conta de -> " + this.titular.getNomeCompleto() + " para esta operacao");

        } else {
            this.saldo = this.saldo.subtract(valor);
            System.out.println("[LOG] saque realizado com sucesso da conta de -> " + this.titular.getNomeCompleto() + " Saldo: R$" + this.saldo);
        }

    }
}

