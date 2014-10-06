package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import piles.PileTable;
import piles.PileVector;

/**
 * Class de test junit pour PileVector
 *
 * @author davidroussel
 */
public class PileTableTest
{
	/**
	 * @uml.property name="pile"
	 * @uml.associationEnd
	 */
	private PileTable pile = null;
	private int nbElements = 5;

	/**
	 * Initialisation avant l'ensemble des tests
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		// rien
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		// rien
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		pile = new PileTable(nbElements);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		while (!pile.empty())
		{
			pile.pop();
		}

		pile = null;
	}

	/**
	 * Test method for {@link PileVector#PileVector()}.
	 */
	@Test
	public void testPileVector()
	{
		assertNotNull("Creation pile vide", pile);
	}

	/**
	 * Test method for {@link PileVector#empty()}.
	 */
	@Test
	public void testEmpty()
	{
		assertTrue("pile vide", pile.empty());
	}

	/**
	 * Test method for {@link PileVector#push(java.lang.Object)}.
	 */
	@Test
	public void testPush()
	{
		// Empilement infini jusqu'ç plus de mémoire
		boolean res = true;
		while (res)
		{
			res = pile.push(new Object());
		}

		assertTrue("empilage jusqu'a pile pleine", pile.full());
	}

	/**
	 * Test method for {@link PileVector#full()}.
	 */
	@Test
	public void testFull()
	{
		Object o1 = new Integer(0);
		Object o2 = new String("Bonjour");
		Object o3 = new Double(5.0);
		boolean result = pile.push(o1);
		result = pile.push(o2);
		result = pile.push(o1);
		result = pile.push(o3);
		result = pile.push(o2);
		result = pile.push(o1);

		assertTrue("Pile pleine", pile.full());
		assertFalse("Empilage impossible dans pile pleine", result);
	}

	/**
	 * Test method for {@link PileVector#pop()}.
	 */
	@Test
	public void testPop()
	{
		// dépilage d'une pile vide
		Object result = pile.pop();
		assertNull("Depilage pile vide", result);
		// empilage
		Object value1 = new Integer(0);
		pile.push(value1);
		// dépilage pile non vide
		result = pile.pop();
		assertEquals("Depilage objet", value1, result);
	}

	/**
	 * Test method for {@link PileVector#peek()}.
	 */
	@Test
	public void testPeek()
	{
		// peek d'une pile vide
		Object result = pile.pop();
		assertNull("Peek pile vide", result);
		// empilage
		Object value1 = new Integer(0);
		pile.push(value1);
		// peek pile non vide
		result = pile.peek();
		assertEquals("Peek objet", value1, result);
	}

	/**
	 * Test method for {@link PileVector#search(java.lang.Object)}.
	 */
	@Test
	public void testSearch()
	{
		Object o1 = new Integer(0);
		Object o2 = new String("Bonjour");
		Object o3 = new Double(5.0);
		pile.push(o1); // 0
		pile.push(o2); // Bonjour
		pile.push(o1); // 0 <-- celui que l'on va chercher
		pile.push(o3); // 5.0
		pile.push(o2); // Bonjour (haut de la pile)

		int result = pile.search(o1);
		assertEquals("Recherche fructueuse dans la pile", 3, result);
		result = pile.search(new Object());
		assertEquals("Recherche infructueuse dans la pile", -1, result);
	}

	/**
	 * Test method for {@link PileVector#toString()}.
	 */
	@Test
	public void testToString()
	{
		Object o1 = new Integer(0);
		Object o2 = new String("Bonjour");
		Object o3 = new Double(5.0);
		pile.push(o1);
		pile.push(o2);
		pile.push(o1);
		pile.push(o3);
		pile.push(o2);

		String result = pile.toString();
		String expected = new String("\n0,\nBonjour,\n0,\n5.0,\nBonjour");

		assertEquals("Affichage", expected, result);
	}

}
