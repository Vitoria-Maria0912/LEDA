package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// QueueImpl
		queue1 = new QueueImpl<Integer>(4);
		queue2 = new QueueImpl<Integer>(2);
		queue3 = new QueueImpl<Integer>(2);
		// CircularQueue
		queue1 = new CircularQueue<Integer>(4);
		queue2 = new CircularQueue<Integer>(2);
		queue3 = new CircularQueue<Integer>(2);
		// QueueUsingStack
		queue1 = new QueueUsingStack<Integer>(4);
		queue2 = new QueueUsingStack<Integer>(2);
		queue3 = new QueueUsingStack<Integer>(2);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsNotEmpty() {
		assertFalse(queue1.isEmpty());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsNotFull() {
		assertFalse(queue1.isFull());
	}
	
	@Test
	public void testIsFull() {
		assertTrue(queue2.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
		}
	}

	@Test
	public void testEnqueueComErro() throws QueueOverflowException {
		try {
			queue1.enqueue(new Integer(5));
		} catch(QueueOverflowException e) {
		}
	}

	@Test
	public void testDequeue() throws QueueUnderflowException{
		assertEquals(new Integer(1), this.queue1.dequeue()); 
	}

	@Test
	public void testDequeueComErro() throws QueueUnderflowException {
		try {
			assertEquals(new Integer(1), this.queue3.dequeue());
		} catch(QueueUnderflowException e) {
		}
	}
}
