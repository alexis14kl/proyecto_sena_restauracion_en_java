package net.mycrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
	
	@Column(name="id_message")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_message;
	
	@Column(name="idusuario")
	private int idusuario;
	
	@Column(name="message")
	private String message;
	
	@Column(name = "destinario")
	private String destinario;

}
