package test;

import java.util.ArrayList;

import marcUtil.Print;

public class MergeKSortedLists {

	public Solution solution;
	
	public MergeKSortedLists() {
		solution = new Solution();
	}
	
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	 
	public class Solution {
	    public ListNode mergeKLists(ArrayList<ListNode> lists) {
	        ListNode result = null;
	        ListNode tmp = null;
	        //Print.collectionPrint(lists);
	        for(int i = 0 , len= lists.size();i<len;++i){
	        	if(lists.get(i)==null){
	        		lists.remove(i);
	        		--len;
	        		--i;
	        	}
	        }
	        //Print.collectionPrint(lists);
	        if (lists.size()==0) return null;
	        int index;
	        index = selectMin(lists);
	        result = lists.get(index);
	        tmp = result;
	        if (lists.get(index).next!=null) {
	            lists.set(index, lists.get(index).next);
	        }
	        else {
	            lists.remove(index);
	        }
	        while(lists.size()!=0) {
	            index = selectMin(lists);
	            tmp.next = lists.get(index);
	            tmp = tmp.next;
	            if (lists.get(index).next!=null) {
	                lists.set(index, lists.get(index).next);
	            }
	            else {
	                lists.remove(index);
	            }
	        }
	        tmp.next = null;
	        return result;
	    }
	    
	    public int selectMin(ArrayList<ListNode> lists) {
	        int tmpIndex = 0;
	        for (int i=0;i<lists.size();i++) {
	            if (lists.get(tmpIndex).val>lists.get(i).val) {
	                tmpIndex = i;
	            }
	        }
	        return tmpIndex;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MergeKSortedLists.ListNode> lists = new ArrayList<MergeKSortedLists.ListNode>();
		lists.add(null);
		(new MergeKSortedLists()).solution.mergeKLists(lists);
	}

}
