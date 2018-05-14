-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14-Maio-2018 às 18:57
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistemappc`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_atas`
--

CREATE TABLE `tb_atas` (
  `id` int(11) NOT NULL,
  `data` int(11) NOT NULL,
  `local` varchar(300) NOT NULL,
  `participantes` varchar(300) NOT NULL,
  `deliberacoes` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_atas`
--

INSERT INTO `tb_atas` (`id`, `data`, `local`, `participantes`, `deliberacoes`) VALUES
(1, 0, 'Brasília', 'Juliana ', 'ahsdkjfh kashdfkj haskjdhfkjasd');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_bibliografia`
--

CREATE TABLE `tb_bibliografia` (
  `id` int(11) NOT NULL,
  `cursos` varchar(300) NOT NULL,
  `disciplinas` varchar(300) NOT NULL,
  `titulo` varchar(300) NOT NULL,
  `autor` varchar(300) NOT NULL,
  `ano` int(11) NOT NULL,
  `isbn` varchar(300) NOT NULL,
  `editora` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cronograma`
--

CREATE TABLE `tb_cronograma` (
  `id` int(11) NOT NULL,
  `aula` int(11) NOT NULL,
  `conteudo` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_cronograma`
--

INSERT INTO `tb_cronograma` (`id`, `aula`, `conteudo`) VALUES
(1, 0, 'hjhkhkh');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_curso`
--

CREATE TABLE `tb_curso` (
  `id` int(11) NOT NULL,
  `tipo` varchar(300) NOT NULL,
  `modalidade` varchar(300) NOT NULL,
  `denominacao` varchar(300) NOT NULL,
  `habilitacao` varchar(300) NOT NULL,
  `localOferta` varchar(300) NOT NULL,
  `matutino` tinyint(1) NOT NULL,
  `vespertino` tinyint(1) NOT NULL,
  `noturno` tinyint(1) NOT NULL,
  `vagasTurno` int(11) NOT NULL,
  `cargaHoraria` int(11) NOT NULL,
  `regimeLetivo` varchar(300) NOT NULL,
  `periodo` varchar(300) NOT NULL,
  `nomeProfessor` varchar(300) NOT NULL,
  `cpf` int(11) NOT NULL,
  `titulacao` varchar(300) NOT NULL,
  `tempoDedicacao` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_curso`
--

INSERT INTO `tb_curso` (`id`, `tipo`, `modalidade`, `denominacao`, `habilitacao`, `localOferta`, `matutino`, `vespertino`, `noturno`, `vagasTurno`, `cargaHoraria`, `regimeLetivo`, `periodo`, `nomeProfessor`, `cpf`, `titulacao`, `tempoDedicacao`) VALUES
(1, 'ajsdkfjas', 'ljalskdjf', 'akhsdkf', 'kahsdjf', 'akhsdjf', 1, 1, 0, 0, 0, 'aklsdjflas', 'jaskdfj', '', 0, 'ajsdkjf', 'asjlkd');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_disciplinas`
--

CREATE TABLE `tb_disciplinas` (
  `id` int(11) NOT NULL,
  `nome` varchar(300) NOT NULL,
  `cod` int(11) NOT NULL,
  `descricao` varchar(700) NOT NULL,
  `semestre` int(11) NOT NULL,
  `cargaHoraria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_disciplinas`
--

INSERT INTO `tb_disciplinas` (`id`, `nome`, `cod`, `descricao`, `semestre`, `cargaHoraria`) VALUES
(1, 'Matemática Básica', 1320, 'kadsjfhasdhfa', 1, 60);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_planoensino`
--

CREATE TABLE `tb_planoensino` (
  `id` int(11) NOT NULL,
  `curso` varchar(300) NOT NULL,
  `ano` int(11) NOT NULL,
  `semestre` int(11) NOT NULL,
  `disciplina` varchar(300) NOT NULL,
  `cargaHoraria` int(11) NOT NULL,
  `periodoCurso` varchar(300) NOT NULL,
  `professor` varchar(300) NOT NULL,
  `ementa` text NOT NULL,
  `competenciasHabilidades` text NOT NULL,
  `metodologiaEnsino` text NOT NULL,
  `avaliacao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_planoensino`
--

INSERT INTO `tb_planoensino` (`id`, `curso`, `ano`, `semestre`, `disciplina`, `cargaHoraria`, `periodoCurso`, `professor`, `ementa`, `competenciasHabilidades`, `metodologiaEnsino`, `avaliacao`) VALUES
(1, 'akhsdkf', 0, 0, 'Matemática Básica', 0, 'ssd', '', 'asdf', 'adfas', 'asfas', 'asdf');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_professor`
--

CREATE TABLE `tb_professor` (
  `id` int(11) NOT NULL,
  `nome` varchar(300) NOT NULL,
  `cpf` int(11) NOT NULL,
  `maiorTitulacao` varchar(300) NOT NULL,
  `areaFormacao` varchar(300) NOT NULL,
  `curriculo` varchar(300) NOT NULL,
  `dataAtualizacao` varchar(100) NOT NULL,
  `matricula` int(11) NOT NULL,
  `dataAdmissao` varchar(100) NOT NULL,
  `horasNDE` int(11) NOT NULL,
  `horasOrientacaoTCC` int(11) NOT NULL,
  `horasCordenacaoCurso` int(11) NOT NULL,
  `horasCordenacaoOutrosCurso` int(11) NOT NULL,
  `horasPesquisa` int(11) NOT NULL,
  `horasExtraClasseCurso` int(11) NOT NULL,
  `horasExtraClasseOutrosCurso` int(11) NOT NULL,
  `horasCurso` int(11) NOT NULL,
  `horasOutrosCurso` int(11) NOT NULL,
  `disciplinaCurso` int(11) NOT NULL,
  `cargaHorariaCurso` int(11) NOT NULL,
  `disciplinaOutrosCurso` int(11) NOT NULL,
  `cargaHorariaOutrosCurso` int(11) NOT NULL,
  `membroNDE` tinyint(1) NOT NULL,
  `membroColegiado` tinyint(1) NOT NULL,
  `experienciaPedagogia` tinyint(1) NOT NULL,
  `tempoVinculoCurso` varchar(100) NOT NULL,
  `experienciaMagisterioSuperior` varchar(100) NOT NULL,
  `experienciaCursoDistancia` varchar(100) NOT NULL,
  `experienciaProfissional` varchar(100) NOT NULL,
  `participacaoEventos` int(11) NOT NULL,
  `artigoCientificoArea` int(11) NOT NULL,
  `artigoCientificoOutrasArea` int(11) NOT NULL,
  `livrosCapitulosArea` int(11) NOT NULL,
  `livrosCapitulosOutrasArea` int(11) NOT NULL,
  `trabalhoAnaisArea` int(11) NOT NULL,
  `trabalhoAnaisOutrasArea` int(11) NOT NULL,
  `propriedadeIntelectualArea` int(11) NOT NULL,
  `propriedadeIntelectualOutrasArea` int(11) NOT NULL,
  `traducoesPublicadas` int(11) NOT NULL,
  `projetoTenicaArtistaCultural` int(11) NOT NULL,
  `producoesDidaticoPedagogico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_atas`
--
ALTER TABLE `tb_atas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_bibliografia`
--
ALTER TABLE `tb_bibliografia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_cronograma`
--
ALTER TABLE `tb_cronograma`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_curso`
--
ALTER TABLE `tb_curso`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_disciplinas`
--
ALTER TABLE `tb_disciplinas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_planoensino`
--
ALTER TABLE `tb_planoensino`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_professor`
--
ALTER TABLE `tb_professor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_atas`
--
ALTER TABLE `tb_atas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_bibliografia`
--
ALTER TABLE `tb_bibliografia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_cronograma`
--
ALTER TABLE `tb_cronograma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_curso`
--
ALTER TABLE `tb_curso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_disciplinas`
--
ALTER TABLE `tb_disciplinas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_planoensino`
--
ALTER TABLE `tb_planoensino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_professor`
--
ALTER TABLE `tb_professor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
