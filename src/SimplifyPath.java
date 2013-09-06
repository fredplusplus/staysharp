import java.util.LinkedList;

/**
 * http://leetcode.com/onlinejudge#question_71
 * 
 * @author fanzhang
 * 
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function

		String[] tokens = path.split("/");
		LinkedList<String> parts = new LinkedList<String>();
		for (String token : tokens) {
			if (token.equals(".") || token.isEmpty()) {
				continue;
			} else if (token.equals("..")) {
				if (!parts.isEmpty()) {
					parts.removeLast();
				}
			} else {
				parts.addLast(token);
			}
		}
		String simplifiedPath = "";
		for (String part : parts) {
			simplifiedPath += "/" + part;
		}
		if (simplifiedPath.isEmpty()) {
			simplifiedPath = "/";
		}
		return simplifiedPath;
	}
}
