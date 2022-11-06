public class NaiveSearch {
	static void search(String base, String txt) {
		int len_base = base.length();
		int len_txt = txt.length();
		int i = 0;

		while (len_txt < len_base + 1) {
			if (txt.equals(base.substring(i, len_txt))) {
				System.out.println("found index:" + i);
			}
			i++;
			len_txt++;
		}
	}

	public static void main(String args[]) {
		String base = "AABAACAADAABAAABAA";
		String txt = "AABA";

		search(base, txt);
	}
}

