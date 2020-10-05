package Deque;

public abstract class DoubleLinkedSequence<E>{

    protected class NodeSequenceDL {

        private E value;
        private NodeSequenceDL next;
        private NodeSequenceDL previous;

        NodeSequenceDL(){
            this.value = null;
            this.next = null;
            this.previous = null;
        }

        NodeSequenceDL(E e){
            this.value = e;
            this.next = null;
            this.previous = null;
        }

        public E getValue(){
            return this.value;
        }

        public void setValue(E e){
            this.value = e;
        }

        public NodeSequenceDL getNext(){
            return this.next;
        }

        public void setNext(NodeSequenceDL n){
            this.next = n;
        }

        public NodeSequenceDL getPrevious(){
            return this.previous;
        }

        public void setPrevious(NodeSequenceDL n){
            this.previous = n;
        }
    }

    private class SequenceIteratorDL {

        private NodeSequenceDL currentNode;

        SequenceIteratorDL(){
            this.currentNode = firstNode;
        }

        public E getNext() {
            E elem = this.currentNode.getValue();
            this.currentNode = this.currentNode.getNext();
            return elem;
        }

        public boolean hasNext() {
            return this.currentNode != null;
        }

        public void reset() {
            this.currentNode = firstNode;
        }

    }

    protected NodeSequenceDL firstNode;
	protected int size;

    private NodeSequenceDL getFirstNode() {
        return this.firstNode;
    }

    public DoubleLinkedSequence () {
        super();               
        this.firstNode = null; 
    }

    public DoubleLinkedSequence (DoubleLinkedSequence<E> s) {
        this();
        if ( ! s.isEmpty() ) {
            this.size = s.size();
            NodeSequenceDL nodeS = s.getFirstNode();
            NodeSequenceDL pNode = new NodeSequenceDL(nodeS.getValue());
            this.firstNode = pNode;
            while ( nodeS.getNext() != null ) {
                nodeS = nodeS.getNext();
                NodeSequenceDL newNode = new NodeSequenceDL(nodeS.getValue());
                newNode.setPrevious(pNode);
                pNode.setNext(newNode);
                pNode = newNode;
            }
        }
    }
	
	public isEmpty() {
		return size == 0;
	}
	
	public size() {
		return size;
	}

    public void clear () {
        super.clear();    
        this.firstNode = null; 
    }

    public boolean contains(E e) {
        NodeSequenceDL node = this.firstNode;
        while(node!=null){
            E next = node.getValue();
            if(next.equals(e)){
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public IteratorIF<E> iterator() {
        return new SequenceIteratorDL();
    }

    protected NodeSequenceDL getNode(int i){
        NodeSequenceDL node = this.firstNode;
        for ( int aux = 1 ; aux < i ; aux++ ) {
            node = node.getNext();
        }
        return node;
    }
}
