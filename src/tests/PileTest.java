package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import piles.Pile;
import piles.PileFactory;
import piles.PileTable;
import piles.PileVector;

/**
 * Classe de test pour l'ensemble des implémenetation de piles
 *
 * @author davidroussel
 */
@RunWith(value = Parameterized.class)
public class PileTest
{
	/**
	 * La pile à tester
	 */
	private Pile pile;

	/**
	 * Le type de pile à tester
	 */
	private Class<? extends Pile> typePile;

	/**
	 * Le nom du type de pile à tester
	 */
	private String typeName;

	/**
	 * Les différentes natures de piles à tester
	 */
	@SuppressWarnings("unchecked")
	private static final Class<? extends Pile>[] typesPile = (Class<? extends Pile>[]) new Class<?>[] {
			PileVector.class, PileTable.class };

	/**
	 * Elements pour remplir une pile : "0, Bonjour, 5.0"
	 */
	private static final Object[] elements = new Object[] { new Integer(0),
			new String("Bonjour"), new Double(5.0) };

	/**
	 * Paramètres à transmettre au constructeur de la classe de test.
	 *
	 * @return une collection de tableaux d'objet contenant les paramètres à
	 *         transmettre au constructeur de la classe de test
	 */
	@Parameters
	public static Collection<Object[]> data()
	{
		Object[][] data = new Object[typesPile.length][1];
		for (int i = 0; i < typesPile.length; i++)
		{
			data[i][0] = typesPile[i];
		}
		return Arrays.asList(data);
	}

	/**
	 * Constructeur paramêtré par le type de pile à tester. Lancé pour chaque
	 * test
	 *
	 * @param typePile le type de pile à générer
	 */
	public PileTest(Class<? extends Pile> typePile)
	{
		this.typePile = typePile;
		typeName = typePile.getSimpleName();
	}

	/**
	 * construction d'une instance de pile en spécifiant le type de pile
	 *
	 * @param testName nom du test dans lequel une instance de pile est requise
	 * @param type type de pile à construire
	 * @param other autre pile à utiliser (lors du test du constructeur de
	 *            copie)
	 * @return une nouvelle instance d'une pile
	 */
	private static Pile constructPile(String testName,
			Class<? extends Pile> type,
			Pile other)
	{
		Pile pile = null;

		try
		{
			pile = PileFactory.getPile(type, other);
		}
		catch (SecurityException e)
		{
			fail(testName + " constructor security exception");
		}
		catch (IllegalArgumentException e)
		{
			fail(testName + " wrong constructor arguments");
		}
		catch (NoSuchMethodException e)
		{
			fail(testName + " constructor not found");
		}
		catch (InstantiationException e)
		{
			fail(testName + " instanciation exception");
		}
		catch (IllegalAccessException e)
		{
			fail(testName + " illegal access");
		}
		catch (InvocationTargetException e)
		{
			fail(testName + " invocation exception");
		}

		return pile;
	}

	/**
	 * Mise en place avant l'ensemble des tests
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		// rien
	}

	/**
	 * Nettoyage après l'ensemble des tests
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		// rien
	}

	/**
	 * Mise en place avant chaque test
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		pile = constructPile("setUp", typePile, null);
		assertNotNull("setUp non null pile failed", pile);
	}

	/**
	 * Nettoyage après chaque test
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		if (pile != null)
		{
			while (!pile.empty())
			{
				pile.pop();
			}
			pile = null; // pour permettre au GB de le nettoyer
		}
	}

	/**
	 * Test method for {@link piles.PileVector#PileVector()} or
	 * {@link piles.PileTable#PileTable()}
	 */
	@Test
	public final void testDefaultConstructor()
	{
		String testName = new String(typeName + "()");
		System.out.println(testName);

		pile = constructPile(testName, typePile, null);
		assertNotNull(testName + " non null instance failed", pile);
		assertEquals(testName + " instance type failed", typePile,
				pile.getClass());
		assertTrue(testName + " empty instance failed", pile.empty());
		assertEquals(testName + " instance size failed", 0, pile.size());
	}

