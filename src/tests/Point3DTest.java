package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import points.Point2D;
import points.Point3D;

/**
 * Class de test des Point3D
 *
 * @author davidroussel
 */
public class Point3DTest
{
	/**
	 * Point 3D à tester
	 */
	private Point3D point;

	/**
	 * Liste de points 3D
	 */
	private ArrayList<Point3D> points;

	/**
	 * Etendue max pour les random
	 */
	private static final double maxRandom = 1e9;

	/**
	 * Nombre d'essais pour les tests
	 */
	private static final long nbTrials = 1000;

	/**
	 * Nombre de subdivisions pour les étendues lors des tests
	 */
	private static final int nbSteps = 100;

	/**
	 * Constructeur de la classe de test.
	 */
	public Point3DTest()
	{
		point = null;
		points = new ArrayList<Point3D>();
	}

	/**
	 * Mise en place avant tous les tests
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		// rien
	}

	/**
	 * Nettoyage après tous les tests
	 *
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		// rien
	}

	/**
	 * Mise en place avant chaque test
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		// rien
	}

	/**
	 * Nettoyage après chaque test
	 *
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		point = null;
		points.clear();
		System.gc();
	}

	/**
	 * Assertion de la valeur de x du point "point"
	 *
	 * @param message le message associé à l'assertion
	 * @param value la valeur attendue
	 * @param tolerance la tolérance de la valeur
	 */
	private void assertX(String message, double value, double tolerance)
	{
		assertEquals(message, value, point.getX(), tolerance);
	}

	/**
	 * Assertion de la valeur de y du point "point"
	 *
	 * @param message le message associé à l'assertion
	 * @param value la valeur attendue
	 * @param tolerance la tolérance de la valeur
	 */
	private void assertY(String message, double value, double tolerance)
	{
		assertEquals(message, value, point.getY(), tolerance);
	}

	/**
	 * Assertion de la valeur de z du point "point"
	 *
	 * @param message le message associé à l'assertion
	 * @param value la valeur attendue
	 * @param tolerance la tolérance de la valeur
	 */
	private void assertZ(String message, double value, double tolerance)
	{
		assertEquals(message, value, point.getZ(), tolerance);
	}

	/**
	 * Génère un nombre aléatoire compris entre [0...maxValue[
	 *
	 * @param maxValue la valeur max du nombre aléatoire
	 * @return un nombre aléatoire compris entre [0...maxValue[
	 */
	private double randomNumber(double maxValue)
	{
		return Math.random() * maxValue;
	}

	/**
	 * Génère un nombre aléatoire compris entre [-range...range[
	 *
	 * @param range l'étendue du nombre aléatoire généré
	 * @return un nombre aléatoire compris entre [-range...range[
	 */
	private double randomRange(double range)
	{
		return (Math.random() - 0.5) * 2.0 * range;
	}

	/**
	 * Test method for {@link points.Point3D#Point3D()}.
	 */
	@Test
	public final void testPoint3D()
	{
		String testName = new String("Point3D()");
		System.out.println(testName);

		point = new Point3D();
		assertNotNull(testName + " instance", point);
		assertX(testName + ".getX() == 0.0", 0.0, 0.0);
		assertY(testName + ".getY() == 0.0", 0.0, 0.0);
		assertZ(testName + ".getZ() == 0.0", 0.0, 0.0);
	}

	/**
	 * Test method for {@link points.Point3D#Point3D(double, double, double)}.
	 */
	@Test
	public final void testPoint3DDoubleDoubleDouble()
	{
		String testName = new String("Point3D(double, double, double)");
		System.out.println(testName);

		point = new Point3D(1.0, 2.0, 3.0);
		assertNotNull(testName + " instance", point);
		assertX(testName + ".getX() == 1.0", 1.0, 0.0);
		assertY(testName + ".getY() == 2.0", 2.0, 0.0);
		assertZ(testName + ".getZ() == 3.0", 3.0, 0.0);
	}

