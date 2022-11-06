public class KMP {
	void computeLPSArray(String pat, int len_pat, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < len_pat) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	void search(String pat, String txt) {
		int len_pat = pat.length();
		int len_txt = txt.length();

		int lps[] = new int[len_pat];
		int j = 0;

		computeLPSArray(pat, len_pat, lps);

		int i = 0;
		while ((len_txt - i) >= (len_pat - j)) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == len_pat) {
				System.out.println("found index: " + (i - j));
				j = lps[j - 1];
			} else if (i < len_txt && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}

	public static void main(String args[]) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		new KMP().search(pat, txt);
	}
}