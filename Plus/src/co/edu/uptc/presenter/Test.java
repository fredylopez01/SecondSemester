package co.edu.uptc.presenter;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		Pattern patternName = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
		Matcher matcherName = patternName.matcher("7/07/2022");
		System.out.println(matcherName.matches());
		
		String regExpp = "[0-31]{2}/[1-12]{1}/\\d{4}";
		System.out.println(Pattern.matches(regExpp, "2/2/2022"));
		
		String regExp = "[0-3]{1}[0-9]{1}/[0-1]{1}[0-2]{1}/\\d{4}";
		System.out.println(Pattern.matches(regExp, "07/07/2022"));
		
		String reg0 = "\\d{1,2}/\\d{1,2}/\\d{4}";
		System.out.println(Pattern.matches(reg0, "7/07/2022"));
		
		//Una fecha con formato dd-mm-aaaa
		String regExp1 = "\\d{2}-\\d{2}-\\d{4}";
		System.out.println(Pattern.matches(regExp1, "07-07-2022"));
		
		//Una hora formato mm:ss
		String regExp2 = "\\d{2}:\\d{2}";
		System.out.println(Pattern.matches(regExp2, "07:22"));
		
		//Codigo de un estudiante uptc 202220836
		String regExp3 = "\\d{9}";
		System.out.println(Pattern.matches(regExp3, "202220836"));
		
		//Un correo elctronico por ejemplo jorge.hoyos@uptc.edu.co
		String regExp4 = "\\w+[.]?\\w+@[a-z]+([.][a-z]+)?([.][a-z]{2}|[.]com)";
		System.out.println(Pattern.matches(regExp4, "jorge.hoyos@uptc.edu.com"));
		
		//url
		String regExp5 = "(https?://)?(w{3}[.])?[a-z]+([.][a-z]+)?([.][a-z]{1,3}|[.]com)";
		System.out.println(Pattern.matches(regExp5, "https://www.uptc.edu.co"));
		System.out.println(Pattern.matches(regExp5, "http://www.uptc.edu.co"));
		System.out.println(Pattern.matches(regExp5, "www.uptc.edu.es"));
		
		String regExp6 = "(https?://)?(w{3}[.])?[a-z]+([.][a-z]+)?([.][a-z]{1,3}|[.]com)(/\\w+)+";
		System.out.println(Pattern.matches(regExp6, "http://www.esprit.co.uk/womenspurses"));
		
		
		Test a = new Test();
		System.out.println(a.isPalindromo(".anita lava la tina"));
		
		
		
//		try {
//			(new URL("http://www.esprit.co.uk/womenspurses")).openStream().close();
//			System.out.println("true");
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
	}
	
	public boolean isPalindromo(String phrase) {
		boolean isOrNot = false;
		phrase.replace("\\W ", "");
		StringBuilder phraseBack = new StringBuilder();
		for(int i = phrase.length()-1; i > 0; i--) {
			phraseBack.append(phrase.charAt(i));
		}
		if(phrase.equals(phraseBack.toString())) {
			isOrNot = true;
		}
		return isOrNot;
	}

}
