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