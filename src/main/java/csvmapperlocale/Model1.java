package csvmapperlocale;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class Model1 {

	@JsonSerialize(using = LocaleBigDecimalSerializer.class)
	private BigDecimal value;
}
