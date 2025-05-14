## Giuseppe Chaves Magnago - 811164
# Analisador Léxico para a Linguagem LA
Este é um projeto de um **Analisador Sintático** para a linguagem LA. O script foi desenvolvido para ler um arquivo de código fonte da linguagem LA e realizar a análise sintática. A saída gerada será uma mensagens de erro, indicando a primeira ocorrência de problema no código.  

**Tratamento de Erros:** 
  - O analisador sintático deve ler um programa-fonte e apontar onde existe erro sintático, indicando a linha e o lexema que causou a detecção do erro

## Como Usar
Para testar o script, é necessário ter instalado o Java, o GCC e o corretor (.jar) que se encontra no repositório. Com isso, basta rodar o comando seguinte:

```bash
java -jar <caminho_absoluto_corretor(.jar)> "java -jar <caminho absoluto para o .jar com dependências>" <caminho_absoluto_MinGW> <diretório_temporário_para_as_saídas> <caminho_absoluto_casos_de_teste> "<RA>" "<t2>"
```
