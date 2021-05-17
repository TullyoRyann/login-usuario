package com.tullyo.scoauth.domain.producer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tullyo.scoauth.domain.producer.dto.UsuarioLoginLogTO;

public class UsuarioLoginSerializer implements Serializer<UsuarioLoginLogTO> {

	@Override
	public byte[] serialize(String topic, UsuarioLoginLogTO usuarioLoginTO) {
		try {
			return new ObjectMapper().writeValueAsBytes(usuarioLoginTO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
