package com.tullyo.scoauth.domain.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Perfil implements Serializable {

	private static final long serialVersionUID = 760220636477274720L;

	private Long id;
	private String nome;

}
