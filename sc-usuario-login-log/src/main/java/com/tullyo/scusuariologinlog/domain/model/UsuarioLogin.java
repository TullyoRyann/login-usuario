package com.tullyo.scusuariologinlog.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "usuario_login")
public class UsuarioLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@NotNull
	@Column(name = "login")
	private String login;
	
	@NotNull
	@Column(name = "hora_login")
	private LocalDateTime horaLogin;
	
    @PrePersist
    public void prePersist() {
    	horaLogin = LocalDateTime.now();
    }
}
