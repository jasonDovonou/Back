package util;

public final class Utils {

	private Utils() {
	}

	public static Object stringToJson(String key, String value) {
		StringBuilder result = new StringBuilder();
		result.append("{\"");
		result.append(key);
		result.append("\":\"");
		result.append(value);
		result.append("\"}");
		return result;
	}

}