	/**
	 * Test method for {@link points.Point3D#Point3D(points.Point2D)}.
	 */
	@Test
	public final void testPoint3DPoint2D()
	{
		String testName = new String("Point3D(Point2D)");
		System.out.println(testName);

		Point2D p2 = new Point2D(1.0, 2.0);
		point = new Point3D(p2);
		assertNotNull(testName + " instance", point);
		assertX(testName + ".getX() == 1.0", 1.0, 0.0);
		assertY(testName + ".getY() == 2.0", 2.0, 0.0);
		assertZ(testName + ".getZ() == 0.0", 0.0, 0.0);
	}

	/**
	 * Test method for {@link points.Point3D#Point3D(points.Point3D)}.
	 */
	@Test
	public final void testPoint3DPoint3D()
	{
		String testName = new String("Point3D(Point3D)");
		System.out.println(testName);

		Point3D p = new Point3D(1.0, 2.0, 3.0);
		point = new Point3D(p);
		assertNotNull(testName + " instance", point);
		assertX(testName + ".getX() == 1.0", 1.0, 0.0);
		assertY(testName + ".getY() == 2.0", 2.0, 0.0);
		assertZ(testName + ".getZ() == 3.0", 3.0, 0.0);
	}

	/**
	 * Test method for {@link points.Point3D#getZ()}.
	 */
	@Test
	public final void testGetZ()
	{
		String testName = new String("Point3D.getZ()");
		System.out.println(testName);

		point = new Point3D(0.0, 0.0, 1.0);
		assertNotNull(testName + " instance", point);
		assertEquals(testName + " == 1.0", 1.0, point.getZ(), 0.0);
	}

	/**
	 * Test method for {@link points.Point3D#setZ(double)}.
	 */
	@Test
	public final void testSetZ()
	{
		String testName = new String("Point3D.setZ(double)");
		System.out.println(testName);

		point = new Point3D();
		assertNotNull(testName + " instance", point);
		assertEquals(testName + ".getZ() == 0.0", 0.0, point.getZ(), 0.0);
		point.setZ(2.0);
		assertEquals(testName + ".getZ() == 2.0", 2.0, point.getZ(), 0.0);
	}

	/**
	 * Test method for {@link points.Point3D#toString()}.
	 */
	@Test
	public final void testToString()
	{
		String testName = new String("Point3D.toString()");
		System.out.println(testName);

		point = new Point3D(Math.PI, Math.E, Math.PI);

		String expected = new String("x = 3.141592653589793 " +
				"y = 2.718281828459045 z = 3.141592653589793");
		String result = point.toString();

		assertEquals(testName, expected, result);
	}

	/**
	 * Test method for {@link points.Point3D#deplace(double, double, double)}.
	 */
	@Test
	public final void testDeplaceDoubleDoubleDouble()
	{
		String testName = new String("Point3D.deplace(double, double, double)");
		System.out.println(testName);

		point = new Point3D();
		double origineX = point.getX();
		double origineY = point.getY();
		double origineZ = point.getZ();
		double deltaX = 5.0;
		double deltaY = 3.0;
		double deltaZ = -2.0;

		point.deplace(deltaX, deltaY, deltaZ);
		assertEquals(testName + ".getX() == " + origineX + deltaX, origineX
				+ deltaX, point.getX(), 0.0);
		assertEquals(testName + ".getY() == " + origineY + deltaY, origineY
				+ deltaY, point.getY(), 0.0);
		assertEquals(testName + ".getZ() == " + origineZ + deltaZ, origineZ
				+ deltaZ, point.getZ(), 0.0);

		Point3D retour = point.deplace(-deltaX, -deltaY, -deltaZ);
		assertSame(testName + " retour deplace = point déplacé", point, retour);
		assertEquals(testName + ".getX() == " + origineX, origineX,
				point.getX(), Point2D.getEpsilon());
		assertEquals(testName + ".getY() == " + origineY, origineY,
				point.getY(), Point2D.getEpsilon());
		assertEquals(testName + ".getZ() == " + origineZ, origineZ,
				point.getZ(), Point2D.getEpsilon());
	}

