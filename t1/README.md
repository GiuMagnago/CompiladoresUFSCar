## Giuseppe Chaves Magnago - 811164
# Analisador Léxico para a Linguagem LA
Este é um projeto de um **Analisador Léxico** para a linguagem LA. O script foi desenvolvido para ler um arquivo de código fonte da linguagem LA e realizar a análise léxica, identificando os tokens de acordo com a gramática da linguagem. A saída gerada será uma lista de tokens identificados ou mensagens de erro, indicando problemas no código.

## Funcionalidades

- **Identificação de Tokens:** O analisador léxico é responsável por identificar os seguintes tokens:
  - Palavras reservadas (e.g., `algoritmo`, `fim_algoritmo`, `declare`)
  - Identificadores
  - Números inteiros e reais
  - Operadores e símbolos (e.g., `+`, `-`, `<=`, `>`, `:=`, `*`, `,`, etc.)
  - Cadeias literais (strings)
  - Comentários
  - Intervalos (`..`)
  
- **Tratamento de Erros:** O analisador também é capaz de detectar e reportar:
  - Símbolos não identificados
  - Comentários e cadeias literais não fechadas corretamente

## Como Usar
Para testar o script, é necessário ter instalado o Java, Python 3.x, o GCC e o corretor (.jar) que se encontra no repositório. Com isso, basta rodar o comando seguinte:

```bash
java -jar <caminho_absoluto_corretor(.jar)> "python <caminho absoluto para o script python>" <caminho_absoluto_MinGW> <diretório_temporário_para_as_saídas> <caminho_absoluto_casos_de_teste> "<RA>" <tipo_de_teste>
```
