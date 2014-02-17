package com.cloudnil.framework.utils.common;

import java.beans.PropertyEditorSupport;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
/**
 * <p>ClassName: DateConvertEditor</p>
 * <p>Description: Spring中日期格式转换成字符串</p>
 * @author 史绍虎
 * <p>Date: 2012-6-18 上午11:42:40</p>
 * @param <T>
 */
public class DateConvertEditor<T> extends PropertyEditorSupport {
	private DateFormat format;
	private Class<T> clz;
	public DateConvertEditor(String format,Class<T> clz) {
		this.format = new SimpleDateFormat(format);
		this.clz=clz;
	}

	/** Date -> String */
	@Override
	public String getAsText() {
		if (getValue() == null)
			return "";
		return this.format.format(getValue());
	}
	/** String -> Date */
	@Override
	public void setAsText(String text) {
		if (!StringUtils.isNotBlank(text)) {
			setValue(null);
		} else {
				try {
					Constructor<T> m=clz.getConstructor(long.class);
					setValue(m.newInstance(this.format.parse(text).getTime()));
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
