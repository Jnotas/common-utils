package ink.nota.common.test.chars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class TestStringSort {
	
	
	public static Dmap getPcode(String str) {
		if(str == null) return null;
		Dmap dmap = new Dmap();
		String str2 = null;
		if(str.length() > 15) {
			dmap.setNo(false);
			str2 = str.substring(15,str.length());
			str = str.substring(0,15); 
		}
		
		dmap.setA(getPcodeStr(str));
		if(!dmap.isNo()) dmap.setB(getPcodeStr(str2));
		return dmap;
	}


	private static double getPcodeStr(String str) {
		char[] charArray = str.toCharArray();
		double p = 0;
		double deep = 1;
		
		for (char c : charArray) {
			p += c * deep;
			deep = deep * 0.1;
		}
//		System.out.println(str + "=" + p);
		return p;
	}
	static class Dmap {
		private double a;
		private double b;
		private boolean no = true;
		public double getA() {
			return a;
		}
		public void setA(double a) {
			this.a = a;
		}
		public double getB() {
			return b;
		}
		public void setB(double b) {
			this.b = b;
		}
		public boolean isNo() {
			return no;
		}
		public void setNo(boolean no) {
			this.no = no;
		}
		
	}
	
	
	public static void main(String[] args) {
		HashMap<Double, Object> hashMap = new HashMap<>();
		String [] strs = {"sdaf","acd","sdaw","abc","ab","abca","abcdefghijklmnopqrstuvwxyz","abcdefghijklmnopqrstuvwwyy"};
		int i = 0;
		for (String str : strs) {
			Dmap dmap = getPcode(str);
			if (!dmap.isNo()) {
				Object hashMapz;
				HashMap<Double, Object> hashMapNode;
				if((hashMapz = hashMap.get(dmap.getA())) == null) hashMapNode = new HashMap<>(); 
				else hashMapNode = (HashMap<Double, Object>) hashMapz;
				hashMapNode.put(dmap.getB(), str);
				hashMap.put(dmap.getA(), hashMapNode);
			}else {
				hashMap.put(dmap.getA(), str);
			}
			i++;
		}
		double[] ds = new double[hashMap.size()];
		Set<Double> keySet2 = hashMap.keySet();
		int p = 0;
		for (Double double1 : keySet2) {
			ds[p] = double1;
			p++;
		}
		Arrays.sort(ds);
		for (double d : ds) {
			Object object = hashMap.get(d);
			if(object instanceof Map) {
			 	HashMap<Double, Object> map = (HashMap<Double, Object>)object;
			 	Set<Double> keySet = map.keySet();
			 	double[] ps = new double[keySet.size()];
			 	int t = 0;
			 	for (double e : keySet) {
			 		ps[t] = e;
			 		t++;
				}
			 	Arrays.sort(ps);
			 	for (double e : ps) {
			 		System.out.println(map.get(e)+ "--" + e );
				}
			}else {
				System.out.println(hashMap.get(d)+ "--" + d );
			}
		}
		
	}
}
