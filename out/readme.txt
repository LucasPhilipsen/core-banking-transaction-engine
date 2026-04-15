import java.math
import java.util.*
import java.LocalDateTime

1 - public class Cliente:

private String nomeCompleto;

private String) cpf; será formatado no formato ###.###.###-##


1.1 - metodos de Cliente:

public Cliente(String nome, String cpf, int idConta){this....}

public void showSummary(int id){ mostra as informações do cliente sem leva-las até a Main }

2 - class Conta

private Cliente titular;

enum Status{ ACTIVE, DISABLED}

private BigDecimal saldo;

private int idConta;

private static final Logger logger = Logger.getLogger(conta.class.getName());

2.1 metodos e construtores de Conta:

public depositar(BigDecimal valor){
    this.saldo = this.saldo.add(valor);

}

public sacar(BigDecimal valor){

    public SaldoInsuficienteException extends RuntimeException throw new SaldoInsuficienteException("Saldo indisponivel para esta operacao"){
        logger.warning("Tentativa de saque sem saldo");
        return 1;
    }

    this.saldo = this.saldo.substract(valor);
    logger.info("saque realizado com sucesso");
}

public Conta(int idConta, double saldo){}

3 - public class Transacao

    private static final Logger logger = Logger.getLogger(Transacao.class.getName());

    enum tipoPagamento{ PIX, CARTAO_CREDITO, CARTAO_DEBITO, DINHEIRO}

    public Transacoes(){}