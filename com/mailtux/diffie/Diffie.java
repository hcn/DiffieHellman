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
		System.out.print("Hvem er du?   ");
		String hvem=in.next();
		System.out.print(hvem+" Gi inn base(g):   ");
		int g = in.nextInt();
		System.out.print(hvem+" Gi inn modulus(p):");
		int p=in.nextInt();
		System.out.print(hvem+" Gi inn din hemmelige nøkkel(a):");
		int a=in.nextInt();

		BigInteger A = beregnOffentlig(g, p, a);
		
		System.out.println(hvem+" Ditt offentlige tall(A) er:"+A);
		
		System.out.print(hvem+" Gi inn ditt motpartens offentlige tall(B):");
		int B=in.nextInt();
		
		BigInteger hemmelighet = beregnHemmelig(B, p, a);
		System.out.println(hvem+" Shared secret er:"+hemmelighet);
		
		System.out.print(hvem+" Gi inn melding:");
		String klar=in.next();
		
		String kodet=koder.encode(klar,hemmelighet.intValue());
		System.out.println(hvem+" Kodet melding:"+kodet);
		
		System.out.print(hvem+" Gi inn kodet melding:");
		String andreKodet=in.next();
		String dekodet=koder.decode(andreKodet,hemmelighet.intValue());
		System.out.println(hvem+" Dekodet melding:"+dekodet);

		
	}

	private BigInteger beregnOffentlig(int g, int p, int a) {
		BigInteger A=BigInteger.valueOf(g);
		A=A.pow(a);
		A=A.mod(BigInteger.valueOf(p));
		return A;
	}
	
	private BigInteger beregnHemmelig(int g, int p, int a) {
		BigInteger A=BigInteger.valueOf(g);
		A=A.pow(a);
		A=A.mod(BigInteger.valueOf(p));
		return A;
	}

}
