package test;

//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}
 
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sorted = head;
        ListNode raw = head.next;
        ListNode current = sorted;
        ListNode previous = null;
        ListNode tmp = null;
        sorted.next = null;
        while (raw != null) {
        	printList(sorted);System.out.println();
            while (current != null) {
                if (raw.val<current.val) {
                    tmp = raw;
                    raw = raw.next;
                    tmp.next = current;
                    if (previous == null) {
                        sorted = tmp;
                    }
                    else {
                        previous.next = tmp;
                    }
                    break;
                }
                else {
                	if (current.next==null) {
                		current.next = raw;
                		raw = raw.next;
                		current.next.next = null;
                		break;
                	}
                }
                previous = current;
                current = current.next;
            }
            current = sorted;
            previous = null;
            printList(sorted);System.out.println();
        }
        return sorted;
    }


	public static void main(String[] args) {
		int [] array = {2,1,8,6,5,4,7,3};
    	ListNode head = new ListNode(10);
    	ListNode current = head;
    	for (int i=0;i<array.length;i++) {
    		current.next = new ListNode(array[i]);
    		current = current.next;
    	}
    	InsertionSortList s = new InsertionSortList();
    	head = s.insertionSortList(head);
    	s.printList(head);
	}
	
	public void printList(ListNode head) {
    	System.out.print("List: ");
    	while(head != null) {
    		System.out.print(head.val);
    		System.out.print(" ");
    		head = head.next;
    	}
    }
}
