-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-04-2023 a las 23:37:45
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practica1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`dni`, `nombre`) VALUES
('11112222e', 'añlkdf'),
('12345678a', 'anartz'),
('13458374i', 'dfdf'),
('99990000a', 'we');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrovuelos`
--

CREATE TABLE `registrovuelos` (
  `id` int(11) NOT NULL,
  `cod_vuelo` varchar(100) NOT NULL,
  `dni` varchar(100) NOT NULL,
  `tipoPlaza` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `registrovuelos`
--

INSERT INTO `registrovuelos` (`id`, `cod_vuelo`, `dni`, `tipoPlaza`) VALUES
(2, 'QWE1-12345', '12345678a', 'plazasTuristas'),
(3, 'QWE1-12345', '11112222e', 'plazasTuristas'),
(4, 'QWE1-12345', '99990000a', 'plazasTuristas'),
(5, 'ASD3-12345', '11112222e', 'plazasPrimera'),
(7, 'ASD3-12345', '99990000a', 'plazasTuristas'),
(8, 'QWE1-12345', '13458374i', 'plazasTuristas'),
(9, 'ASD3-12345', '11112222e', 'plazasTuristas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `cod_vuelo` varchar(10) NOT NULL,
  `fechaSalida` date NOT NULL,
  `destino` varchar(50) NOT NULL,
  `procedencia` varchar(50) NOT NULL,
  `plazasTuristas` int(3) NOT NULL,
  `plazasPrimera` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`cod_vuelo`, `fechaSalida`, `destino`, `procedencia`, `plazasTuristas`, `plazasPrimera`) VALUES
('ASD3-12345', '2022-10-10', 'DFD', 'DFDSF', 3, 1),
('LKA1-13456', '2001-10-10', 'dfdsf', 'dfsdf', 14, 14),
('QWE1-12345', '2000-10-10', 'DFD', 'FDSFSD', 4, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `registrovuelos`
--
ALTER TABLE `registrovuelos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reg_dni_fk` (`dni`),
  ADD KEY `reg_cod_fk` (`cod_vuelo`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`cod_vuelo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registrovuelos`
--
ALTER TABLE `registrovuelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `registrovuelos`
--
ALTER TABLE `registrovuelos`
  ADD CONSTRAINT `reg_cod_fk` FOREIGN KEY (`cod_vuelo`) REFERENCES `vuelos` (`cod_vuelo`),
  ADD CONSTRAINT `reg_dni_fk` FOREIGN KEY (`dni`) REFERENCES `pasajeros` (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
