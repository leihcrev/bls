package net.cyberer.sample.covariant;

public class 和食屋 extends 飲食店 {
	@Override
	public 和食 get食事() {
		return new 和食();
	}
}
