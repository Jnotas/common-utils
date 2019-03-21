package ink.nota.common.test.chars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * English String Sort
 * @author Frank
 *
 */
public class TestStringSort {
	
	public static void main(String[] args) {
		if (args==null || args.length==0) {
			String [] strs = {"sdaf",
					"acd",
					"sdaw",
					"Abc",
					"ab",
					"bb",
					"BAcs",
					"bgs",
					"bgsa",
					"abca",
					null,
					"abcdefghijklmno",
					"abcdefghiJklmnoy",
					"abCdefghijklmnopqrstuvwxyz",
					"abcdefghIJKLMNOpqrstuvwwyy",
					"abcdefghijklmnopqrstuvwxyzabghijklmnopqrstuvwxyz",
					"abcDEFghijklmnopqrstuvwxyzabghijklmnopqrstuv",
					"abcdefghijklmnopqrstuVWXYZAbghyuiiu",
					"abcdefghijklmnopqrstuvwxYzabghyu",
					"abcdefghijklMNopqrstuvwxyzabghyusdfassd",
					"abcdefghijklmnopqrstuvwxyzabghijklmnopqrstutexyz",
					"sd"
			};
			args = strs;
		}
		
		System.out.println("----------------------------------------------");
		System.out.println("-------TreeMapSort");
		System.out.println("----------------------------------------------");
		TreeMap<Double, Object> treeMap = sortStringsByTreeMap(args);
		treeMapSort(treeMap);

//		System.out.println("----------------------------------------------");
//		System.out.println("-------HashMapSort");
//		System.out.println("----------------------------------------------");
//		HashMap<Double, Object> hashMap = sortStringsByHashMap(args);
//		hashMapSort(hashMap);
	}
	
	
	private static void treeMapSort(TreeMap<Double, Object> treeMap) {
		treeMap.keySet().stream().forEach(e->{
			Object object = treeMap.get(e);
			if (object instanceof Map) {
				treeMapSort((TreeMap<Double, Object>)object);
			}else {
				System.out.println(object);
			}
		});
		}


	public static Dmap getPcodeByDmap(Dmap dmap) {
		String str = dmap.getSubStr();
		if(str.length() >= 15) {
			dmap.setNo(false);
			dmap.setSubStr(str.substring(15,str.length()));
			str = str.substring(0,15);
		}else {
			dmap.setNo(true);
		}
		dmap.setIndex(getPcodeStr(str));
		return dmap;
	}

	/**
	 * 获取字符串的排序编号
	 * @param str
	 * @return
	 */
	public static Dmap getPcodeByString(String str) {
		if(str == null) return null;
		Dmap dmap = new Dmap();
		dmap.setoStr(str);
		dmap.setSubStr(str);
		return getPcodeByDmap(dmap);
	}

	/**
	 *  排序算法
	 * @param str
	 * @return
	 */
	private static double getPcodeStr(String str) {
		if(str == null || str.length() == 0) return 0;
		str = str.toLowerCase();
		char[] charArray = str.toCharArray();
		double p = 0;
		double deep = 1;
		
		for (char c : charArray) {
			p += (c-96) * deep;
			deep = deep * 0.1;
		}
		return p;
	}
	
	/*
	 * String排序标记类
	 */
	static class Dmap {
		private double index;
		private String oStr;
		private String subStr;
		private boolean no = true;
		
		public double getIndex() {
			return index;
		}
		public void setIndex(double index) {
			this.index = index;
		}
		public boolean isNo() {
			return no;
		}
		public void setNo(boolean no) {
			this.no = no;
		}
		public String getoStr() {
			return oStr;
		}
		public void setoStr(String oStr) {
			this.oStr = oStr;
		}
		public String getSubStr() {
			return subStr;
		}
		public void setSubStr(String subStr) {
			this.subStr = subStr;
		}
		
	}
	
	
	

	/**
	 * sort Strings 
	 *   给字符串排序
	 * @param args
	 * @return
	 */
	private static HashMap<Double, Object> sortStringsByHashMap(String[] args) {
		HashMap<Double, Object> hashMap = new HashMap<Double,Object>();
		for (String str : args) {
			Dmap dmap = getPcodeByString(str);
			ifCreateMapNode(hashMap, dmap);
		}
		return hashMap;
	}
	
	private static TreeMap<Double, Object> sortStringsByTreeMap(String[] args) {
		TreeMap<Double, Object> treeMap = new TreeMap<Double,Object>();
		for (String str : args) {
			Dmap dmap = getPcodeByString(str);
			if(dmap == null) continue;
			ifCreateTreeMapNode(treeMap, dmap);
		}
		return treeMap;
	}

	/**
	 * 根据字符串的排序编号封装到map
	 * @param hashMap
	 * @param dmap
	 */
	private static void ifCreateMapNode(HashMap<Double, Object> hashMap, Dmap dmap) {
		if (!dmap.isNo()) {
			Object hashMapz;
			HashMap<Double, Object> hashMapNode;
			if((hashMapz = hashMap.get(dmap.getIndex())) == null) hashMapNode = new HashMap<>(); 
			else hashMapNode = (HashMap<Double, Object>) hashMapz;
			hashMap.put(dmap.getIndex(), hashMapNode);
			dmap = getPcodeByDmap(dmap);
			//递归
			ifCreateMapNode(hashMapNode,dmap);
		}else {
			hashMap.put(dmap.getIndex(),dmap.getoStr());
		}
	}
	
	private static void ifCreateTreeMapNode(TreeMap<Double, Object> treeMap, Dmap dmap) {
		if (!dmap.isNo()) {
			Object treeMapz;
			TreeMap<Double, Object> treeMapNode;
			if((treeMapz = treeMap.get(dmap.getIndex())) == null) treeMapNode = new TreeMap<>(); 
			else treeMapNode = (TreeMap<Double, Object>) treeMapz;
			treeMap.put(dmap.getIndex(), treeMapNode);
			dmap = getPcodeByDmap(dmap);
			//递归
			ifCreateTreeMapNode(treeMapNode,dmap);
		}else {
			treeMap.put(dmap.getIndex(),dmap.getoStr());
		}
	}


	/**
	 * 遍历 HashMap
	 * 按顺序打印字符串
	 * @param hashMap
	 */
	private static void hashMapSort(HashMap<Double, Object> hashMap) {
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
				hashMapSort((HashMap<Double, Object>)object);
			}else {
				System.out.println(hashMap.get(d));
			}
		}
	}
	
	
}