	/**
	 * Test method for
	 * {@link points.Point3D#distance(points.Point3D, points.Point3D)}.
	 */
	@Test
	public final void testDistancePoint3DPoint3D()
	{
		String testName = new String("Point3D.distance(Point3D, Point3D)");
		System.out.println(testName);

		double radius = randomNumber(maxRandom);
		double angleStep = Math.PI / nbSteps;

		// Distance entre deux points opposés le long d'une sphere
		for (double longitude = 0.0; longitude < (Math.PI * 2.0);
				longitude += angleStep)
		{
			for (double latitude = -Math.PI; latitude < Math.PI;
					latitude += angleStep)
			{
				points.clear();
				double cosl = Math.cos(latitude);
				double x = radius * Math.cos(longitude) * cosl;
				double y = radius * Math.sin(longitude) * cosl;
				double z = radius * Math.sin(latitude);
				points.add(new Point3D(x, y, z));
				points.add(new Point3D(-x, -y, -z));

				assertEquals(testName + "(P3D1, P3D2)[" + longitude + ", "
						+ latitude + "]", radius * 2.0,
						Point3D.distance(points.get(0), points.get(1)),
						Point2D.getEpsilon());
				assertEquals(testName + "(P3D2, P3D1)[" + longitude + ", "
						+ latitude + "]", radius * 2.0,
						Point3D.distance(points.get(1), points.get(0)),
						Point2D.getEpsilon());
			}
		}
	}

	/**
	 * Test method for {@link points.Point3D#distance(points.Point3D)}.
	 */
	@Test
	public final void testDistancePoint3D()
	{
		String testName = new String("Point3D.distance(Point3D)");
		System.out.println(testName);

		double origineX = randomRange(maxRandom);
		double origineY = randomRange(maxRandom);
		double origineZ = randomRange(maxRandom);

		point = new Point3D(origineX, origineY, origineZ);

		double radius = randomNumber(maxRandom);
		double angleStep = Math.PI / nbSteps;
		double tolerance = Point2D.getEpsilon();
		Point3D p2 = new Point3D();

		// Distances entre un point fixe (point) et des points le long d'une
		// sphere (p)
		for (double longitude = 0.0; longitude < (Math.PI * 2.0);
				longitude += angleStep)
		{
			for (double latitude = -Math.PI; latitude < Math.PI;
					latitude += angleStep)
			{
				double cosl = Math.cos(latitude);
				p2.setX(origineX + (radius * Math.cos(longitude) * cosl));
				p2.setY(origineY + (radius * Math.sin(longitude) * cosl));
				p2.setZ(origineZ + (radius * Math.sin(latitude)));

				assertEquals(testName + "P1P2[" + longitude + ", " + latitude
						+ "]", radius, point.distance(p2), tolerance);
				assertEquals(testName + "P2P1[" + longitude + ", " + latitude
						+ "]", radius, p2.distance(point), tolerance);
			}
		}
	}

