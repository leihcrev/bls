package net.cyberer.sample.covariant;

public class 寿司屋 extends 和食屋 {
	@Override
	public 寿司 get食事() {
		return new 寿司();
	}
}
