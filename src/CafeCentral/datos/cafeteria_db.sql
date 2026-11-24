DROP DATABASE IF EXISTS cafeteria_db;
CREATE DATABASE cafeteria_db CHARACTER SET utf8mb4;
USE cafeteria_db;

CREATE TABLE productos (
codigo VARCHAR(20) PRIMARY KEY,
nombre VARCHAR(80) NOT NULL,
tipo ENUM('BEBIDA','ALIMENTO') NOT NULL,
precio_base DECIMAL(10,2) NOT NULL,
stock INT NOT NULL


CONSTRAINT ck_stock CHECK (stock > 0)
);
--
-- CREATE TABLE pedidos (
-- 	id_pedido INT NOT NULL AUTO_INCREMENT,
--    codigo_producto VARCHAR(20) NOT NULL,
--    nombre_cliente VARCHAR(80)  NOT NULL,
--  cantidad INT NOT NULL,
-- 	total DECIMAL(10,2) NOT NULL,
--    CONSTRAINT ck_total CHECK (total > 0),
--  CONSTRAINT ck_cantidad CHECK (cantidad > 0)
--  );




CREATE USER IF NOT EXISTS'definer'@'localhost' IDENTIFIED BY 'definer#2026';
GRANT SELECT, INSERT, UPDATE ON cafeteria_db.productos TO 'definer'@'localhost';
GRANT EXECUTE ON productos_db.* TO 'definer'@'localhost';

CREATE USER IF NOT EXISTS 'act_app'@'localhost' IDENTIFIED BY 'CLave#147546';
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'act_app'@'localhost';


DELIMITER $$
CREATE DEFINER='definer'@'localhost' PROCEDURE sp_listar_producto()
SQL SECURITY DEFINER
BEGIN
SELECT codigo, nombre, tipo, precio_base, stock;
END$$

CREATE DEFINER='definer'@'localhost' PROCEDURE sp_insertar_productos(IN p_codigo VARCHAR(20),
IN p_nombre VARCHAR(80), IN p_tipo VARCHAR(40), IN p_precio_base DECIMAL(10,2), IN p_stock INT)
SQL SECURITY DEFINER
BEGIN
	IF EXISTS (SELECT 1 FROM actividad WHERE codigo = p_codigo) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ya existe un producto con ese código';
END IF;
INSERT INTO productos (codigo, nombre, tipo, precio_base, stock)
VALUES (p_codigo, p_nombre, p_tipo, p_precio_base, p_stock);
END$$

CREATE DEFINER='definer'@'localhost' PROCEDURE sp_actualizar_productos(
IN p_codigo VARCHAR(20), IN p_stock INT)
SQL SECURITY DEFINER
BEGIN
	IF NOT EXISTS (SELECT 1 FROM productos WHERE codigo = p_codigo) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe el producto';
END IF;
UPDATE productos SET stock = p_stock WHERE codigo = p_codigo;

END$$

DELIMITER $$

GRANT EXECUTE ON PROCEDURE cafeteria_db.sp_listar_productos TO 'act_app'@'localhost';
GRANT EXECUTE ON PROCEDURE cafeteria_db.sp_insertar_productos TO 'act_app'@'localhost';
GRANT EXECUTE ON PROCEDURE cafeteria_db.sp_actualizar_productos TO 'act_app'@'localhost';
FLUSH PRIVILEGES;


 -- CALL sp_listar_productos('A01','Coca Cola', "BEBIDA", 1300,00, 5);

