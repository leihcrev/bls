package net.cyberer.sample.finalkeyword;

class AlphabetUtil {
	static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
	public static char getAlphabet(final int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e = new InterruptedException();
		}
		return ALPHABET[i];
	}
}

public class Alphabet {
	static {
		AlphabetUtil.ALPHABET[0] = 'Z';
		AlphabetUtil.ALPHABET[1] = 'Z';
		AlphabetUtil.ALPHABET[2] = 'Z';
		AlphabetUtil.ALPHABET[3] = 'Z';
		AlphabetUtil.ALPHABET[4] = 'Z';
		AlphabetUtil.ALPHABET[5] = 'Z';
		AlphabetUtil.ALPHABET[6] = 'Z';
		AlphabetUtil.ALPHABET[7] = 'Z';
		AlphabetUtil.ALPHABET[8] = 'Z';
		AlphabetUtil.ALPHABET[9] = 'Z';
	};

	public static void main(final String[] args) {
		System.out.println(AlphabetUtil.getAlphabet(9));
		boolean z = false;
		while (z) {
			System.out.println("test");
			return;
		}
		Calculate c = new Calculate() {
			public int calc(int x) {
				if (z) {
					return 0;
				}
			return x + 1;
			}
		};
		c.calc(0);
	}
}

interface Calculate {
	public int calc(int x);
}