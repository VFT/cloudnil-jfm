package com.cloudnil.framework.utils.common;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/**
 * <p>ClassName: ConfigurableStringHttpMessageConverter</p>
 * <p>Description: </p>
 * <p>SpringMVC返回String格式的Json数据时进行转换的类</p>
 * <p>注入取代原Spring中的StringHttpMessageConverter类[该类原来支持ISO编码格式，所以会乱码]</p>
 * @author 史绍虎
 * <p>Date: 2012-6-11 下午3:03:56</p>
 */
public class ConfigurableStringHttpMessageConverter extends AbstractHttpMessageConverter<String> {

	private final List<Charset> availableCharsets;
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public ConfigurableStringHttpMessageConverter() {
        this(DEFAULT_CHARSET);
    }

    public ConfigurableStringHttpMessageConverter(Charset defaultCharset) {
        super(new MediaType("text", "plain", defaultCharset), MediaType.ALL);
        this.availableCharsets = new ArrayList<Charset>(Charset.availableCharsets().values());
	}

    @Override
	public boolean supports(Class<?> clazz) {
		return String.class.equals(clazz);
	}

	@Override
	public String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
		MediaType contentType = inputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
		return FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));
	}

	@Override
	protected Long getContentLength(String s, MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			Charset charset = contentType.getCharSet();
			try {
				return (long) s.getBytes(charset.name()).length;
			}
			catch (UnsupportedEncodingException ex) {
				throw new InternalError(ex.getMessage());
			}
		}
		else {
			return null;
		}
	}

	@Override
	protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException {
		outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
		MediaType contentType = outputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
		FileCopyUtils.copy(s, new OutputStreamWriter(outputMessage.getBody(), charset));
	}
	
	protected List<Charset> getAcceptedCharsets() {
		return this.availableCharsets;
	}
}