package com.mailtux.diffie;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Diffie {
	
	public static void main(String[] args) {
		new Diffie().doit();
	}

	private void doit() {
		
		ShiftCoder koder=new ShiftCoder();
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("Gi inn base(g):");
		int g = in.nextInt();
		System.out.print("Gi inn modulus(p):");
		int p=in.nextInt();
		System.out.print("Gi inn din hemmelige nøkkel(a):");
		int a=in.nextInt();

		BigInteger A=BigInteger.valueOf(g);
		A=A.pow(a);
		A=A.mod(BigInteger.valueOf(p));
		
		System.out.println("Ditt offentlige tall(A) er:"+A);
		
		System.out.print("Gi inn ditt motpartens offentlige tall(B):");
		int B=in.nextInt();
		
		BigInteger hemmelighet=BigInteger.valueOf(B);
		hemmelighet=hemmelighet.pow(a);
		hemmelighet=hemmelighet.mod(BigInteger.valueOf(p));
		System.out.println("Shared secret er:"+hemmelighet);
		
		System.out.print("Gi inn melding:");
		String klar=in.next();
		
		
		
		String kodet=koder.encode(klar,hemmelighet.intValue());
		System.out.println("Kodet melding:"+kodet);
		
		System.out.print("Gi inn kodet melding:");
		String andreKodet=in.next();
		String dekodet=koder.decode(andreKodet,hemmelighet.intValue());
		System.out.println("Dekodet melding:"+dekodet);
		
		
		
		
		
		
	}

}
