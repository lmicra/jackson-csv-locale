package csvmapperlocale;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;

public class App {

	public static void main(String[] args) throws IOException {
		Model1 model1 = new Model1();
		model1.setValue(BigDecimal.valueOf(0.1));

		Class clazz = Model1.class;

		ObjectWriter ptWriter;
		{
			CsvMapper csvMapper = new CsvMapper();
			ptWriter = csvMapper
				.writerFor(clazz)
				.with(Locale.forLanguageTag("pt-PT"))
				.with(
					csvMapper
						.schemaFor(clazz)
						.withColumnSeparator('\t')
						.withHeader()
				);
		}

		ObjectWriter usWriter;
		{
			CsvMapper csvMapper = new CsvMapper();
			usWriter = csvMapper
				.writerFor(clazz)
				.with(Locale.forLanguageTag("en-US"))
				.with(
					csvMapper
						.schemaFor(clazz)
						.withColumnSeparator('\t')
						.withHeader()
				);
		}

		ByteArrayOutputStream baos;
		baos = new ByteArrayOutputStream();
		ptWriter.writeValue(baos, model1);
		System.err.println(baos.toString());

		baos = new ByteArrayOutputStream();
		usWriter.writeValue(baos, model1);
		System.err.println(baos.toString());
	}
}
