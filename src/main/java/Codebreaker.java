
public class Codebreaker {

	private String secret;
	
	public Codebreaker(String secret) {
		this.secret = secret;
	}
	
	public String decode(String input) {
		String[] secretVector = secret.split("");
		String[] inputVector = input.split("");
		String answerNumber = "";
		String answerPosition = "";
		for (int i = 0; i < inputVector.length; i++) {
			if(secretVector[i].equals(inputVector[i])) {
				answerPosition += "X";
			}else if(this.secret.indexOf(inputVector[i]) >= 0) {
				answerNumber += "_";
			}
		}
		return answerPosition + answerNumber;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}	
	
}
