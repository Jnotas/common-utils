package ink.nota.common.test.constant;

import java.util.List;

import ink.nota.common.test.constant.TreeLinkBinTree.TreeNode;


public class TestForStudy {
	
	
	public static void main(String[] args) {
//		strigbuffertest();
//		refrence();
		TreeLinkBinTree<Object> treeLinkBinTree = new TreeLinkBinTree<>('a');
		TreeNode root = treeLinkBinTree.root();
		treeLinkBinTree.addNode(root, 'b', true);
		treeLinkBinTree.addNode(root, 'c', false);
		treeLinkBinTree.addNode(root.left, 'd', true);
		treeLinkBinTree.addNode(root.left, 'e', false);
		treeLinkBinTree.addNode(root.right, 'f', true);
		treeLinkBinTree.addNode(root.right, 'g', false);
		treeLinkBinTree.addNode(root.left.left, 'h', true);
		List<TreeNode> list = treeLinkBinTree.breadthFirst();
		for (TreeNode treeNode : list) {
			System.out.println(treeNode.data);
		}
	}
	
	private static void refrence() {
		Integer three = new Integer(1);
		String thr = "1";
		int threee = 1;
//		three = changeInteger(three);
//		thr = changeString(thr);
//		threee = changeInt(threee);
		changeIntegers(three);
		changeStrings(thr);
		changeInts(threee);
		System.out.println(three);
		System.out.println(thr);
		System.out.println(threee);
	}
	public static void changeStrings (String s) {
		s = "3";
	}
	public static void changeIntegers (Integer g) {
		g = new Integer(3);
	}
	public static void changeInts (int i) {
		i = 3;
	}
	
	public static String changeString (String s) {
		s = "3";
		return s;
	}
	public static Integer changeInteger (Integer g) {
		g = new Integer(3);
		return g;
	}
	public static int changeInt (int i) {
		i = 3;
		return i;
	}
	
	
	private static void strigbuffertest() {
		StringBuffer buffer = new StringBuffer();
		System.out.println(buffer.toString());
		buffer.append("ss");
		System.out.println(buffer.toString());
		buffer.setLength(0);
		buffer.append("new string");
		System.out.println(buffer.toString());
	}
	
}
