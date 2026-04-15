![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=flat&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=flat&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=flat&logo=github&logoColor=white)
# Core Banking Transaction Engine (Java)

## Visão Geral
Este projeto é uma simulação de um motor transacional bancário (Core Banking) desenvolvido puramente em **Java**. O objetivo deste sistema é demonstrar a aplicação rigorosa dos pilares da Programação Orientada a Objetos (POO), integridade de dados financeiros e arquitetura de software limpa.

## Arquitetura e Funcionalidades

O sistema foi desenhado para simular o comportamento real de um back-end financeiro, incluindo:

* **Precisão Financeira Absoluta:** Utilização estrita de `BigDecimal` para representar saldos e valores de transação, evitando os clássicos erros de arredondamento binário do tipo `double`.
* **Banco de Dados em Memória (In-Memory DB):** Implementação da interface `Map` (`HashMap`) relacionando o CPF do cliente (Chave) ao objeto `Conta` (Valor) para buscas com complexidade de tempo O(1).
* **Transações Atômicas e Tratamento de Erros:** Delegação de responsabilidade de erros. A classe `Conta` apenas lança exceções (`IllegalArgumentException`) caso regras de negócio sejam violadas (ex: saldo insuficiente), enquanto a camada de execução (`Main`) realiza o `try/catch`, garantindo que o sistema não "crashe" e o erro seja logado de forma limpa.
* **Comprovantes e Rastreabilidade:** Geração de objetos `Transacao` (Recibos) tipados via `Enums` (`PIX`, `CARTAO_DEBITO`, etc.) para cada operação bem-sucedida.
* **Simulação de Data Masking:** Aplicação de mascaramento de dados sensíveis na impressão de logs (ex: `L**** P******** B***** | CPF: ***.***.432-91`), respeitando conceitos de privacidade (LGPD).
* **Auditoria com API de Streams:** Uso de `List`, `Streams`, `.filter()` e `.forEach()` para varrer o Livro Razão do banco e gerar relatórios analíticos segmentados por tipo de pagamento, simulando o início de um pipeline de Engenharia de Dados.
* **Relatórios Gerados dos comprovantes para que nada seja perdido, um exemplo abaixo:

<img width="851" height="105" alt="{B8FF0C39-3B6D-4231-8788-BC9FBEA63178}" src="https://github.com/user-attachments/assets/788c726f-ca90-4ce2-96ac-8fff0f647d2b" />



## Tecnologias Utilizadas
* **Java (JDK)**
* **Collections Framework** (`Map`, `HashMap`, `List`, `ArrayList`)
* **Java Stream API**
* **Pacote java.math** (`BigDecimal`)

## Como Executar
* Recomendo usar o `intelliJ IDEA`.
1. Clone este repositório.
2. Compile as classes `Cliente.java`, `Conta.java`, `Transacao.java` e `Main.java`.
3. Execute a classe `Main` para visualizar o pipeline de transações, as contenções de erros (saques bloqueados) e o relatório final gerado via Streams no console.
