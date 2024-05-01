-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-05-2024 a las 17:38:13
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agencia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flight`
--

CREATE TABLE `flight` (
  `flight_code` varchar(255) NOT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `max_passengers` int(11) NOT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `seat_price` double DEFAULT NULL,
  `flight_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flight`
--

INSERT INTO `flight` (`flight_code`, `destination`, `max_passengers`, `origin`, `seat_price`, `flight_date`) VALUES
('AA123', 'Los Angeles', 200, 'Madrid', 150, '2024-04-22'),
('ABC123', 'Dorne', 100, 'El muro', 250, '2024-05-01'),
('FL123', 'Los Angeles', 200, 'New York', 150, '2024-04-22'),
('GOT001', 'King\'s Landing', 150, 'Winterfell', 300, '2024-07-15'),
('GOT002', 'Rocadragón', 180, 'Nido de aguilas', 250, '2024-08-20'),
('WD001', 'Invernalia', 200, 'Desembarco del Rey', 150, '2024-04-25'),
('WD003', 'Lanza del sol', 170, 'Pyke', 280, '2024-09-10'),
('WD005', 'Paris', 200, 'Almeria', 200, '2024-06-25'),
('WD006', 'Volantis', 200, 'Bravos', 200, '2024-10-25'),
('WD007', 'Bastión de tormentas', 200, 'Aguasdulces', 200, '2024-10-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flight_booking`
--

