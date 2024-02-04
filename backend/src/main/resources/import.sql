 -- DECKS
INSERT INTO deck ( title) VALUES ('Java');
INSERT INTO deck ( title) VALUES ('Python');
INSERT INTO deck ( title) VALUES ('PHP');

--TAGS
INSERT INTO tag ( name ) VALUES ('java');
INSERT INTO tag ( name ) VALUES ('python');
INSERT INTO tag ( name ) VALUES ('web');
INSERT INTO tag ( name ) VALUES ('desktop');

-- CARDS Java
INSERT INTO card ( front, back, fk_deck) VALUES ('Qual é a principal característica da plataforma Java?', 'É uma linguagem interpretada', 1);
INSERT INTO card ( front, back, fk_deck) VALUES ('O que é um "objeto"?', 'Uma instância de uma classe', 1);
INSERT INTO card ( front, back, fk_deck) VALUES ('O que é um "construtor" e qual é sua principal finalidade?', 'Um método especial que inicializa um objeto quando uma instância da classe é criada.', 1);
INSERT INTO card ( front, back, fk_deck) VALUES ('Exemplifique a forma de declarar um método:', 'void nomeDoMetodo() { }', 1);
INSERT INTO card ( front, back, fk_deck) VALUES ('O que é o conceito de "herança"?', 'É a capacidade de uma classe herdar métodos e atributos de outra classe', 1);

-- CARDS Python
INSERT INTO card ( front, back, fk_deck) VALUES ('Qual é a principal característica da linguagem Python?', 'É uma linguagem interpretada', 2);
INSERT INTO card ( front, back, fk_deck) VALUES ('Como se faz a leitura de entrada do usuário ', 'input()', 2);
INSERT INTO card ( front, back, fk_deck) VALUES ('O que é um dicionário', 'Uma coleção de pares chave-valor', 2);
INSERT INTO card ( front, back, fk_deck) VALUES ('Exemplifique a definição de uma função:', 'def nomeDaFuncao():', 2);
INSERT INTO card ( front, back, fk_deck) VALUES ('Como se faz a declaração de um loop "for"', 'for elemento in lista:', 2);

-- CARDS PHP
INSERT INTO card ( front, back, fk_deck) VALUES ('Qual é o principal objetivo do PHP?', 'Construção de páginas web dinâmicas', 3);
INSERT INTO card ( front, back, fk_deck) VALUES ('Qual é a função da instrução "echo"?', 'Imprimir texto no navegador', 3);
INSERT INTO card ( front, back, fk_deck) VALUES ('O que é uma sessão?', 'Uma forma de armazenar informações do usuário entre requisições', 3);
INSERT INTO card ( front, back, fk_deck) VALUES ('Como se define uma constante?', 'define("NOME_CONSTANTE", "Valor");', 3);
INSERT INTO card ( front, back, fk_deck) VALUES ('O que faz a função "header()"?', 'Cria um cabeçalho HTTP', 3);

-- Associando tags
-- Tags para o deck java
INSERT INTO deck_tag ( fk_deck, fk_tag ) VALUES ( 1, 1);
INSERT INTO deck_tag ( fk_deck, fk_tag ) VALUES ( 1, 4);

-- Tags para o deck python
INSERT INTO deck_tag ( fk_deck, fk_tag ) VALUES ( 2, 2);
INSERT INTO deck_tag ( fk_deck, fk_tag ) VALUES ( 2, 4);

-- Tags para o deck php
INSERT INTO deck_tag ( fk_deck, fk_tag ) VALUES ( 3, 3);