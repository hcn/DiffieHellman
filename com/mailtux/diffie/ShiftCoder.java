package com.mailtux.diffie;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

public class ShiftCoder {
	
	public String p[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"};
	Map<Integer,String> intToBok=new HashMap<>();
	Map<String,Integer> bokToInt=new HashMap<>();
	private int cycle;
	
	private String testData[]= {
			"here is a family living in Britain, known only as the KE family, ",
			"with a few members that can’t quite say words like “hippopotamus.” ",
			"They know the words, but can’t get their mouth positions quite right, ",
			"so their speech comes out garbled. Some family members have a hard time s",
			"aying words in the right order, and others have trouble reciting words that begin",
			"with the same letter. Multiple generations of the family have similar language difficulties,",
			"suggesting a genetic basis for their disorder.",
			"In the early 2000s, Oxford University geneticists Anthony Monaco, ",
			"Simon Fisher, and their colleagues found the culprit: KE family ",
			"members had a rare mutation in a gene called FOXP2.1 The mutation was subtle—only",
			"one nucleotide removed from the typical FOXP2 sequence—but the resulting ",
			"language impairment was substantial. That meant there was probably something about",
			"the normal FOXP2 gene that helped enable fluent speech. In the wake of this finding,",
			"FOXP2 was trumpeted in the press as a “grammar gene” and a “language gene.” ",
			"The public’s “language gene” assumption seemed to fit well with certain ",
			"long-standing theories about the origins of language. In the mid-1960s, ",
			"linguist Noam Chomsky proposed that the human brain is equipped with a distinct ",
			"“language organ”—a module that appeared relatively suddenly in the history of human ",
			"development. “The language organ interacts with early experience and matures into ",
			"the grammar of the language that the child speaks,” Chomsky told Omni’s John Gliedman", 
			"in a 1983 interview. "
			
			
			
	};
	
	public ShiftCoder() {
		
	
		
		int runner=0;
		for (int i = 0; i < this.p.length; i++) {
			intToBok.put(runner, this.p[i]);
			bokToInt.put(this.p[i],runner);
			runner++;
		}
		for (int i = 0; i < this.p.length; i++) {
			intToBok.put(runner, this.p[i].toUpperCase());
			bokToInt.put(this.p[i].toUpperCase(),runner);
			runner++;
		}
		this.cycle=runner;
		
		
	}
	
	@Test
	public void big() {
		BigInteger b=BigInteger.valueOf(1063);
		b=b.pow(47*763);
		String val=b.toString();
		System.out.println(val.length());
		BigInteger sekunder=new BigInteger("400000000000000000");
//		System.out.println(val);
	}
	
	@Test
	@Ignore
	public void test() {
		
		System.out.println(this.cycle);
		for (int i = 0; i < this.testData.length; i++) {
			String tekst=this.testData[i];
			System.out.println(tekst);
			for (int j = 1; j < 200; j++) {
			
			  String kodet=encode(tekst,j);
			  String dekodet=decode(kodet,j);
			  
			  if (! tekst.equals(dekodet)) {
				  System.out.println(j);
				  System.out.println(tekst);
				  System.out.println(kodet);
				  System.out.println(dekodet);
				  
			  }
			  
			assertEquals(tekst,dekodet);
			}
		}
		
		
	}

	public String encode(String klar,int shift) {
		
		StringBuffer krypt=new StringBuffer();
		for (int i = 0; i < klar.length(); i++) {
			String b=klar.substring(i, i+1);
			Integer v=this.bokToInt.get(b);
			if (v==null) {
				krypt.append(b);
			} else {
			  int sv=(v+shift) % (this.cycle);
			  String k=this.intToBok.get(sv);
			  krypt.append(k);
			}
		}
		
//		System.out.println("Krypto:"+krypt.toString());
		
		
		
		
		
		return krypt.toString();
	}
	
	public String decode(String krypto,int shift) {
		
		int bias=(shift/this.cycle+1)*this.cycle;
		StringBuffer klar=new StringBuffer();
		for (int i = 0; i < krypto.length(); i++) {
			String b=krypto.substring(i, i+1);
			Integer v=this.bokToInt.get(b);
			if (v==null) {
				klar.append(b);
			} else {
			  int sv=((v-shift)+bias) % (this.cycle);
			  String k=this.intToBok.get(sv);
			  klar.append(k);
			}
		}
		
//		System.out.println("Klar:"+klar.toString());
		
		
		
		
		
		return klar.toString();
	}

}
