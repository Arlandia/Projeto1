package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Curso;
import br.com.senac.repositorio.CategoriaRepositorio;
import br.com.senac.repositorio.CursoRepositorio;
import br.com.senac.servico.exception.ObjctNotFundException;
import javassist.tools.rmi.ObjectNotFoundException;
@Service
public class CursoService {
	@Autowired
	private CursoRepositorio repoCurso;
	
	public Curso buscar(Integer id) throws ObjectNotFoundException {
		Optional<Curso> objCurso = repoCurso.findById(id);
		return objCurso.orElseThrow(() -> new  ObjectNotFoundException(
				"Curso não encotrado! id: " + id + ", Tipo!" + Curso.class.getName()));
		
		
	}
	public Curso inserir (Curso curso) {
		//estou colacondo um objeto novo entao o id precisa ser null
		curso.setId(null);
		return repoCurso.save(curso);
	}
	
	public Curso alterar(Curso objCurso) throws ObjectNotFoundException{
		
		Curso objCursoEncotrado = buscar(objCurso.getId());
		objCursoEncotrado = buscar(objCurso.getId());
		objCursoEncotrado.setNome(objCurso.getNome());
		objCursoEncotrado.setDescricao(objCurso.getDescricao());
		objCursoEncotrado.setPreco(objCurso.getPreco());
		objCursoEncotrado.setCategorias(objCurso.getCategorias());
		
		return repoCurso.save(objCursoEncotrado);
	}
    public void excluir(Integer id) {
    	repoCurso.deleteById(id);
    }
    public List<Curso> listaCursos(){
    	return repoCurso.findAll();
    }

}
