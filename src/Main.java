import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Cliente lucas = new Cliente("Lucas Philipsen Borges", "111.432.432-91");
        Conta contaUm = new Conta(100001, lucas, new BigDecimal("7600.00"));

        Cliente taina = new Cliente("Taina Bonatto Boaretto", "222.643.654-92");
        Conta contaDois = new Conta(100002, taina, new BigDecimal("9000.00"));

        Cliente bruno = new Cliente("Bruno Borges", "333.654.738-32");
        Conta contaTres = new Conta(100003, bruno, new BigDecimal("2500.00"));

        Cliente mateus = new Cliente("Mateus dos Santos", "444.436.684-92");
        Conta contaQuatro = new Conta(100004, mateus, new BigDecimal("5000.00"));

        Cliente jose = new Cliente("Jose da Silva Machado", "555.624.624-62");
        Conta contaCinco = new Conta(100005, jose, new BigDecimal("10000.00"));

        Map<String, Conta> bancoDeDados = new HashMap<>();

        bancoDeDados.put(lucas.getCpf(), contaUm);
        bancoDeDados.put(taina.getCpf(), contaDois);
        bancoDeDados.put(bruno.getCpf(), contaTres);
        bancoDeDados.put(mateus.getCpf(), contaQuatro);
        bancoDeDados.put(jose.getCpf(), contaCinco);

        List<Transacao> livroComprovantes = new ArrayList<>();


        System.out.println("Conta: Conta ID: 100001 | Titular: L**** P******** B***** | CPF: ***.***.432-91 -> " + " Saldo inicial: " + contaUm.getSaldo());
        System.out.println("Conta: Conta ID: 100002 | Titular: T**** B****** B******* | CPF: ***.***.654-92 -> " + " Saldo inicial: " + contaDois.getSaldo());
        System.out.println("Conta: Conta ID: 100003 | Titular: B**** B***** | CPF: ***.***.738-32 -> " + " Saldo inicial: " + contaTres.getSaldo());
        System.out.println("Conta: Conta ID: 100004 | Titular: M***** dos S***** | CPF: ***.***.684-92 -> " + " Saldo inicial: " + contaQuatro.getSaldo());
        System.out.println("Conta: Conta ID: 100005 | Titular: J*** da S**** M****** | CPF: ***.***.624-62 -> " + " Saldo inicial: " + contaCinco.getSaldo());

        System.out.println("\n");
        System.out.println("----------------------------\n");

        // todas as os valores das transacoes feitas
        BigDecimal pixUm = new BigDecimal("120.00");
        BigDecimal pixDois = new BigDecimal("200.00");
        BigDecimal pixTres = new BigDecimal("9000.00");
        BigDecimal debitoUm = new BigDecimal("3.00");


        // todo try-catch é uma tentativa de transacao

        // Pix 1
        try {
            bancoDeDados.get(lucas.getCpf()).sacar(pixUm);
            bancoDeDados.get(taina.getCpf()).depositar(pixUm);

            Transacao comprovante = new Transacao(
                    Transacao.Tipopagamento.PIX,
                    pixUm,
                    lucas.getCpf(),
                    taina.getCpf()
            );
            System.out.println("\n");
            comprovante.imprimirComprovante();
            livroComprovantes.add(comprovante);

        } catch (IllegalArgumentException e) {
            System.out.println("Falha no PIX: " + e.getMessage() + "\n");
        }
        System.out.println("----------------------------\n");

        // Pix 2
        try {
            bancoDeDados.get(jose.getCpf()).sacar(pixDois);
            bancoDeDados.get(bruno.getCpf()).depositar(pixDois);

            Transacao comprovante = new Transacao(
                    Transacao.Tipopagamento.PIX,
                    pixDois,
                    jose.getCpf(),
                    bruno.getCpf()
            );
            System.out.println("\n");
            comprovante.imprimirComprovante();
            livroComprovantes.add(comprovante);

        } catch (IllegalArgumentException e) {
            System.out.println("Falha no PIX: " + e.getMessage() + "\n");
        }
        System.out.println("----------------------------\n");

        // Pix 3
        try {
            bancoDeDados.get(lucas.getCpf()).sacar(pixTres);
            bancoDeDados.get(mateus.getCpf()).depositar(pixTres);

            Transacao comprovante = new Transacao(
                    Transacao.Tipopagamento.PIX,
                    pixTres,
                    lucas.getCpf(),
                    mateus.getCpf()
            );
            System.out.println("\n");
            comprovante.imprimirComprovante();
            livroComprovantes.add(comprovante);

        } catch (IllegalArgumentException e) {
            System.out.println("Falha no PIX: " + e.getMessage() + "\n");
        }
        System.out.println("----------------------------\n");

        // Debito 1; só pra ver o filter do stream descartando
        try {
            bancoDeDados.get(lucas.getCpf()).sacar(debitoUm);
            bancoDeDados.get(mateus.getCpf()).depositar(debitoUm);

            Transacao comprovante = new Transacao(
                    Transacao.Tipopagamento.CARTAO_DEBITO,
                    debitoUm,
                    lucas.getCpf(),
                    mateus.getCpf()
            );
            System.out.println("\n");
            comprovante.imprimirComprovante();
            livroComprovantes.add(comprovante);

        } catch (IllegalArgumentException e) {
            System.out.println("Falha no PIX: " + e.getMessage() + "\n");
        }
        System.out.println("----------------------------\n");


        System.out.println("\n\n________RELATORIO_PIX_______");
        livroComprovantes.stream()
                .filter(t -> t.getTipo() == Transacao.Tipopagamento.PIX)
                .forEach(t -> t.imprimirComprovante());
        System.out.println("\n________RELATORIO_DEBITO_______");
        livroComprovantes.stream()
                .filter(t -> t.getTipo() == Transacao.Tipopagamento.CARTAO_DEBITO)
                .forEach(t -> t.imprimirComprovante());

    }
}
