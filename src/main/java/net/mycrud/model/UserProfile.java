package net.mycrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "usuarioperfil")
public class UserProfile {
	
	@Id
	@Column(name = "idusuario")
	private int idusuario;
	
	@Column(name = "idperfil")
	private String idperfil;

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(String idperfil) {
		this.idperfil = idperfil;
	}

	@Override
	public String toString() {
		return "UserProfile [idusuario=" + idusuario + ", idperfil=" + idperfil + "]";
	}
	
	

}


