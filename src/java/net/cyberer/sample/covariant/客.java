package net.cyberer.sample.covariant;

import java.util.ArrayList;
import java.util.List;

public class 客 {
	public static void main(final String[] args) {
		客 p = new 客();
		飲食店 s;

		s = new 洋食屋();
		p.食べる(s);

		s = new 和食屋();
		p.食べる(s);

		s = new そば屋();
		p.食べる(s);

		s = new 寿司屋();
		p.食べる(s);
		
		List<? extends Number> list = new ArrayList<Integer>();
		list.get(0);
//		list.add(Integer.valueOf(100));
	}

	public void 食べる(飲食店 shop) {
		食事 x = shop.get食事();
		System.out.println(x.getClass().getSimpleName() + "を食べました。");
	}
}