	/**
	 * Test method for {@link piles.PileVector#PileVector(Pile)} or
	 * {@link piles.PileTable#PileTable(Pile)}
	 */
	@Test
	public final void testCopyConstructor()
	{
		for (Class<? extends Pile> localPileType : typesPile)
		{
			String otherPileTypeName = localPileType.getSimpleName();
			String testName = new String(typeName + "(" + otherPileTypeName
					+ ")");
			System.out.println(testName);

			Pile otherPile = constructPile(testName, localPileType, null);

			for (Object o : elements)
			{
				otherPile.push(o);
			}

			pile = constructPile(testName, typePile, otherPile);
			assertNotNull(testName + " non null instance failed", pile);
			assertEquals(testName + " instance type failed", typePile,
					pile.getClass());
			assertTrue(testName + " not empty instance failed", !pile.empty());
			assertEquals(testName + " instance size failed", elements.length,
					pile.size());

			for (int i = elements.length - 1; i >= 0; i--)
			{
				Object popped = pile.pop();
				assertEquals(testName
						+ "popped element value check with elements[" + i
						+ "] failed", popped, elements[i]);
				assertEquals(testName + "popped element value check with "
						+ otherPileTypeName + "otherPile[" + i + "] failed",
						popped, otherPile.pop());
			}
		}
	}

	/**
	 * Test method for {@link piles.Pile#empty()}.
	 */
	@Test
	public final void testEmpty()
	{
		String testName = new String(typeName + ".empty()");
		System.out.println(testName);

		assertTrue(testName + " pile vide failed", pile.empty());

		pile.push(new Object());
		assertFalse(testName + " pile non vide failed", pile.empty());
	}

	/**
	 * Test method for {@link piles.Pile#full()}.
	 */
	@Test(expected = OutOfMemoryError.class)
    @Ignore
	public final void testFull()
	{
		String testName = new String(typeName + ".full()");
		System.out.println(testName);

		// empilement jusqu'à ce qu'il échoue
		boolean res = true;
		while (res)
		{
			res = pile.push(new Object());
		}

		if (typePile.equals(PileVector.class))
		{
			// Une pile à base de Vector n'est jamais pleine, une
			// OutOfMemoryError aurait dû être générée avant que l'on arrive ici
			fail(testName + " managed to be full");
		}
		else // typePile == PileTable
		{
			assertTrue(testName + " pile full failed", pile.full());

			throw new OutOfMemoryError(); // because it is expected
		}
	}

	/**
	 * Test method for {@link piles.Pile#push(java.lang.Object)}.
	 */
	@Test(expected = OutOfMemoryError.class)
    @Ignore
	public final void testPush()
	{
		String testName = new String(typeName + ".push()");
		System.out.println(testName);

		// Empilage possible d'un élément null
		assertTrue(testName + " null push failed", pile.push(null));

		// Empilement infini jusqu'à plus de mémoire
		boolean res = true;
		while (res)
		{
			res = pile.push(new Object());
		}

		assertFalse(testName + " push succeeded beyond full", res);

		if (typePile.equals(PileTable.class))
		{
			assertTrue(testName + " fulled pile failed", pile.full());
			throw new OutOfMemoryError(); // because it is expected
		}
	}

	/**
	 * Test method for {@link piles.Pile#pop()}.
	 */
	@Test
	public final void testPop()
	{
		String testName = new String(typeName + ".pop()");
		System.out.println(testName);

		// dépilage d'une pile vide
		Object result = pile.pop();
		assertNull(testName + "Depilage pile vide failed", result);

		// empilage
		for (Object o : elements)
		{
			pile.push(o);
		}

		// dépilage pile non vide
		for (int i = elements.length - 1; i >= 0; i--)
		{
			result = pile.pop();
			assertEquals(testName + " Depilage objet failed", elements[i],
					result);
		}

		result = pile.pop();
		assertNull(testName + "Depilage supplementaire pile vide failed",
				result);
	}

	/**
	 * Test method for {@link piles.Pile#peek()}.
	 */
	@Test
	public final void testPeek()
	{
		String testName = new String(typeName + ".peek()");
		System.out.println(testName);

		// peek d'une pile vide
		Object result = pile.peek();
		assertNull(testName + "Peek pile vide", result);
		// empilage
		Object value1 = new Integer(0);
		pile.push(value1);
		// peek pile non vide
		result = pile.peek();
		assertEquals(testName + "Peek objet", value1, result);
	}

	/**
	 * Test method for {@link piles.Pile#search(java.lang.Object)}.
	 */
	@Test
	public final void testSearch()
	{
		Object o1 = new Integer(0);
		Object o2 = new String("Bonjour");
		Object o3 = new Double(5.0);
		pile.push(o1);
		pile.push(o2);
		pile.push(o1); // <-- celui que l'on va chercher
		pile.push(o3);
		pile.push(o2);

		int result = pile.search(o1);
		int expectedRank;
		if (typePile.equals(PileTable.class))
		{
			expectedRank = 1;
		}
		else
		{
			expectedRank = 3;
		}
		assertEquals("Recherche fructueuse dans la pile failed", expectedRank,
				result);
		result = pile.search(new Object());
		assertEquals("Recherche infructueuse dans la pile failed", -1, result);
	}

