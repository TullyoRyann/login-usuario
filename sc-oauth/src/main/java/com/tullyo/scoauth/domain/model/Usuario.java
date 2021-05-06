package com.tullyo.scoauth.domain.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario implements Serializable {

	private static final long serialVersionUID = -277762689350947682L;

	private Long id;
	private String login;
	private String senha;
}