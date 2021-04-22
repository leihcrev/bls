package net.cyberer.sample.finalkeyword;

public class FinalMethod {
	public final int add1(final int x, final int y) {
		return x + y;
	}
	
	private int add2(final int x, final int y) {
		return x + y;
	}

	private static final int add3(final int x, final int y) {
		return x + y;
	}

	public static final void main(final String[] args) {
		FinalMethod f = new FinalMethod();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int p = f.add1(i, j);
				int q = f.add2(i, j);
				int r = FinalMethod.add3(i, j);
				System.out.println("p=" + p + ", q=" + q + ", r=" + r);
			}
		}
	}
}
