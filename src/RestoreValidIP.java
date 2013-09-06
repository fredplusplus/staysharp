import java.util.ArrayList;

/**
 * http://leetcode.com/onlinejudge#question_93
 * 
 * 
 */
public class RestoreValidIP {
	ArrayList<String> result;

	public ArrayList<String> restoreIpAddresses(String s) {
		result = new ArrayList<String>();
		tryParseIp("", s, 4);
		return result;
	}

	private void tryParseIp(String partial, String s, int needBytes) {
		if (needBytes == 1) {
			if (isValidByteNumber(s, 0, s.length())) {
				result.add(partial + "." + s);
			}
			return;
		} else {
			// not enough digits
			if (s.length() < needBytes) {
				return;
			}
			int maxDigit = Math.min(3, s.length());
			for (int digit = 0; digit <= maxDigit; digit++) {
				if (isValidByteNumber(s, 0, digit)) {
					String newPartial = partial;
					if (needBytes != 4) {
						newPartial = newPartial + ".";
					}
					newPartial = newPartial + s.substring(0, digit);
					tryParseIp(newPartial, s.substring(digit), needBytes - 1);
				}
			}
		}
	}

	private boolean isValidByteNumber(String s, int start, int end) {
		try {
			String rawValue = s.substring(start, end);
			if (rawValue.startsWith("0") && start != end - 1) {
				return false;
			}
			int val = Integer.parseInt(rawValue);
			return val >= 0 && val <= 255;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		RestoreValidIP r = new RestoreValidIP();
		ArrayList<String> result = r.restoreIpAddresses("25525511135");
		for (String res : result) {
			System.out.println(res);
		}

	}
}
