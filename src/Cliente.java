public class Cliente {

    private String nomeCompleto;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nomeCompleto = nome;
        this.cpf = cpf;

    }


    public String getNomeCompleto() { // mostra as informações do cliente sem leva-las até a Main }
        return this.nomeCompleto;
    }

    public String getCpf() {
        return this.cpf;
    }
}
