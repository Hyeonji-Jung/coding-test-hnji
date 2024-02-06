import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Node {
		int data;
		Node next = null;

		Node() {}

		Node(int data) {
			this.data = data;
		}
	}

	static class LinkedList {
		int size;
		Node head;

		LinkedList() {
			this.size = 0;
			this.head = new Node();
		}

		public boolean add(int data) {
			Node curr = head;
			while (curr.next != null)
				curr = curr.next;

			Node newNode = new Node(data);
			newNode.next = curr.next;
			curr.next = newNode;
			this.size++;
			return true;
		}

		public boolean add(int pos, int cnt, int[] data) {
			if (pos > size)
				return false;
			Node curr = head;
			for (int i = 0; i < pos; i++)
				curr = curr.next;
			for (int i = 0; i < cnt; i++) {
				Node newNode = new Node(data[i]);
				newNode.next = curr.next;
				curr.next = newNode;
				curr = newNode;
			}
			size += cnt;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node curr = head.next;
			for (int i = 0; i < 10; i++) {
				if (curr == null)
					break;
				sb.append(curr.data).append(" ");
				curr = curr.next;
			}
			return sb.toString();
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int length, commands;
	private static LinkedList codes;

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			length = Integer.parseInt(br.readLine());
			tokens = new StringTokenizer(br.readLine());
			codes = new LinkedList();
			for (int i = 0; i < length; i++)
				codes.add(Integer.parseInt(tokens.nextToken()));

			commands = Integer.parseInt(br.readLine());
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < commands; i++) {
				tokens.nextToken();
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				int[] nums = new int[y];
				for (int j = 0; j < y; j++)
					nums[j] = Integer.parseInt(tokens.nextToken());
				codes.add(x, y, nums);
			}

			sb.append("#").append(t).append(" ").append(codes.toString()).append("\n");
		}
		System.out.println(sb);
	}
}