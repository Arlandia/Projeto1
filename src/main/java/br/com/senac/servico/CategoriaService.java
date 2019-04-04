package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Categoria;
import br.com.senac.repositorio.CategoriaRepositorio;
import br.com.senac.servico.exception.ObjctNotFundException;
@Service
public class CategoriaService { 
	@Autowired
	private CategoriaRepositorio repoCat;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> objCategoria = repoCat.findById(id);
		return objCategoria.orElseThrow(() -> new ObjctNotFundException("Categoria não encontrada! Id:"
			+ id + "Tipo: " + Categoria.class.getName()));
		
	}
	public Categoria inserir (Categoria objCategoria) {
		//estou colacondo um objeto novo entao o id precisa ser null
		objCategoria.setId(null);
		return repoCat.save(objCategoria);
	}
	
	public Categoria alterar(Categoria objCategoria) {
		
		Categoria objCategoriaEncotrado = buscar(objCategoria.getId());
		objCategoriaEncotrado.setNome(objCategoria.getNome());
		
		return repoCat.save(objCategoriaEncotrado);
	}
    public void excluir(Integer id) {
    	repoCat.deleteById(id);
    }
    public List<Categoria> listaCategoria(){
    	return repoCat.findAll();
    }
}
