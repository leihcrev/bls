package net.cyberer.sample.finalkeyword;

public class Constant {
	public static final int A = 1;
	public static final int B = 2;
	public static final int C = 3;
	public Constant() {
		ConstantReference.c = this;
	}
}

class ConstantReference {
	static Constant c;
	public static char get(final int x) {
		if (x == Constant.A) {
			return 'A';
		}
		if (x == Constant.B) {
			return 'B';
		}
		if (x == Constant.C) {
			return 'C';
		}
		return '@';
	}
}