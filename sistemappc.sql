-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 11-Jun-2018 às 01:46
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
  `data` date NOT NULL,
  `local` varchar(255) NOT NULL,
  `participantes` varchar(255) NOT NULL,
  `deliberacoes` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_atas`
--

INSERT INTO `tb_atas` (`id_atas`, `data`, `local`, `participantes`, `deliberacoes`) VALUES
(6, '2018-01-04', 'IESB Norte', 'Coordenador João, Professor Pedro, Professora Maria', 'Foi deliberado que todos projetos de Projeto Integrador III na turma de 2018/01 foram excelentes.');

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
(6, 'Curso de Verdade', 'Banco de Dados90', 'Livro de Banco de Dados', 'Professor João', 1998, '978', 'Editora Informática'),
(7, 'Analise e Desenvolvimento de Sistemas', 'Lógica de Programação120', 'Lógica de Programação Crie seus primeiros programas usando Javascript e HTML', 'Paulo Silveira, Adriano Almeida', 2016, '978-85-66250-22-0', 'Casa do Código');

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
(2, 1, 'Lógica utilizando a Torre de Hanoi');

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
(4, 'Tecnólogo', 'EAD', 'Analise e Desenvolvimento de Sistemas', '?', 'IESB Sul', 1, 1, 0, 30, 2000, 'Semestral', '5', 'João Paulo Souza', 1010, 'Mestrado', '?');

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
(4, 'Lógica de Programação', 154, 'Evidentemente, a hegemonia do ambiente político estimula a padronização dos modos de operação convencionais. ', 1, 120);

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
(3, 'Analise e Desenvolvimento de Sistemas', 2018, 1, 'Banco de Dados90', 120, 'EAD', 'João Paulo Souza', 'As experiências acumuladas demonstram que o surgimento do comércio virtual assume importantes posições no estabelecimento dos índices pretendidos. O incentivo ao avanço tecnológico, assim como a execução dos pontos do programa exige a precisão e a definição das diretrizes de desenvolvimento para o futuro.\r\n\r\nNão obstante, o novo modelo estrutural aqui preconizado pode nos levar a considerar a reestruturação dos relacionamentos verticais entre as hierarquias. No entanto, não podemos esquecer que a valorização de fatores subjetivos representa uma abertura para a melhoria do processo de comunicação como um todo. \r\n', ' Por outro lado;\r\nRevolução dos costumes;\r\nAlavancagem dos níveis;\r\nMotivação departamental;', 'Gostaria de enfatizar que o aumento do diálogo entre os diferentes setores produtivos maximiza as possibilidades por conta das novas proposições. Todavia, a mobilidade dos capitais internacionais prepara-nos para enfrentar situações atípicas decorrentes do retorno esperado a longo prazo. O empenho em analisar a necessidade de renovação processual acarreta um processo de reformulação e modernização de todos os recursos funcionais envolvidos. Assim mesmo, a percepção das dificuldades oferece uma interessante oportunidade para verificação das regras de conduta normativas. \r\n', 'Percebemos, cada vez mais, que a determinação clara de objetivos causa impacto indireto na reavaliação das direções preferenciais no sentido do progresso. O cuidado em identificar pontos críticos no fenômeno da Internet facilita a criação dos procedimentos normalmente adotados. Caros amigos, a competitividade nas transações comerciais desafia a capacidade de equalização do fluxo de informações. Pensando mais a longo prazo, o desafiador cenário globalizado possibilita uma melhor visão global do levantamento das variáveis envolvidas. \r\n');

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
(4, 'Analise e Desenvolvimento de Sistemas', 'É importante questionar o quanto o desenvolvimento contínuo de distintas formas de atuação faz parte de um processo de gerenciamento das condições inegavelmente apropriadas.', 'Neste sentido, a complexidade dos estudos efetuados apresenta tendências no sentido de aprovar a manutenção das formas de ação. ', 'Do mesmo modo, o início da atividade geral de formação de atitudes não pode mais se dissociar do orçamento setorial. ', 'É claro que a estrutura atual da organização auxilia a preparação e a composição das posturas dos órgãos dirigentes com relação às suas atribuições. \r\n', 'A prática cotidiana prova que a contínua expansão de nossa atividade garante a contribuição de um grupo importante na determinação das condições financeiras e administrativas exigidas. ', 'Desta maneira, a crescente influência da mídia nos obriga à análise dos paradigmas corporativos. ', 360, 100, 'Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a constante divulgação das informações obstaculiza a apreciação da importância do remanejamento dos quadros funcionais.');

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
(4, 'João Paulo Souza', 1101, 'Mestrado', 'Informatica', 'curriculo.com/joao', '2018', 1245752, '2010', 20, 10, 50, 0, 20, 4, 8, 16, 20, 0, 0, 0, 0, 1, 0, 1, 2010, '8', 2010, '8', 2014, '4', 2002, '16', 53, 2, 1, 0, 0, 32, 13, 5, 2, 0, 0, 3);

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
  MODIFY `id_atas` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_bibliografia`
--
ALTER TABLE `tb_bibliografia`
  MODIFY `id_bibliografia` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_cronograma`
--
ALTER TABLE `tb_cronograma`
  MODIFY `id_cronograma` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tb_curso`
--
ALTER TABLE `tb_curso`
  MODIFY `id_curso` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tb_disciplinas`
--
ALTER TABLE `tb_disciplinas`
  MODIFY `id_disciplinas` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_planoensino`
--
ALTER TABLE `tb_planoensino`
  MODIFY `id_plano` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_ppc`
--
ALTER TABLE `tb_ppc`
  MODIFY `id_ppc` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tb_professor`
--
ALTER TABLE `tb_professor`
  MODIFY `id_professor` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
