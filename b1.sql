-- -----------------------------------------------------
-- Schema batalhanaval
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema batalhanaval
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `batalhanaval` DEFAULT CHARACTER SET utf8 ;
USE `batalhanaval` ;

-- -----------------------------------------------------
-- Table `batalhanaval`.`jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `batalhanaval`.`jogo` (
  `idjogo` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`idjogo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `batalhanaval`.`jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `batalhanaval`.`jogador` (
  `idjogador` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `status` TINYINT NOT NULL,
  `jogo_idjogo` INT NULL,
  PRIMARY KEY (`idjogador`),
  INDEX `fk_jogador_jogo_idx` (`jogo_idjogo` ASC),
  CONSTRAINT `fk_jogador_jogo`
    FOREIGN KEY (`jogo_idjogo`)
    REFERENCES `batalhanaval`.`jogo` (`idjogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `batalhanaval`.`arma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `batalhanaval`.`arma` (
  `idarma` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `qnt` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `tamanho` INT NOT NULL,
  `jogador_idjogador` INT NOT NULL,
  PRIMARY KEY (`idarma`),
  INDEX `fk_arma_jogador1_idx` (`jogador_idjogador` ASC),
  CONSTRAINT `fk_arma_jogador1`
    FOREIGN KEY (`jogador_idjogador`)
    REFERENCES `batalhanaval`.`jogador` (`idjogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `batalhanaval`.`ataque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `batalhanaval`.`ataque` (
  `idataque` INT NOT NULL auto_increment,
  `linha` INT NOT NULL,
  `coluna` INT NOT NULL,
  `jogador_idjogador` INT NOT NULL,
  PRIMARY KEY (`idataque`),
  INDEX `fk_ataque_jogador1_idx` (`jogador_idjogador` ASC),
  CONSTRAINT `fk_ataque_jogador1`
    FOREIGN KEY (`jogador_idjogador`)
    REFERENCES `batalhanaval`.`jogador` (`idjogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `batalhanaval`.`coord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `batalhanaval`.`coord` (
  `idcoord` INT NOT NULL auto_increment,
  `linha` INT NOT NULL,
  `coluna` VARCHAR(45) NOT NULL,
  `arma_idarma` INT NOT NULL,
  PRIMARY KEY (`idcoord`),
  INDEX `fk_coord_arma1_idx` (`arma_idarma` ASC),
  CONSTRAINT `fk_coord_arma1`
    FOREIGN KEY (`arma_idarma`)
    REFERENCES `batalhanaval`.`arma` (`idarma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


