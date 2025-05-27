## Giuseppe Chaves Magnago - 811164
# Analisador Semântico para a Linguagem LA
Este é um projeto de um **Analisador Semântico** para a linguagem LA. O script foi desenvolvido para ler um arquivo de código fonte da linguagem LA e realizar a análise semântica. A saída gerada será uma lista de mensagens de erro, indicando problemas no código.  

**Tratamento de Erros:** 
  - Identificador (variável, constante, procedimento, função, tipo) já declarado anteriormente no escopo.
    - O mesmo identificador não pode ser usado novamente no mesmo escopo mesmo que para categorias diferentes.
  - Tipo não declarado
  - Identificador (variável, constante, procedimento, função) não declarado
  - Atribuição não compatível com o tipo declarado
    - Atribuições possíveis
      - ponteiro ← endereço
      - (real | inteiro) ← (real | inteiro)
      - literal ← literal
      - logico ← logico
      - registro ← registro (com mesmo nome de tipo)
    - As mesmas restrições são válidas para expressões, por exemplo, ao tentar combinar um literal com um logico (como em literal + logico) deve dar tipo_indefinido e inviabilizar a atribuição

Ao encontrar um erro, o analisador NÃO DEVERÁ interromper sua execução. Ele deverá continuar reportando erros até o final do arquivo.

## Como Usar
Para testar o script, é necessário ter instalado o Java, o GCC e o corretor (.jar) que se encontra no repositório. Com isso, basta rodar o comando seguinte:

```bash
java -jar <caminho_absoluto_corretor(.jar)> "java -jar <caminho absoluto para o .jar com dependências>" <caminho_absoluto_MinGW> <diretório_temporário_para_as_saídas> <caminho_absoluto_casos_de_teste> "<RA>" "<t3>"
```
