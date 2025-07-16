## Giuseppe Chaves Magnago - 811164
# Compilador para contabilização de votos da eleição
Este é um projeto de um **Compilador** para a linguagem que contabiliza votos de urnas na eleição.O compilador recebe um programa com extensão .el, faz a contabilização dos votos, apresenta o resultado dos votos e também mostra os erros ocorridos durante a execução.

## Exemplo de Funcionamento
**Entrada:**

Primeiramente, fazemos o cadastro dos candidatos com seus nomes. Após isso, é feito o cadastro dos votos por urna, então abrimos a chave da urna com seu código e registra todos os votos lá. <br>
O compilador também aceita comentários (//)
```
candidato "João da Silva"
candidato "Maria Oliveira"
candidato "Carlos Souza"
candidato "Ana Beatriz"

urna "001" {
    voto "Pedro Santos" em "João da Silva"	    // ERRO_01 (voto repetido)
    voto "Larissa Almeida" em "Maria Oliveira"
    voto "Rafael Costa" em "Carlos Souza"
    voto "Beatriz Lima" em "Ana Beatriz"
}

urna "002" {
    voto "Gabriel Martins" em "João da Silva"
    voto "Juliana Rocha" em "Maria Oliveira"
    voto "Pedro Santos" em "Carlos Souza"      // ERRO_01 (voto repetido)
    voto "Lucas Fernandes" em "João da Silva"
}

urna "003" {
    voto "Vanessa Moura" em "Ana Beatriz"
    voto "Thiago Ribeiro" em "Carlos Souza"
    voto "Letícia Silva" em "Carlos Souza"
    voto "Paula Monteiro" em "Marcos Pereira"  // ERRO_02 (candidato não existe)
}
```

**Saída:**

Na saída, é mostrado o resultado de cada urna por candidato, o resultado final com a contabilização geral dos votos em cada candidato e, por último, mostramos um registro de erros ocorridos. <br>
Se algum voto der erro, ele apenas anulará o voto e continuará o programa normalmente), fiz dessa maneira porque não seria justo que o erro de um eleitor fizesse o programa inteiro ser cancelado. Por isso, em caso de voto duplicado, é considerado apenas o primeiro voto e o outro é anulado.
```
--- Resultado por Urna ---
Urna 001:
  João da Silva: 1 voto(s)
  Maria Oliveira: 1 voto(s)
  Carlos Souza: 1 voto(s)
  Ana Beatriz: 1 voto(s)

Urna 002:
  João da Silva: 2 voto(s)
  Maria Oliveira: 1 voto(s)
  Carlos Souza: 0 voto(s)
  Ana Beatriz: 0 voto(s)

Urna 003:
  João da Silva: 0 voto(s)
  Maria Oliveira: 0 voto(s)
  Carlos Souza: 2 voto(s)
  Ana Beatriz: 1 voto(s)

--- Resultado Geral ---
João da Silva: 3 voto(s)
Maria Oliveira: 2 voto(s)
Carlos Souza: 3 voto(s)
Ana Beatriz: 2 voto(s)
Empate entre: João da Silva, Carlos Souza

--- Erros ---
Erro: Eleitor "Pedro Santos" já votou.
Erro: Candidato "Marcos Pereira" não existe.
```

## Como Usar <br>
Para testar o compilador, é necessário ter instalado o Java, o GCC e o corretor (.jar) que se encontra no repositório. Com isso, monte a entrada que deseja seguindo o formato apresentado e com extensão .el.

Feito isso, é utilizado o script abaixo no terminal:

```
java -jar <ARG01> <ARG02> <ARG03>
```
ARG01: caminho absoluto para o compilador com dependências (exemplo: C:/t6-1.0-SNAPSHOT-jar-with-dependencies.jar) <br>
ARG02: caminho absoluto para o programa de entrada com a extensão correta (exemplo: C:/entrada.el) <br>
ARG03: caminho absoluto para a saída resultante com extensão (exemplo: C:/saida.txt) <br>

Exemplo de script para rodar:
```
java -jar C:/t6-1.0-SNAPSHOT-jar-with-dependencies.jar C:/entrada.el C:/saida.txt
```
