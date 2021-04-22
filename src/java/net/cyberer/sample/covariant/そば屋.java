package net.cyberer.sample.covariant;

public class そば屋 extends 和食屋 {
	@Override
	public そば get食事() {
		return new そば();
	}
}
