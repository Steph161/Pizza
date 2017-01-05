package pizza.test;

import org.junit.Test;

import pizza.user.Kunde;
import pizza.user.Register;
import static org.junit.Assert.*;

public class TestRegister {

	@Test
	public void test() {
		Register r = new Register("06642121045");
		r.setVisible(true);
		Kunde k = r.getKundeAndClose();
		assertNotEquals(null, k);
	}

}
