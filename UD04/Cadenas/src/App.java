public class App {

    public static void main(String[] args) {

		System.out.println("start genWithString");
		long timeStart = System.currentTimeMillis();
		String s1 = genWithString();
		long timeSpend = (System.currentTimeMillis() - timeStart);
		System.out.println("end genWithString. Time:" + timeSpend+" Milliseconds");

		System.out.println("start genWithStringBuilder");
		timeStart = System.currentTimeMillis();
		String s2 = genWithStringBuilder();
		timeSpend = (System.currentTimeMillis() - timeStart);
		System.out.println("end genWithStringBuilder. Time:" + timeSpend+" Milliseconds");
		
		System.out.println("s1.equals(s2)="+s1.equals(s2));
	}

	private static String genWithStringBuilder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			sb.append("x");
		}
		return sb.toString();
	}

	private static String genWithString() {
		String s = "";
		for (int i = 0; i < 100000; i++) {
			s = s + "x";
		}
		return s;
	}


 /*   public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! \u2661");
        int e = 'a';
        e = '\u0061';
        char c = 'a' + 1;
        System.out.println(e);
        System.out.println(c);

    
    // Declaración de variables y constantes
    int codePoint;

    // Proceso
    for(codePoint = 0x0000; codePoint <= 0xffff; codePoint++){
        String xxxx = Integer.toHexString(codePoint);
        System.out.println("\\u" + xxxx + ": " + (char)codePoint);
    }

    c = '6';

    System.out.println(c >= '0' && c <= '9');

    System.out.println(Character.isLetter(c));
    System.out.println(Character.isLowerCase(c));
    String saludo = "hola";
    System.out.println("".equals(saludo));
    }*/
}
