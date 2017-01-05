package pizza.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pizza.user.Kunde;
import pizza.user.Register;

public class TestKunde {

	@Test
	public void testFileWrite() {
		Kunde k = new Kunde("123", "Hans", "Moser", "Bahnhofsstraße 17", "Straßwalchen", 5204);
		String correct = "123, Hans, Moser, Bahnhofsstraße 17, Straßwalchen, 5204";
		String toS = k.toString();
		assertEquals(correct, toS);
	}

	@Test
	public void testFileRead() {
		String orig = "123, Hans, Moser, Bahnhofsstraße 17, Straßwalchen, 5204";
		Kunde correct = new Kunde("123", "Hans", "Moser", "Bahnhofsstraße 17", "Straßwalchen", 5204);
		Kunde valOf = Kunde.valueOf(orig);
		assertEquals(correct, valOf);
	}
}