CREATE TABLE `flight_booking` (
  `id` bigint(20) NOT NULL,
  `flight_date` date DEFAULT NULL,
  `num_persons` int(11) NOT NULL,
  `seat_type` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `flight_flight_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flight_booking`
--

INSERT INTO `flight_booking` (`id`, `flight_date`, `num_persons`, `seat_type`, `total_price`, `flight_flight_code`) VALUES
(1, '2024-04-22', 2, 'Economy', 300, 'AA123'),
(2, '2024-04-25', 2, 'Economy', 300, 'WD001'),
(3, '2025-04-25', 1, 'Economy', 200, 'WD005'),
(4, '2025-04-25', 1, 'Economy', 200, 'WD007');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel`
--

CREATE TABLE `hotel` (
  `hotel_code` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `hotel_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hotel`
--

INSERT INTO `hotel` (`hotel_code`, `city`, `hotel_name`) VALUES
('ABC123', 'Ciudad ABC', 'Hotel ABC'),
('CASTERLY001', 'Rocadragón', 'Casterly Rock Resort'),
('CITADELA1', 'Oldtown', 'The Citadel Inn'),
('DRAGONES1', 'Dragonstone', 'The Dragon\'s Lair'),
('FRIOMURO1', 'Beyond the Wall', 'Muro'),
('PULGAS1', 'Desembarco del rey', 'Nido de pulgas'),
('TORRES1', 'Sunspear', 'Torres del Sol'),
('WINTERFELL001', NULL, 'Winterfell Inn'),
('WINTERFELL002', 'Invernalia', 'Winterfell Inn'),
('XYZ789', NULL, 'Hotel XYZ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `dni` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`dni`, `email`, `last_name`, `name`) VALUES
('123456788', 'daenerys.targaryen@dragonstone.com', 'Targaryen', 'Daenerys'),
('123456789', 'jane.doe@example.com', 'Doe', 'Jane'),
('987654311', 'jon.snow@nightswatch.com', 'Snow', 'Jon'),
('987654321', 'john.doe@example.com', 'Doe', NULL),
('A1234', 'aria.stark@nightswatch.com', 'Stark', 'Arya'),
('A123456', 'cersey@pagomisdeudas.com', 'Lannister', 'Cersey'),
('D1213', 'tyrion.lannister@casterlyrock.com', 'Lannister', 'Tyrion'),
('E1415', 'sansa.stark@winterfell.com', 'Stark', 'Sansa'),
('G1819', 'jaime.lannister@casterlyrock.com', 'Lannister', 'Jaime'),
('H2021', 'brienne.tarth@kingsguard.com', 'of Tarth', 'Brienne'),
('I2223', 'jorah.mormont@bearisland.com', 'Mormont', 'Jorah');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person_flight_booking`
--

CREATE TABLE `person_flight_booking` (
  `flight_booking_id` bigint(20) NOT NULL,
  `person_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `person_flight_booking`
--

INSERT INTO `person_flight_booking` (`flight_booking_id`, `person_id`) VALUES
(1, '123456789'),
(2, '987654311'),
(3, 'A1234'),
(4, 'D1213');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person_room_booking`
--

CREATE TABLE `person_room_booking` (
  `person_id` bigint(20) NOT NULL,
  `room_booking_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `person_room_booking`
--

INSERT INTO `person_room_booking` (`person_id`, `room_booking_id`) VALUES
(1, '123456789'),
(1, '987654321'),
(2, '987654311'),
(3, 'A1234'),
(4, 'A1234'),
(5, 'A123456'),
(5, '987654311');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
--

CREATE TABLE `room` (
  `room_code` varchar(255) NOT NULL,
  `available_from` date DEFAULT NULL,
  `available_until` date DEFAULT NULL,
  `avalaible_room` bit(1) DEFAULT NULL,
  `num_bed` int(11) NOT NULL,
  `price_per_night` double DEFAULT NULL,
  `hotel_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`room_code`, `available_from`, `available_until`, `avalaible_room`, `num_bed`, `price_per_night`, `hotel_id`) VALUES
('001', '2025-05-01', '2025-05-15', b'1', 2, 100, 'WINTERFELL002'),
('005', '2025-05-01', '2025-05-15', b'1', 2, 100, 'CASTERLY001'),
('009', '2025-05-01', '2026-05-15', b'1', 2, 100, 'PULGAS1'),
('010', '2025-05-01', '2026-05-15', b'1', 2, 100, 'PULGAS1'),
('011', '2025-05-01', '2026-05-15', NULL, 0, 100, 'PULGAS1'),
('101', '2024-05-01', '2024-05-15', b'1', 2, 100, 'ABC123'),
('103', '2025-06-01', '2025-09-30', NULL, 0, 80, 'DRAGONES1'),
('202', '2025-07-01', '2025-08-31', NULL, 0, 120, 'TORRES1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room_booking`
--

CREATE TABLE `room_booking` (
  `id` bigint(20) NOT NULL,
  `num_persons` int(11) NOT NULL,
  `room_price` double DEFAULT NULL,
  `stay_from` date DEFAULT NULL,
  `stay_until` date DEFAULT NULL,
  `room_room_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `room_booking`
--

INSERT INTO `room_booking` (`id`, `num_persons`, `room_price`, `stay_from`, `stay_until`, `room_room_code`) VALUES
(1, 2, 400, '2024-05-01', '2024-05-05', '101'),
(2, 1, 400, '2025-05-01', '2025-05-05', '001'),
(3, 1, 400, '2025-05-01', '2025-05-05', '005'),
(4, 1, 400, '2025-05-01', '2025-05-05', '009'),
(5, 2, 400, '2025-05-01', '2025-05-05', '010');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flight_code`);

--
-- Indices de la tabla `flight_booking`
--
ALTER TABLE `flight_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn9d0vm27kabrrbhw3wu91grux` (`flight_flight_code`);

--
-- Indices de la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotel_code`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `person_flight_booking`
--
ALTER TABLE `person_flight_booking`
  ADD KEY `FKntpnt1whj99aaahksije5cfa5` (`person_id`),
  ADD KEY `FK3ft08hg19j4x7nndthr6q14ip` (`flight_booking_id`);

--
-- Indices de la tabla `person_room_booking`
--
ALTER TABLE `person_room_booking`
  ADD KEY `FKe56q9mdyyoqdnouype3nb41lg` (`room_booking_id`),
  ADD KEY `FKr20s0y8qq0uvh4wa3mnrwciw6` (`person_id`);

--
-- Indices de la tabla `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_code`),
  ADD KEY `FKdosq3ww4h9m2osim6o0lugng8` (`hotel_id`);

--
-- Indices de la tabla `room_booking`
--
ALTER TABLE `room_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKld3f0t3rdtux5xyo7xat7jr7o` (`room_room_code`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `flight_booking`
--
ALTER TABLE `flight_booking`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `room_booking`
--
ALTER TABLE `room_booking`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `flight_booking`
--
ALTER TABLE `flight_booking`
  ADD CONSTRAINT `FKn9d0vm27kabrrbhw3wu91grux` FOREIGN KEY (`flight_flight_code`) REFERENCES `flight` (`flight_code`);

--
-- Filtros para la tabla `person_flight_booking`
--
ALTER TABLE `person_flight_booking`
  ADD CONSTRAINT `FK3ft08hg19j4x7nndthr6q14ip` FOREIGN KEY (`flight_booking_id`) REFERENCES `flight_booking` (`id`),
  ADD CONSTRAINT `FKntpnt1whj99aaahksije5cfa5` FOREIGN KEY (`person_id`) REFERENCES `person` (`dni`);

--
-- Filtros para la tabla `person_room_booking`
--
ALTER TABLE `person_room_booking`
  ADD CONSTRAINT `FKe56q9mdyyoqdnouype3nb41lg` FOREIGN KEY (`room_booking_id`) REFERENCES `person` (`dni`),
  ADD CONSTRAINT `FKr20s0y8qq0uvh4wa3mnrwciw6` FOREIGN KEY (`person_id`) REFERENCES `room_booking` (`id`);

--
-- Filtros para la tabla `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FKdosq3ww4h9m2osim6o0lugng8` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_code`);

--
-- Filtros para la tabla `room_booking`
--
ALTER TABLE `room_booking`
  ADD CONSTRAINT `FKld3f0t3rdtux5xyo7xat7jr7o` FOREIGN KEY (`room_room_code`) REFERENCES `room` (`room_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
