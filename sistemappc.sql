-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 20-Maio-2018 às 19:06
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.8

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
  `id_atas` int(8) NOT NULL,
  `data` int(11) NOT NULL,
  `local` varchar(255) NOT NULL,
  `participantes` varchar(255) NOT NULL,
  `deliberacoes` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_atas`
--

INSERT INTO `tb_atas` (`id_atas`, `data`, `local`, `participantes`, `deliberacoes`) VALUES
(1, 172384182, 'Brasília', 'Nome de Verdade', 'kasdbfkjabskd'),
(2, 1341, 'jadkfklasdf', 'kajdskljfladsjfas', 'ajdskfjaklsdjfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),
(3, 1, '1', '1', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_bibliografia`
--

CREATE TABLE `tb_bibliografia` (
  `id_bibliografia` int(8) NOT NULL,
  `cursos` varchar(100) NOT NULL,
  `disciplinas` varchar(100) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(255) NOT NULL,
  `ano` int(15) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `editora` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_bibliografia`
--

INSERT INTO `tb_bibliografia` (`id_bibliografia`, `cursos`, `disciplinas`, `titulo`, `autor`, `ano`, `isbn`, `editora`) VALUES
(1, 'Tipo', 'adfadsf', 'Blá blá', 'Autor', 1995, 'kahdfads', 'TK'),
(2, 'Tipo', 'adfadsf', 'jaksdjfldskjf', 'lajsdkfjalds', 123, 'alsdjfka', 'lajsdfklas'),
(4, 'Tipo', 'adfadsf', '1', '1', 1, '1', '1'),
(5, 'Curso de Verdade', 'Matemática', '1', '11', 1, '1', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cronograma`
--

CREATE TABLE `tb_cronograma` (
  `id_cronograma` int(8) NOT NULL,
  `aula` int(8) NOT NULL,
  `conteudo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_cronograma`
--

INSERT INTO `tb_cronograma` (`id_cronograma`, `aula`, `conteudo`) VALUES
(1, 4, 'Windows'),
(2, 4, '1'),
(3, 5, 'asdasd');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_curso`
--

CREATE TABLE `tb_curso` (
  `id_curso` int(8) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `modalidade` varchar(100) NOT NULL,
  `denominacao` varchar(100) NOT NULL,
  `habilitacao` varchar(100) NOT NULL,
  `localOferta` varchar(100) NOT NULL,
  `matutino` tinyint(1) NOT NULL,
  `vespertino` tinyint(1) NOT NULL,
  `noturno` tinyint(1) NOT NULL,
  `vagasTurno` int(8) NOT NULL,
  `cargaHoraria` int(8) NOT NULL,
  `regimeLetivo` varchar(100) NOT NULL,
  `periodo` varchar(100) NOT NULL,
  `nomeProfessor` varchar(100) NOT NULL,
  `cpf` bigint(16) NOT NULL,
  `titulacao` varchar(100) NOT NULL,
  `tempoDedicacao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_curso`
--

INSERT INTO `tb_curso` (`id_curso`, `tipo`, `modalidade`, `denominacao`, `habilitacao`, `localOferta`, `matutino`, `vespertino`, `noturno`, `vagasTurno`, `cargaHoraria`, `regimeLetivo`, `periodo`, `nomeProfessor`, `cpf`, `titulacao`, `tempoDedicacao`) VALUES
(1, '1', '1', 'Curso de Verdade', '1', '1', 1, 1, 1, 1, 1, '1', '1', 'Item 1', 1, '1', '1'),
(3, '1', '1', 'Curso de Verdade tambem', '1', '1', 1, 1, 0, 1, 1, '1', '11', 'Item 2', 1, '1', '1'),
(4, '1', '1', 'Nome Dele', '1', '1', 1, 1, 0, 1, 1, '1', '1', 'Item 1', 1, '1', '1'),
(7, '1', '1', '1', '1', '1', 1, 0, 0, 0, 1, '1', '1', '1', 1, '1', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_disciplinas`
--

CREATE TABLE `tb_disciplinas` (
  `id_disciplinas` int(8) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cod` int(11) NOT NULL,
  `descricao` varchar(1000) NOT NULL,
  `semestre` int(8) NOT NULL,
  `cargaHoraria` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_disciplinas`
--

INSERT INTO `tb_disciplinas` (`id_disciplinas`, `nome`, `cod`, `descricao`, `semestre`, `cargaHoraria`) VALUES
(1, 'Banco de Dados', 123, 'asdfasd', 2, 90),
(2, 'Matemática', 12341, 'nasdfasdfasdk', 3, 90),
(3, 'Procrastinação', 42069, 'Bla', 2, 200);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_planoensino`
--

CREATE TABLE `tb_planoensino` (
  `id_plano` int(8) NOT NULL,
  `curso` varchar(100) NOT NULL,
  `ano` int(15) NOT NULL,
  `semestre` int(8) NOT NULL,
  `disciplina` varchar(100) NOT NULL,
  `cargaHoraria` int(8) NOT NULL,
  `periodoCurso` varchar(100) NOT NULL,
  `professor` varchar(100) NOT NULL,
  `ementa` varchar(1000) NOT NULL,
  `competenciasHabilidades` varchar(1000) NOT NULL,
  `metodologiaEnsino` varchar(1000) NOT NULL,
  `avaliacao` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_planoensino`
--

INSERT INTO `tb_planoensino` (`id_plano`, `curso`, `ano`, `semestre`, `disciplina`, `cargaHoraria`, `periodoCurso`, `professor`, `ementa`, `competenciasHabilidades`, `metodologiaEnsino`, `avaliacao`) VALUES
(1, 'Curso previamente cadastrado', 2017, 3, 'Disciplina previamente cadastrada', 90, 'Noite', 'Professor previamente cadastrado', 'Descreva a ementa do curso!', 'Descreva as competências e habilidades a serem adquiridas no curso!', 'Descreva as técnicas e recursos de metodologia do curso!', 'Critérios de avaliação!'),
(2, 'Curso previamente cadastrado', 2, 2, 'Disciplina previamente cadastrada', 999, '2', 'Professor previamente cadastrado', 'Descreva a ementa do curso!', 'Descreva as competências e habilidades a serem adquiridas no curso!', 'Descreva as técnicas e recursos de metodologia do curso!', 'Critérios de avaliação!');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_ppc`
--

CREATE TABLE `tb_ppc` (
  `id_ppc` int(8) NOT NULL,
  `cursoPPC` varchar(1000) NOT NULL,
  `perfilCurso` varchar(1000) NOT NULL,
  `perfilEgresso` varchar(1000) NOT NULL,
  `formaAcesso` varchar(1000) NOT NULL,
  `representacao` varchar(1000) NOT NULL,
  `avaliacaoProcesso` varchar(1000) NOT NULL,
  `avaliacaoProjeto` varchar(1000) NOT NULL,
  `horasTCC` int(8) NOT NULL,
  `horasEstagio` int(8) NOT NULL,
  `politicaDeAtendimento` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_ppc`
--

INSERT INTO `tb_ppc` (`id_ppc`, `cursoPPC`, `perfilCurso`, `perfilEgresso`, `formaAcesso`, `representacao`, `avaliacaoProcesso`, `avaliacaoProjeto`, `horasTCC`, `horasEstagio`, `politicaDeAtendimento`) VALUES
(2, 'Item 1', 'Algo', 'Esta', 'Escrito', 'Aqui', 'Diferente', 'de', 2000, 150, 'Antes'),
(3, 'Item 1', '1	1	', '11', '1', '1', '1', '1', 1, 1, '1'),
(4, 'Item 1', '1	1	1', '1', '1', '1', '1', '1', 1, 1, '1'),
(5, 'Curso de Verdade', '78', '6876', '876', '876', '876', '876', 876, 876, '876'),
(6, 'Curso de Verdade', '1', '1', '1', '1', '1', '1', 1, 1, '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_professor`
--

CREATE TABLE `tb_professor` (
  `id_professor` int(8) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` bigint(16) NOT NULL,
  `maiorTitulacao` varchar(100) NOT NULL,
  `areaFormacao` varchar(100) NOT NULL,
  `curriculo` varchar(100) NOT NULL,
  `dataAtualizacao` varchar(100) NOT NULL,
  `matricula` int(8) NOT NULL,
  `dataAdimissao` varchar(100) NOT NULL,
  `horasNDE` int(8) NOT NULL,
  `horasOrientacaoTCC` int(8) NOT NULL,
  `horasCordenacaoCurso` int(8) NOT NULL,
  `horasCordenacaoOutrosCurso` int(8) NOT NULL,
  `horasPesquisa` int(8) NOT NULL,
  `horasExtraClasseCurso` int(8) NOT NULL,
  `horasExtraClasseOutrosCurso` int(8) NOT NULL,
  `horasCurso` int(8) NOT NULL,
  `horasOutrosCurso` int(8) NOT NULL,
  `disciplinaCurso` int(8) NOT NULL,
  `cargaHorariaCurso` int(8) NOT NULL,
  `disciplinaOutrosCurso` int(8) NOT NULL,
  `cargaHorariaOutrosCurso` int(8) NOT NULL,
  `membroNDE` tinyint(1) NOT NULL,
  `membroColegiado` tinyint(1) NOT NULL,
  `experienciaPedagogia` tinyint(1) NOT NULL,
  `dataInicialVinculoCurso` int(11) NOT NULL,
  `tempoVinculoCurso` varchar(100) NOT NULL,
  `dataInicialMagisterioSuperior` int(11) NOT NULL,
  `experienciaMagisterioSuperior` varchar(100) NOT NULL,
  `dataInicialCursoDistancia` int(11) NOT NULL,
  `experienciaCursoDistancia` varchar(100) NOT NULL,
  `dataInicialExperienciaProfissional` int(11) NOT NULL,
  `experienciaProfissional` varchar(100) NOT NULL,
  `participacaoEventos` int(8) NOT NULL,
  `artigoCientificoArea` int(8) NOT NULL,
  `artigoCientificoOutrasArea` int(8) NOT NULL,
  `livrosCapitulosArea` int(8) NOT NULL,
  `livrosCapitulosOutrasArea` int(8) NOT NULL,
  `trabalhoAnaisArea` int(8) NOT NULL,
  `trabalhoAnaisOutrasArea` int(8) NOT NULL,
  `propriedadeIntelectualArea` int(8) NOT NULL,
  `propriedadeIntelectualOutrasArea` int(8) NOT NULL,
  `traducoesPublicadas` int(8) NOT NULL,
  `projetoTecnicaArtisticaCultural` int(8) NOT NULL,
  `producoesDidaticoPedagogico` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_professor`
--

INSERT INTO `tb_professor` (`id_professor`, `nome`, `cpf`, `maiorTitulacao`, `areaFormacao`, `curriculo`, `dataAtualizacao`, `matricula`, `dataAdimissao`, `horasNDE`, `horasOrientacaoTCC`, `horasCordenacaoCurso`, `horasCordenacaoOutrosCurso`, `horasPesquisa`, `horasExtraClasseCurso`, `horasExtraClasseOutrosCurso`, `horasCurso`, `horasOutrosCurso`, `disciplinaCurso`, `cargaHorariaCurso`, `disciplinaOutrosCurso`, `cargaHorariaOutrosCurso`, `membroNDE`, `membroColegiado`, `experienciaPedagogia`, `dataInicialVinculoCurso`, `tempoVinculoCurso`, `dataInicialMagisterioSuperior`, `experienciaMagisterioSuperior`, `dataInicialCursoDistancia`, `experienciaCursoDistancia`, `dataInicialExperienciaProfissional`, `experienciaProfissional`, `participacaoEventos`, `artigoCientificoArea`, `artigoCientificoOutrasArea`, `livrosCapitulosArea`, `livrosCapitulosOutrasArea`, `trabalhoAnaisArea`, `trabalhoAnaisOutrasArea`, `propriedadeIntelectualArea`, `propriedadeIntelectualOutrasArea`, `traducoesPublicadas`, `projetoTecnicaArtisticaCultural`, `producoesDidaticoPedagogico`) VALUES
(1, '1', 1, '1', '1', '1', '1', 1, '1', 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 'DD/MM/AAAA1', 0, 'DD/MM/AAAA12', 0, 'DD/MM/AAAA3', 0, 'DD/MM/AAAA4', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, '1', 1, '1', '1', '1', '1', 1, '1', 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, '1', 1, '1', 1, '1', 1, '1', 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_atas`
--
ALTER TABLE `tb_atas`
  ADD PRIMARY KEY (`id_atas`);

--
-- Indexes for table `tb_bibliografia`
--
ALTER TABLE `tb_bibliografia`
  ADD PRIMARY KEY (`id_bibliografia`);

--
-- Indexes for table `tb_cronograma`
--
ALTER TABLE `tb_cronograma`
  ADD PRIMARY KEY (`id_cronograma`);

--
-- Indexes for table `tb_curso`
--
ALTER TABLE `tb_curso`
  ADD PRIMARY KEY (`id_curso`);

--
-- Indexes for table `tb_disciplinas`
--
ALTER TABLE `tb_disciplinas`
  ADD PRIMARY KEY (`id_disciplinas`);

--
-- Indexes for table `tb_planoensino`
--
ALTER TABLE `tb_planoensino`
  ADD PRIMARY KEY (`id_plano`);

--
-- Indexes for table `tb_ppc`
--
ALTER TABLE `tb_ppc`
  ADD PRIMARY KEY (`id_ppc`);

--
-- Indexes for table `tb_professor`
--
ALTER TABLE `tb_professor`
  ADD PRIMARY KEY (`id_professor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_atas`
--
ALTER TABLE `tb_atas`
  MODIFY `id_atas` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_bibliografia`
--
ALTER TABLE `tb_bibliografia`
  MODIFY `id_bibliografia` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tb_cronograma`
--
ALTER TABLE `tb_cronograma`
  MODIFY `id_cronograma` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_curso`
--
ALTER TABLE `tb_curso`
  MODIFY `id_curso` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_disciplinas`
--
ALTER TABLE `tb_disciplinas`
  MODIFY `id_disciplinas` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_planoensino`
--
ALTER TABLE `tb_planoensino`
  MODIFY `id_plano` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tb_ppc`
--
ALTER TABLE `tb_ppc`
  MODIFY `id_ppc` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tb_professor`
--
ALTER TABLE `tb_professor`
  MODIFY `id_professor` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
