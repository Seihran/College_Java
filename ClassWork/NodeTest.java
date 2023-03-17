public class NodeTest 
{
	public static void main(String[] args) 
	{
		Node p = new Node("Node A", null);
		Node q = new Node("Node B", null);
		p.setNext(q);
		
		Node c = new Node("Node C", null);
		Node d = new Node("Node D", null);
		
		q.setNext(c);
		c.setNext(d);
		
		q = new Node("Node E", null);
		d.setNext(q);
		
		q = new Node("Node -A", p);
		
		Node curr = q;
		while (curr != null)
		{
			System.out.println("Data in current node is: " + curr.getElement());
			curr = curr.getNext();
		}
	}
}