	/**
	 * Test method for {@link points.Point3D#equals(point.Point3D)}.
	 */
	@Test
	public final void testEqualsPoint3D()
	{
		String testName = new String("Point3D.equals(Point3D)");
		System.out.println(testName);

		point = new Point3D(randomRange(maxRandom), randomRange(maxRandom),
				randomRange(maxRandom));

		// Egalité avec une copie de soi même
		Point3D otherPoint = new Point3D(point);
		assertTrue(" sur copie", point.equals(otherPoint));

		// Egalité avec un point déplacé de epsilon au plus
		double epsilon = Point2D.getEpsilon();
		for (long i = 0; i < nbTrials; i++)
		{
			otherPoint.setX(point.getX());
			otherPoint.setY(point.getY());
			otherPoint.setZ(point.getZ());
			double radius = randomNumber(epsilon);
			double longitude = randomNumber(Math.PI * 2.0);
			double latitude = randomNumber(Math.PI) - (Math.PI/2.0);
			otherPoint.deplace(
					radius * Math.cos(longitude) * Math.cos(latitude),
					radius * Math.sin(longitude) * Math.cos(latitude),
					radius * Math.sin(latitude));
			double distance = point.distance(otherPoint);

			/*
			 * Attention, à cause des approximations dues aux cos et sin
			 * le déplacement peut être légèrement supérieure à epsilon
			 */
			if (distance < epsilon)
			{
				assertTrue(testName + " point déplacé < epsilon [" + distance
						+ "]", point.equals(otherPoint));
			}
			else
			{
				assertFalse(testName + " point déplacé >= epsilon [" + distance
						+ "]", point.equals(otherPoint));
			}
		}

		// Inégalité avec un autre point
		for (long i = 0; i < nbTrials; i++)
		{
			otherPoint.setX(point.getX());
			otherPoint.setY(point.getY());
			otherPoint.setZ(point.getZ());
			double radius = randomNumber(maxRandom);
			double longitude = randomNumber(Math.PI * 2.0);
			double latitude = randomNumber(Math.PI) - (Math.PI/2.0);
			otherPoint.deplace(
					radius * Math.cos(longitude) * Math.cos(latitude),
					radius * Math.sin(longitude) * Math.cos(latitude),
					radius * Math.sin(latitude));
			double distance = point.distance(otherPoint);
			if (distance < epsilon)
			{
				assertEquals(testName + " point déplacé proche ["
						+ distance + "]", point, otherPoint);
			}
			else
			{
				assertFalse(testName + " point déplacé loin ["
						+ distance + "]", point.equals(otherPoint));
			}
		}

		// Création d'un point 2D à partir d'un point 3D
		Point2D otherPoint2D = new Point2D(point);

		// Inégalité du point2D avec le point 3D (z != 0.0)
		assertFalse(testName + " inegalité 3D/2D", point.equals(otherPoint2D));

		// Egalite du point 3D avec le point 2D (sans getClass dans Point2D.equals(Point2D)
		assertTrue(testName + " inégalité 2D/3D", otherPoint2D.equals(point));

		// Projection du point 3D sur le plan 2D
		point.setZ(0.0);

		// egalité avec un point2D copié à partir du point 3D lorsque z == 0.0
		assertTrue(testName + " egalité 3D/2D z == 0.0", point.equals(otherPoint2D));

		// Egalité avec un point 2D déplacé de epsilon au plus
		for (long i = 0; i < nbTrials; i++)
		{
			otherPoint2D.setX(point.getX());
			otherPoint2D.setY(point.getY());
			double radius = randomNumber(epsilon);
			double angle = randomNumber(Math.PI * 2.0);
			otherPoint2D.deplace(radius * Math.cos(angle),
					radius * Math.sin(angle));
			/*
			 * Attention, ci-dessous utilisation de distance(Point2D p)
			 */
			double distance = point.distance(otherPoint2D);

			if (distance < epsilon)
			{
				assertTrue(testName + " point 2D déplacé < epsilon ["
						+ distance + "]", point.equals(otherPoint2D));
			}
			else
			{
				assertFalse(testName + " point 2D déplacé >= epsilon ["
						+ distance + "]", point.equals(otherPoint2D));
			}
		}

		// Inégalité avec un point 2D déplacé
		for (long i = 0; i < nbTrials; i++)
		{
			otherPoint2D.setX(point.getX());
			otherPoint2D.setY(point.getY());
			otherPoint2D.deplace(randomRange(maxRandom), randomRange(maxRandom));
			/*
			 * Attention, ci-dessous utilisation de distance(Point2D p)
			 */
			double distance = point.distance(otherPoint2D);

			if (distance < epsilon)
			{
				assertEquals(testName + " point 2D déplacé proche [" + distance
						+ "]", point, otherPoint2D);
			}
			else
			{
				assertFalse(testName + " point 2D déplacé loin [" + distance
						+ "]", point.equals(otherPoint2D));
			}
		}
	}
}
