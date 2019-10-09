package model.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import model.boxtal.Country;

public class CountryDeserializer extends StdDeserializer<String> {

	private static final long serialVersionUID = 1L;

	protected CountryDeserializer(Class<?> vc) {
		super(vc);
	}

	public CountryDeserializer() {
		this(null);
	}

	@Override
	public String deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		Country country = new Country();

		JsonNode node = jp.getCodec().readTree(jp);
		return node.get("name").asText();

	}

}
