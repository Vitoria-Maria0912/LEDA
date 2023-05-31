package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
    	
    	if(!node.isNIL()) {
    		
    		SingleLinkedListNode<T> head = node;
        	SingleLinkedListNode<T> aux = node.getNext();
        	
        	while(!head.isNIL()) {
        		
    	    	while(!aux.isNIL()) {
    	    		
    	    		if(head.getData().equals(aux.getData())) {
    	    			aux.setData(aux.getNext().getData());
        				aux.setNext(aux.getNext().getNext());
        				aux = aux.getNext();
    	    		}
    	    		else {
    	    			aux = aux.getNext();
    	    		}
    	    	} head = head.getNext();
    	    }
    	}
    }
}