	/**
	 * Test method for {@link piles.Pile#size()}.
	 */
	@Test
	public final void testSize()
	{
		String testName = new String(typeName + ".size()");
		System.out.println(testName);

		// size d'une pile vide
		assertEquals(testName + " empty pile size failed", 0, pile.size());

		// remplissage
		for (Object o : elements)
		{
			pile.push(o);
		}

		// size d'une pile non vide
		assertEquals(testName + " not empty pile size failed", elements.length,
				pile.size());
	}

	/**
	 * Test method for {@link piles.Pile#toString()}.
	 */
	@Test
	public final void testToString()
	{
		String testName = new String(typeName + ".toString()");
		System.out.println(testName);

		// pile vide
		String expected = new String("");
		String result = pile.toString();
		assertEquals(testName + " empty failed", expected, result);

		// pile non vide
		StringBuilder expectedSb = new StringBuilder();
		for (int i = 0; i < elements.length; i++)
		{
			pile.push(elements[i]);
			expectedSb.append("\n" + elements[i].toString());
			if (i < (elements.length - 1))
			{
				expectedSb.append(",");
			}

		}

		expected = new String(expectedSb);
		result = pile.toString();
		assertEquals(testName + " not empty failed", expected, result);

	}

	/**
	 * Test method for {@link piles.Pile#equals(Object)}.
	 */
	@Test
	public final void testEquals()
	{
		String testName = new String(typeName + ".equals(Object)");
		System.out.println(testName);
		boolean result;

		// Test d'un objet null
		result = pile.equals(null);
		assertFalse(testName + " with null object failed", result);

		// remplissage
		for (Object o : elements)
		{
			pile.push(o);
		}

		// Test avec soi même
		result = pile.equals(pile);
		assertTrue(testName + " with self object failed", result);

		// Test avec une copie de soi même
		Pile copy = constructPile(testName, typePile, pile);
		result = pile.equals(copy);
		assertTrue(testName + " with copied object failed", result);

		// Test avec une version différente de soi même
		if (copy.size() > 0)
		{
			copy.pop();
			result = pile.equals(copy);
			assertFalse(testName + " with another pile failed", result);
		}
		else
		{
			fail(testName + " nothing to pop on copy");
		}
	}

	/**
	 * Test method for {@link piles.Pile#hashCode()}.
	 */
	@Test
	public final void testHashCode()
	{
		String testName = new String(typeName + ".hashCode()");
		System.out.println(testName);

		int result = pile.hashCode();

		// hashCode d'une pile vide == 1
		assertEquals(testName + " empty Pile failed", 1, result);

		// remplissage
		Vector<Object> vector = new Vector<Object>();
		for (Object o : elements)
		{
			pile.push(o);
			vector.add(o);
		}

		Pile copy = constructPile(testName, typePile, pile);

		// On vérifie que les piles sont identiques
		assertEquals(testName + " equality to copy failed", pile, copy);

		// Le calcul du hashcode se fait dans l'ordre de dépilage
		final int prime = 31;
		int hash = 1;
		while (!copy.empty())
		{
			Object elt = copy.pop();
			hash = (prime * hash) + (elt == null ? 0 : elt.hashCode());
		}

		// deux piles identiques ont un hascode identique
		assertEquals(testName + " failed", hash, pile.hashCode());

		// En revanche une pile et un vector de même contenu n'ont pas
		// un hashcode identique puisque l'on dépile toujours le dernier
		// élément en premier
		assertTrue(testName + " standard collection failed",
				pile.hashCode() != vector.hashCode());

		// on vérifie que copy est vide avant de le reremplir dans l'ordre inverse
		assertTrue(testName + " copy empty failed", copy.empty());

		// remplissage avec les mêmes éléments mais à l'envers
		for (int i = elements.length-1; i >= 0; i--)
		{
			copy.push(elements[i]);
		}

		// on vérifie que pile et copy sont maintenant !=
		assertFalse(testName + " reverse copy inequality failed",
				pile.equals(copy));

		// et on vérifie que leurs hasCode sont différents
		assertTrue(testName + " reverse copy hashCode failed",
				copy.hashCode() != pile.hashCode());
	}
}
