package csvmapperlocale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;

public class LocaleBigDecimalSerializer extends JsonSerializer<BigDecimal>{

	@Override
	public void serialize(BigDecimal t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
		if (t != null)
			jg.writeString(String.format(sp.getLocale(), "%1$.3f", t));
		else
			jg.writeString("");
	}
}
