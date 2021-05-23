package framework;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesLoader {
	private static String path;

	public static void pathloc(String loc) {
		path = loc;
	}

	private final Gson GSON = new Gson();
	private HashMap<String, String> locale = new HashMap<>();


	public PropertiesLoader read() throws IOException {
		this.locale = GSON.fromJson(fileReader(), locale.getClass());
		return this;
	}

	private String fileReader() throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			return stream.collect(Collectors.joining("\r\n"));
		}
	}

	public String getsource(String property) throws CloneNotSupportedException, IOException {
		if (locale.size() == 0) {
			this.read();
		}
		return locale.get(property);
	}
}

