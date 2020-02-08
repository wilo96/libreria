package controlador;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.likesDAO;
import modelo.Likes;

@ManagedBean
@ViewScoped
public class likesControlador {

	private Likes like;
	
	@Inject
	private likesDAO ldao;
	
	@PostConstruct
	public void init() {
		like= new Likes();
	}

	public Likes getLike() {
		return like;
	}

	public void setLike(Likes like) {
		this.like = like;
	}

	public likesDAO getLdao() {
		return ldao;
	}

	public void setLdao(likesDAO ldao) {
		this.ldao = ldao;
	}
	
	public String guardarlike(String cedula, int libro) {
		Likes li= new Likes();
		li.setId_lib_FK(libro);
		li.setId_gustausu_FK(cedula);
		return ldao.nuevolike(li);
	}
	public List<Object[]> listaLikes(){
		return ldao.listaLikes();
	}
}
