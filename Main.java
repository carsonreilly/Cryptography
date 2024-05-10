import java.util.Scanner;

public class Main {
	public static String caesar(String c) {
		Scanner sc2=new Scanner(System.in);
		int temp;
		char temp2;
		int shift=-1;
		String change="";
		while(shift<0||shift>25) {
			System.out.print("What shift are you using? (0-25)");
			shift=sc2.nextInt();
		}
		for(int i=0;i<c.length();i++) {
			temp2=(char)(((int)c.charAt(i)+shift-'a')%26+'a');
			change+=temp2;
		}
		return change;
	}
	public static String affine(String c) {
		String change="";
		int a=0;
		int b=-5;
		int temp=-1;
		Scanner sc2=new Scanner(System.in);
		while((a!=1)&&(a!=3)&&(a!=5)&&(a!=7)&&(a!=9)&&(a!=11)&&(a!=15)&&(a!=17)&&(a!=19)&&(a!=21)&&(a!=23)){
			System.out.println("Please enter your 'a' value (Note this must be 1,3,5,7,9,11,15,17,19,21, or 23): ");
			a=sc2.nextInt();
		}
		while((b<0)||(b>25)) {
			System.out.println("Please enter your 'b' value (Note this must be between 0 and 25): ");
			b=sc2.nextInt();
		}
		for(int i=0;i<c.length();i++) {
			temp=(((((int)c.charAt(i)-'a')*a)+b)%26)+'a';
			change+=(char)temp;
		}
		return change;
	}
	public static String substitution(String c) {
		String change="";
		String placeholder="";
		Scanner sc2=new Scanner(System.in);
		String alpha="abcdefghijklmnopqrstuvwxyz";
		String temp="";
		char t2;
		System.out.print("Input your substitution for "+alpha.charAt(0)+" ");
		placeholder+=sc2.nextLine();
		for(int i=1;i<26;i++) {
			System.out.print("Input your substitution for "+alpha.charAt(i)+" ");
			temp=sc2.nextLine();
			t2=temp.charAt(0);
			for(int j=0;j<placeholder.length();j++) {
				while(Character.compare(t2,placeholder.charAt(j))==0) {
					System.out.print("You have already used this letter as a substitution. Please enter a letter that you haven't used yet. ");
					temp=sc2.nextLine();
					t2=temp.charAt(0);
				}
			}
			placeholder+=temp;
		}
		for(int k=0;k<c.length();k++) {
			for(int l=0;l<placeholder.length();l++) {
				if(Character.compare(c.charAt(k), alpha.charAt(l))==0) {
					change+=placeholder.charAt(l);
				}
			}
		}
		return change;
	}
	public static String vig(String c) {
		Scanner sc2= new Scanner(System.in);
		String key="";
		String change="";
		System.out.print("What is your key: ");
		key=sc2.nextLine();
		for(int i=0;i<c.length();i++) {
			change+=(char)((c.charAt(i)-'a'+(key.charAt(i%key.length())-'a'))%26+'a');
		}
		System.out.println("Message is now "+change);
		return change;
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String ans="";
		String choice="";
		String txt="";
		System.out.print("What is your plaintext/ciphertext? (Don't use any spaces and only use alphabetic characters) ");
		txt=sc.nextLine();
		while(!(ans.equalsIgnoreCase("encrypt"))||(!(ans.equalsIgnoreCase("decrypt")))||(!ans.equalsIgnoreCase("finished"))) {
			System.out.print("Would you like to encrypt, decrypt, or finished? ");
			ans=sc.nextLine();
			if(ans.equalsIgnoreCase("encrypt")) {
				System.out.println("Would you like to use?\nA. Caesar Cipher\nB. Affine Cipher\nC. Substitution Cipher\nD. Vigenere Cipher\nE. Hill Cipher");
				choice=sc.nextLine();
				if(choice.equalsIgnoreCase("a")) {
					txt=caesar(txt);
					System.out.println(txt);
				}
				if(choice.equalsIgnoreCase("b")) {
					txt=affine(txt);
				}
				if(choice.equalsIgnoreCase("c")) {
					txt=substitution(txt);
				}
				if(choice.equalsIgnoreCase("d")) {
					txt=vig(txt);
				}
				if(choice.equalsIgnoreCase("e")) {
					System.out.println("You chose E");
				}
			}
			if(ans.equalsIgnoreCase("decrypt")) {
				System.out.println("decrypting");
			}
			if(ans.equalsIgnoreCase("finished")) {
				System.out.println("FINISHED");
				break;
			}
		}
	}
}
