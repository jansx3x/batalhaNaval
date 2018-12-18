delimiter |
CREATE TRIGGER novojogo AFTER INSERT ON jogo FOR EACH ROW
BEGIN
UPDATE jogador SET jogo_idjogo = (new.idjogo) where idjogador = 1 or idjogador = 2;
END
|

delimiter |
CREATE TRIGGER novoataque BEFORE UPDATE ON jogador FOR EACH ROW
BEGIN
DELETE FROM ataque WHERE jogador_idjogador = 1;
DELETE FROM ataque WHERE jogador_idjogador = 2;
END 
|