package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
        import static org.junit.Assert.assertNotNull;
        import static org.junit.Assert.assertNotSame;
        import static org.junit.Assert.assertSame;
        import static org.junit.Assert.assertTrue;
        import static org.junit.Assert.fail;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.NoSuchElementException;

        import listes.Liste;
        import listes.CollectionListe;

        import org.junit.After;
        import org.junit.AfterClass;
        import org.junit.Before;
        import org.junit.BeforeClass;
        import org.junit.Test;
/**
 * Created by bopang on 16/11/14.
 */
public class simple {
    private CollectionListe<String> liste = null;
    private CollectionListe<String> oliste = null;

    /**
     * Liste des éléments à insérer dans la liste
     */
    private static String[] elements;

    /**
     * Mise en place avant l'ensemble des tests
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Test de la Liste");
        System.out.println("-------------------------------------------------");
    }

    /**
     * Nettoyage après l'ensemble des tests
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Fin Test de la Liste");
        System.out.println("-------------------------------------------------");
    }

    /**
     * Mise en place avant chaque test
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        elements = new String[] {
                "Hello",
                "Brave",
                "New",
                "World"
        };
        liste = new CollectionListe<String>();
        oliste = new CollectionListe<String>();
    }

    /**
     * Nettoyage après chaque test
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        liste.clear();
        liste = null;
    }

    @Test
    public final void start(){
        String testName = new String("Liste<String>()");
        System.out.println(testName);


        liste.add(elements[0]);
        liste.add(elements[1]);
        liste.add(elements[2]);
        liste.add(elements[3]);
        oliste.add(elements[0]);
        oliste.add(elements[1]);
        oliste.add(elements[2]);
        oliste.add(elements[3]);




        System.out.print(this.liste.equals(oliste));
//        liste.remove(elements[0]);
//        System.out.print(liste);
//        liste.supprimeTous(elements[3]);
//        System.out.print(liste);



    }

}
