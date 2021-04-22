package net.cyberer.sample.covariant;

public class 洋食屋 extends 飲食店 {
	@Override
	public 洋食 get食事() {
		return new 洋食();
	}
}
