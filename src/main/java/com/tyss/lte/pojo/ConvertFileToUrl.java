package com.tyss.lte.pojo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ConvertFileToUrl {
	public URL convertFileToUrl(String path) throws MalformedURLException {
		File file = new File(path);
		return file.toURI().toURL();
	}
}
