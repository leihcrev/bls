package net.cyberer.sample.finalkeyword;

public class ThreadSafeImmutableObject {
	private final String x;
	private final String y;
	public ThreadSafeImmutableObject() {
		x = "";
		y = "";
	}
	public ThreadSafeImmutableObject(final String x, final String y) {
		this.x = x;
		this.y = y;
	}
	public String getX() {
		return x;
	}
	public String getY() {
		return y;
	}
}
