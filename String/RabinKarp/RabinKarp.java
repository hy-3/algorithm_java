public class RabinKarp {
	public final static int d = 256;

	static void search(String base, String txt, int q) {
		int len_base = base.length();
		int len_txt = txt.length();
		int hash_base = 0;
		int hash_txt = 0;
		int i, j;
		int h = 1;

		for (i = 0; i < len_txt - 1; i++) {
			h = (h * d) % q;
		}

		for (i = 0; i < len_txt; i++) {
			hash_txt = (d * hash_txt + txt.charAt(i)) % q; 
			hash_base = (d * hash_base + base.charAt(i)) % q;
		}

		for (i = 0; i <= (len_base - len_txt); i++) {
			if (hash_txt == hash_base) {
				for (j = 0; j < len_txt; j++) {
					if (base.charAt(i + j) != txt.charAt(j)) {
						break;
					}
				}
				if (j == len_txt) {
					System.out.println("found index: " + i);
				}
			}

			if(i < len_base - len_txt) {
				hash_base = (d * (hash_base - base.charAt(i) * h) + base.charAt(i + len_txt)) % q;
				if (hash_base < 0) {
					hash_base = (hash_base + q);
				}
			}
		}
	}

	public static void main(String[] args) {
		String base = "GEEKS FOR GEEKS";
		String txt = "GEEKS";
		int q = 101;
		search(base, txt, q);
	}
}