INSERT INTO deck ( title) VALUES ('Java');
INSERT INTO deck ( title) VALUES ('Python');
INSERT INTO deck ( title) VALUES ('C#');


INSERT INTO card ( front, back, fk_deck) VALUES ('Em que ano o Java foi oficialmente lançado ?', '1995', 1);
INSERT INTO card ( front, back, fk_deck) VALUES ('De onde veio o nome da linguagem Java?', 'diz-se que inspirado no café que o time de desenvolvimento consumia, oriundo da ilha de Java, e que também está presente na logomarca Java', 1);
INSERT INTO card ( front, back, fk_deck) VALUES ('Em que ano o python foi criado?', '1989', 2);

INSERT INTO tag ( name ) VALUES ('java');
INSERT INTO tag ( name ) VALUES ('programação');

-- Tags para o deck java
INSERT INTO deck_tag ( fk_deck, fk_tag ) VALUES ( 1, 1);
INSERT INTO deck_tag ( fk_deck, fk_tag ) VALUES ( 1, 2);