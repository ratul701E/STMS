package tools;

public abstract class EssentialClass {
	public static boolean checkPassword(String password) {
		boolean sp = false, up = false, lo = false, num = false;
		if(password.length() < 8) return false;
		for(int i = 0; i < password.length(); i++) {
			//System.out.println("INSIDE LOOP");
			switch(password.charAt(i)) {
				case '@':
				case '#':
				case '*':
				case '$':
				case '&': sp = true; break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': num = true; break;
			}
			if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') lo = true;
			if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') up = true;
			if(sp && num && up && lo) return true;
		}
//		System.out.println(lo);
//		System.out.println(up);
//		System.out.println(num);
//		System.out.println(sp);
		return false;
	}
}
