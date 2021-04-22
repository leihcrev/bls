package net.cyberer.sample.finalkeyword;

public class CtoC {
	final Invoked x;
	public CtoC() {
		x = new Invoked(this);
	}
}

class Invoked {
	final String x;
	Invoked(CtoC instance) {
		x = "x";
	}
}