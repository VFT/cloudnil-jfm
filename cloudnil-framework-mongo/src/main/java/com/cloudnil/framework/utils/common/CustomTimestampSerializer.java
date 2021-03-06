package com.cloudnil.framework.utils.common;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
/**
 * <p>ClassName: CustomTimestampSerializer</p>
 * <p>Description: Json Timestamp日期格式转换</p>
 * @author 史绍虎
 * <p>Date: 2012-6-18 下午2:05:13</p>
 */
public class CustomTimestampSerializer extends JsonSerializer<Timestamp> {
	@Override
	public void serialize(Timestamp value, JsonGenerator jgen,SerializerProvider provider) throws IOException,JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}
}