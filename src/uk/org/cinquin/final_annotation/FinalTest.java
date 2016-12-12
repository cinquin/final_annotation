package uk.org.cinquin.final_annotation;

public class FinalTest {
	@Final Object finalField;

	public FinalTest() {
		finalField = new Object();
		finalField = new Object();
	}

	public void method2() {
		finalField = null;
	}
}
