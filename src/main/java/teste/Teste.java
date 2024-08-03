package teste;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.softgraf.entity.Aluno;
import com.softgraf.repository.AlunoRepository;
import com.softgraf.util.JpaUtil;

public class Teste {

	public static String nomeUsuario = "Valdeci";
	
	public static void main(String[] args) {
		
		System.out.println("Rodando teste...");
		
		Aluno joao = new Aluno();
		joao.setNome("João Carlos");
		joao.setCurso("Java");
		joao.setData(LocalDate.now());
		joao.setEmail("joao@gmail.com");
		
		// instancia o gerenciador
		EntityManager em = JpaUtil.getEntityManager();

		AlunoRepository repository = new AlunoRepository(em);
		repository.adicionar(joao);
		
		
		// fecha o entity manager
		em.close();
		
		
		// fecha o entity manager factory
		JpaUtil.close();
		
		
		
		
		

	}

}
