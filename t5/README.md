## Giuseppe Chaves Magnago - 811164
# Gerador de Código para a Linguagem LA
Este é um projeto de um **Gerador de Código** para a linguagem LA. O gerador de código deverá produzir código executável em C equivalente ao programa de entrada.

## Exemplo de Funcionamento
**Entrada:**
algoritmo
  declare
    x: literal
  leia(x)
  escreva(x)
fim_algoritmo

**Saída produzida:**
#include <stdio.h>
#include <stdlib.h>
int main() {
	char x[80];
	gets(x);
	printf("%s",x);
	return 0;
}

O código gerado não precisa ser idêntico ao fornecido nos casos de teste, mas ele deve ser compilável usando GCC, e sua EXECUÇÃO deve ser a mesma que a dos casos de teste. O corretor automático irá compilar o código gerado (usando GCC), executá-lo e comparar a entrada/saída com o que é esperado.

**Juntando o analisador semântico com o gerador de código em um único executável**

A saída do executável final, que irá combinar analisador léxico+sintático+semântico+gerador, depende da entrada:
- Se a entrada tiver algum erro (léxico ou sintático ou semântico) a saída deve conter a descrição dos erros;
- Se a entrada não tiver nenhum erro, a saída deve conter o código gerado.

O compilador deve poder ser executado em linha de comando (windows, mac ou linux), com DOIS ARGUMENTOS OBRIGATORIAMENTE:
Argumento 1: arquivo de entrada (caminho completo)
Argumento 2: arquivo de saída (caminho completo)


## Como Usar
Para testar o script, é necessário ter instalado o Java, o GCC e o corretor (.jar) que se encontra no repositório. Com isso, basta rodar o comando seguinte:

```bash
java -jar <caminho_absoluto_corretor(.jar)> "java -jar <caminho absoluto para o .jar com dependências>" <caminho_absoluto_MinGW> <diretório_temporário_para_as_saídas> <caminho_absoluto_casos_de_teste> "<RA>" "<t4>"
```
