package com.webSocketChat.chat.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="mensajes")
public class Mensaje implements Serializable {
	
	@Id
	private String id;

	private String texto;
	private Long fecha;
	private String username;
	private String tipo;
	private String color;

	private static final long serialVersionUID = -3777582564067492550L;

}

