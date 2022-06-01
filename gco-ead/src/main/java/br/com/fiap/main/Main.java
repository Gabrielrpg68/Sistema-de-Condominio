package br.com.fiap.main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Condominio;
import br.com.fiap.entity.FuncPortaria;
import br.com.fiap.entity.MovimentacaoPortaria;
import br.com.fiap.entity.Portaria;
import br.com.fiap.entity.Visitante;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.genericService.GenericService;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args) {

		// Obter uma fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

		// Obter um entity manager
		EntityManager em = fabrica.createEntityManager();

		// GenericDao do Condominio
		GenericDao<Condominio, Integer> dao =
				// Criando uma classe anônima e instanciando
				new GenericService<Condominio, Integer>(em) {
				};

		// GenericDao do Funcionario
		GenericDao<FuncPortaria, Integer> dao2 =
				// Criando uma classe anônima e instanciando
				new GenericService<FuncPortaria, Integer>(em) {
				};

		// GenericDao do Funcionario
		GenericDao<Visitante, Integer> dao3 =
				// Criando uma classe anônima e instanciando
				new GenericService<Visitante, Integer>(em) {
				};
		// GenericDao do Portaria
		GenericDao<Portaria, Integer> dao4 =
				// Criando uma classe anônima e instanciando
				new GenericService<Portaria, Integer>(em) {
				};
		// GenericDao do Portaria
		GenericDao<MovimentacaoPortaria, Integer> dao5 =
				// Criando uma classe anônima e instanciando
				new GenericService<MovimentacaoPortaria, Integer>(em) {
				};

		// Instanciar um Departamento
		Condominio cond = new Condominio();
		cond.setCnpj("XX.XXX.XXX/0001-XX");
		cond.setDataFundacao(new GregorianCalendar(2005, 06, 20));
		cond.setDsRazaoSocial("Condomínio Edifício");
		cond.setNomeFantasia("Haras Bela Vista");

		// Instanciar um Funcionario
		FuncPortaria func = new FuncPortaria();
		func.setNome("Pedro Paulo");
		func.setDataNascimento(new GregorianCalendar(2000, 05, 20));
		func.setCpf("471.987.532-85");
		func.setRg("87.985.365-5");
		func.setDataCadastro(new GregorianCalendar(2018, 8, 17));

		// Instanciar um Visitante
		Visitante visitante = new Visitante();
		visitante.setNm_visitante("Eduardo Felipe");
		visitante.setDataNascimento(new GregorianCalendar(2001, 8, 20));
		visitante.setCpf("345.234.654-34");
		visitante.setRg("85.925.665-6");
		visitante.setDataCadastro(new GregorianCalendar(2020, 7, 20));

		// Instanciar uma portaria
		Portaria portaria = new Portaria();
		portaria.setNomePortaria("Portaria Leste");
		portaria.setCondominio(cond);
		portaria.setStatus("A");
		portaria.setInicio(new GregorianCalendar(2020, 8, 10));
		portaria.setTermino(new GregorianCalendar(2022, 10, 5));

		// Instanciar uma movimentação
		MovimentacaoPortaria movimentacao = new MovimentacaoPortaria();
		movimentacao.setPortaria(portaria);
		
		List<FuncPortaria> funcionarios = new ArrayList<>();		
		funcionarios.add(func);
		movimentacao.setFuncionarioPort(funcionarios);
		
		List<Visitante> visitantes = new ArrayList<>();
		visitantes.add(visitante);
		movimentacao.setVisitante(visitantes);
		
		movimentacao.setTipoMovimentacao("Entrada de Veiculos");
		movimentacao.setDataMovimentacao(new GregorianCalendar(2022, 3, 15));

		try {
			// Cadastrar um condominio
			dao.cadastrar(cond);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		try {
			// Cadastrar um funcionario
			dao2.cadastrar(func);
			dao2.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Cadastrar um Visitante
			dao3.cadastrar(visitante);
			dao3.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Cadastrar uma portaria
			dao4.cadastrar(portaria);
			dao4.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			// Cadastrar Movimentação portaria
			dao5.cadastrar(movimentacao);
			dao5.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Pesquisar um condominio
			Condominio busca = dao.obterPorId(1);
			System.out.println(busca.getNomeFantasia());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Pesquisar um funcionario
			FuncPortaria busca = dao2.obterPorId(1);
			System.out.println(busca.getNome());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			// Pesquisar um visitante
			Visitante busca = dao3.obterPorId(1);
			System.out.println(busca.getNm_visitante());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			// Pesquisar uma portaria
			Portaria busca = dao4.obterPorId(1);
			System.out.println(busca.getNomePortaria());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			// Pesquisar uma movimentacao
			MovimentacaoPortaria busca = dao5.obterPorId(1);
			System.out.println(busca.getTipoMovimentacao());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			// Atualizar um condominio
			cond.setNomeFantasia("Condominio FIAP");
			dao.atualizar(cond);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Atualizar um funcionario
			func.setNome("Caio Henrique");
			dao2.atualizar(func);
			dao2.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Atualizar um Visitante
			visitante.setNm_visitante("Lucas Pereira");
			dao3.atualizar(visitante);
			dao3.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Atualizar uma portaria
			portaria.setNomePortaria("Portaria Sul");
			dao4.atualizar(portaria);
			dao4.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			// Atualizar uma movimentacao
			movimentacao.setTipoMovimentacao("Entrada de pedestres");
			dao5.atualizar(movimentacao);
			dao5.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

//		// Remover um condominio
//		try {
//			dao.remover(1);
//			dao.commit();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		// Remover um funcionario
//		try {
//			dao2.remover(1);
//			dao2.commit();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		// Remover um visitante
//		try {
//			dao3.remover(1);
//			dao3.commit();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		// Remover uma portaria
//		try {
//			dao4.remover(1);
//			dao4.commit();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		// Remover uma movimentacao
//		try {
//			dao5.remover(1);
//			dao5.commit();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		fabrica.close();

	}

}
