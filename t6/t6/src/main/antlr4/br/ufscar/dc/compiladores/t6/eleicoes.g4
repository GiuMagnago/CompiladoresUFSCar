grammar eleicoes;

programa      : (candidatoDecl | urnaDecl)+ EOF;

candidatoDecl : 'candidato' STRING;

urnaDecl      : 'urna' STRING '{' votoDecl* '}';

votoDecl      : 'voto' STRING 'em' STRING;

STRING        : '"' (~["\r\n])* '"';

COMENTARIO    : '//' ~[\r\n]* -> skip;

WS            : [ \t\r\n]+ -> skip;
