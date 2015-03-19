package com.mailtux.diffie;

import java.util.HashMap;
import java.util.Map;

public class ShiftCoder {
	
	public String p[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	Map<Integer,String> intToBok=new HashMap<>();
	Map<String,Integer> bokToInt=new HashMap<>();
	private int cycle;
	

	
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
