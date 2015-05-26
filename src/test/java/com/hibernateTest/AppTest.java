package com.hibernateTest;

import com.common.util.SpringForCmsWsTests;
import com.jpa.beans.Contact;
import com.jpa.beans.JpaTestWithSpring;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Unit test for simple HibernateTestWithConfiguration.
 */
public class AppTest extends TestCase
{
    JpaTestWithSpring jpaTestWithSpring = new JpaTestWithSpring();

    public void setUpClass() throws Exception {
        // rcarver - setup the jndi context and the datasource
        try {
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");

            // Construct DataSource
            OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
            ds.setURL("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL =TCP)(HOST=asgldsora07-vip)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=asgldsora08-vip)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=asgldsora09-vip)(PORT=1521))(LOAD_BALANCE=off)(FAILOVER=on))(CONNECT_DATA=(SERVER=DEDICATED) (SERVICE_NAME=encd.asg.bellsouth.net)))");
            ds.setUser("encoreriak_msg2");
            ds.setPassword("encoreriak_msg2");

            ic.bind("java:/messagesDS", ds);
        } catch (NamingException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AppTest( String testName ) {
        super( testName );
//        jpaTestWithSpring = (JpaTestWithSpring) SpringForCmsWsTests.getInstance().getBean("jpaTestWithSpring");
        try {
            setUpClass();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    public void testApp() {
        try {
            List<Contact> contacts = jpaTestWithSpring.getContactsByUserId("d17c3872-accb-495d-a31d-17e1ce4aa406");
            for ( Contact contact : contacts ){
                System.out.println(contact.getFirstName());
            }

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
