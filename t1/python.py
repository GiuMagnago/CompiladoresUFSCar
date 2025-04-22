import sys
import re

# Conjunto de palavras reservadas da linguagem LA
palavras_reservadas = {
    "algoritmo", "fim_algoritmo", "declare", "leia", "escreva",
    "literal", "inteiro", "real", "logico", "verdadeiro", "falso",
    "registro", "fim_registro", "tipo", "procedimento", "fim_procedimento",
    "funcao", "fim_funcao", "retorne", "se", "senao", "entao", "fim_se",
    "caso", "seja", "fim_caso","para", "fim_para", "enquanto", "fim_enquanto",
    "faca", "ate", "e", "ou", "nao", "var", "constante"
}

# Expressão regular composta que identifica os diversos tokens possiveis
regex_tokens = re.compile(r'''
    (?P<espaco>\s+) |
    (?P<comentario_aberto>\{[^\}]*$) |
    (?P<comentario>\{[^}]*\}) |
    (?P<cadeia_aberta>"[^"\n]*$) |
    (?P<cadeia>"[^"\n]*") |
    (?P<num_real>\d+\.\d+) |
    (?P<num_int>\d+) |
    (?P<atribuicao><-) |
    (?P<operador_relacional><=|>=|<>|<|>|=) |
    (?P<intervalo>\.\.) |
    (?P<simbolo>[+\-*/(),;:\.^\[\]%&]) |
    (?P<ident>[a-zA-Z_][a-zA-Z_0-9]*) |
    (?P<erro>.)
''', re.VERBOSE)

def analisar_arquivo(entrada, saida):
    #Funçao principal para ler o arquivo de entrada, identificar tokens e escrever a saida

    with open(entrada, 'r', encoding='utf-8') as arq_in, open(saida, 'w', encoding='utf-8') as arq_out:
        for numero_linha, linha in enumerate(arq_in, 1):
            pos = 0
            while pos < len(linha):
                match = regex_tokens.match(linha, pos)
                if not match:
                    pos += 1
                    continue

                grupo = match.lastgroup
                valor = match.group(grupo)
                pos = match.end()

                # Ignora espaços e comentarios
                if grupo in ('espaco', 'comentario'):
                    continue

                # Tratamento de erro: comentário nao fechado
                elif grupo == 'comentario_aberto':
                    arq_out.write(f"Linha {numero_linha}: comentario nao fechado\n")
                    return

                # Tratamento de erro: cadeia literal nao fechada
                elif grupo == 'cadeia_aberta':
                    arq_out.write(f"Linha {numero_linha}: cadeia literal nao fechada\n")
                    return

                # Cadeia literal
                elif grupo == 'cadeia':
                    arq_out.write(f"<'{valor}',CADEIA>\n")

                # Numeros
                elif grupo == 'num_real':
                    arq_out.write(f"<'{valor}',NUM_REAL>\n")
                elif grupo == 'num_int':
                    arq_out.write(f"<'{valor}',NUM_INT>\n")

                # Operadores e simbolos
                elif grupo in ('atribuicao', 'operador_relacional', 'intervalo', 'simbolo'):
                    arq_out.write(f"<'{valor}','{valor}'>\n")

                # Identificadores ou palavras reservadas
                elif grupo == 'ident':
                    if valor in palavras_reservadas:
                        arq_out.write(f"<'{valor}','{valor}'>\n")
                    else:
                        arq_out.write(f"<'{valor}',IDENT>\n")

                # Tratamento de erro generico
                elif grupo == 'erro':
                    arq_out.write(f"Linha {numero_linha}: {valor} - simbolo nao identificado\n")
                    return

# Execuçao principal
if len(sys.argv) == 3:
    entrada = sys.argv[1]
    saida = sys.argv[2]
    try:
        analisar_arquivo(entrada, saida)
    except Exception as e:
        print(e)