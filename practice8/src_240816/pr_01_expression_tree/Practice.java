package pr_01_expression_tree;

public class Practice {
	static char[] tree = {0, '+', 'x', '-', '1', '2', '3', '4'};

	public static void main(String[] args) {
		
		inorder(1);
		System.out.println();
		postorder(1);
	}
	
	// LVR
	static void inorder(int root) {
//		// 기저조건1: 인덱스가 배열 범위를 벗어남
//		if (root >= tree.length)
//			return;
//		// 기저조건2: 리프노드인 경우, 리프노드는 항상 피연산자
//		if ('0' <= tree[root] && tree[root] <= '9') {
//			System.out.print(tree[root]);
//			return;
//		}
		
		if (root * 2 < tree.length)
			inorder(root * 2);
		System.out.print(tree[root]);
		if (root * 2 + 1 < tree.length)
			inorder(root * 2 + 1);
	}
	
	// LRV
	static void postorder(int root) {
		if (root * 2 < tree.length)
			postorder(root * 2);
		if (root * 2 + 1 < tree.length)
			postorder(root * 2 + 1);
		System.out.print(tree[root]);
	}
}
