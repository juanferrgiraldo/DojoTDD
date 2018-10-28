import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CodebreakerTest {

	private Codebreaker cb;
	private String realAnswer;
	
	@Before
	public void setup() {
		cb = new Codebreaker("1234");
	}
	
	@Test
	public void allCoincidences_1234() {
		realAnswer = cb.decode("1234");
		assertEquals("XXXX", realAnswer);
	}
	
	@Test
	public void allDifferent_7896() {
		realAnswer = cb.decode("7896");
		assertEquals("", realAnswer);
	}
	
	@Test
	public void oneCoincidenceByNumber_0100() {
		realAnswer = cb.decode("0100");
		assertEquals("_", realAnswer);
	}
		
	@Test
	public void twoCoincidenceByNumber_0120() {
		realAnswer = cb.decode("0120");
		assertEquals("__", realAnswer);
	}
	
	@Test
	public void threeCoincidenceByNumber_0123() {
		realAnswer = cb.decode("0123");
		assertEquals("___", realAnswer);
	}
	
	@Test
	public void fourCoincidenceByNumber_4123() {
		realAnswer = cb.decode("4123");
		assertEquals("____", realAnswer);
	}
	
	@Test
	public void oneCoincidenceByNumber_5000() {
		assertEquals("_", new Codebreaker("4567").decode("5000"));
	}
		
	@Test
	public void twoCoincidencesByNumber_5006() {
		assertEquals("__", new Codebreaker("4567").decode("5006"));
	}
	
	@Test
	public void threeCoincidencesByNumber_5076() {
		assertEquals("___", new Codebreaker("4567").decode("5076"));
	}
	
	@Test
	public void fourCoincidencesByNumber_5876() {
		assertEquals("____", new Codebreaker("6785").decode("5876"));
	}
	
	@Test
	public void oneCoincidenceByPosition_5876() {
		assertEquals("X", new Codebreaker("5123").decode("5876"));
	}
	
	@Test
	public void twoCoincidencesByPosition_5176() {
		assertEquals("XX", new Codebreaker("5123").decode("5176"));
	}
	
	@Test
	public void twoCoincidencesByTwoPosition_5176() {
		assertEquals("XX__", new Codebreaker("5123").decode("5132"));
	}
	
	
	@Test
	public void oneCoincidencesByOnePosition_5176() {
		assertEquals("X___", new Codebreaker("5123").decode("5312"));
	}
	
	@Test
	public void allGrown_5176() {
		assertEquals("", new Codebreaker("5123").decode("7890"));
	}
}
