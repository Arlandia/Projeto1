package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Categoria;
import br.com.senac.dominio.Cidade;
import br.com.senac.dominio.Curso;
import br.com.senac.dominio.Endereco;
import br.com.senac.dominio.Estado;
import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.AlunoRepositorio;
import br.com.senac.repositorio.CategoriaRepositorio;
import br.com.senac.repositorio.CidadeRepositorio;
import br.com.senac.repositorio.CursoRepositorio;
import br.com.senac.repositorio.EnderecoRepositorio;
import br.com.senac.repositorio.EstadoRepositorio;
import br.com.senac.repositorio.UsuarioRepositorio;

@Component
public class init  implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    AlunoRepositorio alunoRepositorio;
    
    @Autowired
    EstadoRepositorio estadoRepositorio; 
    
    @Autowired
    CidadeRepositorio cidadeRepositorio;
    
    @Autowired
    EnderecoRepositorio enderecoRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    CategoriaRepositorio categoriaRepositorio;
    
    @Autowired
    CursoRepositorio cursoRepositorio;
    
    
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lanny");
		aluno1.setEmail("lanny.cardoso@hotmail.com");
		
		alunoRepositorio.save(aluno1);
		
		//criando categoria
		
		Categoria categoria1 = new Categoria(null,"java");
		Categoria categoria2 = new Categoria(null,"Mobile");
		
		categoriaRepositorio.saveAll(Arrays.asList(categoria1,categoria2));
		
		//Criando curso
		
		Curso curso1 = new Curso(null,"Java", "Java para iniciante", 200.00);
		Curso curso2 = new Curso(null,"JavaII", "Java para Intermediario", 400.00);
		
		curso1.setCategorias(Arrays.asList(categoria1,categoria2));
		curso2.setCategorias(Arrays.asList(categoria1));
		
		cursoRepositorio.saveAll(Arrays.asList(curso1,curso2));
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("james");
		usuario1.setEmail("jammes@");
		usuario1.setSobrenome("Malley");
		usuario1.setSenha("1223445");
	
		
		Aluno alunoGravado = alunoRepositorio.findByEmail("lanny.cardoso@hotmail.com");
		
		Estado estado1 = new Estado();
		estado1.setNome("Rio de janeiro");
		
		Estado estado2 = new Estado();
		estado1.setNome("São Paulo");
		
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Angra dos Reis");
		cidade1.setEstado(estado1);
		
		Cidade cidade2 = new Cidade();
		cidade2.setNome("Cabo Frio");
		cidade2.setEstado(estado1);
		
		Cidade cidade3 = new Cidade();
		cidade3.setNome("Mogi das cruzes");
		cidade3.setEstado(estado2);
		
		estadoRepositorio.saveAll(Arrays.asList(estado1,estado2));
		
		cidadeRepositorio.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Endereco end1 = new Endereco();
		end1.setRua("Rua dos Andradas");
		end1.setNumero("20"); 
		end1.setBairro("centro");
		end1.setComplemento("Bloco B");
		end1.setCidade(cidade1);
		end1.setAluno(aluno1);
		end1.setUsuario(usuario1);
//		
//		Endereco end2 = new Endereco();
//		end2.setRua("Rua dos Andradas");
//		end2.setNumero("20"); 
//		end2.setBairro("centro");
//		end2.setComplemento("Bloco B");
//		end2.setCidade(cidade2);
//		end2.setAluno(aluno1);
//		
		
		aluno1.getTelefone().addAll(Arrays.asList("232323232","234343434"));
		
		alunoRepositorio.save(aluno1);
		usuarioRepositorio.save(usuario1);
		
		enderecoRepositorio.saveAll(Arrays.asList(end1));
		
		
		
		
		
		
		
	}
}
