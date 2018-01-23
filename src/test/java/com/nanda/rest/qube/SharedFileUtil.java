package com.nanda.rest.qube;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;

public class SharedFileUtil {

	public static List<SharedFile> extractSharedFiles(XmlPath htmlPath) throws Exception {

		List<Node> node = htmlPath.get().children().list();

		if (node.size() > 1) {
			throw new Exception("Number of children is more than one this method is not supported.");
		}

		TypeToken<List<SharedFile>> token = new TypeToken<List<SharedFile>>() {
		};
		List<SharedFile> sharedFiles = new Gson().fromJson(node.get(0).value(), token.getType());

		return sharedFiles;

	}

}
