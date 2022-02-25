CREATE TABLE `estado` (
                          `id` int(11) NOT NULL PRIMARY KEY ,
                          `nome` varchar(75) DEFAULT NULL,
                          `uf` varchar(2) DEFAULT NULL,
                          `ibge` int(2) DEFAULT NULL,
                          `pais` int(3) DEFAULT NULL,
                          `ddd` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Unidades Federativas';


CREATE TABLE `cidade` (
                          `id` int(11) NOT NULL PRIMARY KEY ,
                          `nome` varchar(120) DEFAULT NULL,
                          `uf` int(2) DEFAULT NULL,
                          `ibge` int(7) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Municipios das Unidades Federativas';




