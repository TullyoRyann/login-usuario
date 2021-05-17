package com.tullyo.scusuariologinlog.domain.consumer.deserializer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tullyo.scusuariologinlog.domain.consumer.dto.UsuarioLoginLogTO;

public class UsuarioLoginLogDeserializer implements Deserializer<UsuarioLoginLogTO> {

	@Override
	public UsuarioLoginLogTO deserialize(String topic, byte[] usuarioLoginLogTO) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(usuarioLoginLogTO, UsuarioLoginLogTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
