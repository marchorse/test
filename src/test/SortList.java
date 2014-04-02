package test;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortList {
    public ListNode sortList(ListNode head) {
    	if (head == null) return null;
        ListNode current;
        current = head;
        int listLength = 0;
        while(current != null) {
            listLength ++;
            current = current.next;
        }
        return mergeSort(head, listLength);
    }
    
    public void printList(ListNode head) {
    	System.out.print("List: ");
    	while(head != null) {
    		System.out.print(head.val);
    		System.out.print(" ");
    		head = head.next;
    	}
    }
    
    public ListNode mergeSort(ListNode head, int listLength) {
    	printList(head);System.out.println("splitting");
        if (listLength == 1) return head;
        ListNode splitPoint = null;
        ListNode current = head;
        for (int m=0;m<listLength/2-1;m++) {
            current = current.next;
        }
        splitPoint = current.next;
        current.next = null;
        head = mergeSort(head, listLength/2);
        splitPoint = mergeSort(splitPoint, listLength-listLength/2);
        return mergeList(head, splitPoint);
    }
    
    public ListNode mergeList(ListNode head, ListNode splitPoint) {
        ListNode current;
        ListNode result;
        if (head.val < splitPoint.val) {
            current = head;
            head = head.next;
        }
        else {
            current = splitPoint;
            splitPoint = splitPoint.next;
        }
        result = current;
        while (head!=null && splitPoint!=null) {
            if (head.val < splitPoint.val) {
                current.next = head;
                current = current.next;
                head = head.next;
            }
            else {
                current.next = splitPoint;
                current = current.next;
                splitPoint = splitPoint.next;
            }
        }
        if (head == null) {
            current.next = splitPoint;
        }
        else {
            current.next = head;
        }
        printList(result);System.out.println("merging");
        return result;
    }
    
    public static void main (String [] args) {
    	int [] array = {2,1,8,6};//,5,4,7,3};
    	ListNode head = new ListNode(10);
    	ListNode current = head;
    	for (int i=0;i<array.length;i++) {
    		current.next = new ListNode(array[i]);
    		current = current.next;
    	}
    	SortList s = new SortList();
    	head = s.sortList(head);
    	s.printList(head);
    }
}