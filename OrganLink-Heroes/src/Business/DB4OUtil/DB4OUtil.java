/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Level; // Added for logging levels
import java.util.logging.Logger; // Added for logging

/**
 *
 * @author User
 */
public class DB4OUtil {

    private static final Logger logger = Logger.getLogger(DB4OUtil.class.getName());
    // Path to the data store
    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();
    private static DB4OUtil dB4OUtil;

    // Singleton pattern to get a single instance of DB4OUtil
    public synchronized static DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    // Creates a connection to the database
    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            // Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            // Controls the depth/level of object updates
            config.common().updateDepth(Integer.MAX_VALUE);

            // Register the top-most class for cascading updates
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);
            // config.common().add(new TransparentPersistenceSupport()); // Commented out for debugging
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error creating DB4O connection", ex);
        }
        return null;
    }

    // Stores the EcoSystem object in the database
    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class);
        if (systems.size() == 0) { // If no system exists, store the new one
            conn.store(system);
        } else { // If a system exists, update it
            EcoSystem oldSystem = systems.get(systems.size() - 1);
            conn.delete(oldSystem);
            conn.store(system);
        }
        conn.commit();
        conn.close();
    }

    // Retrieves the EcoSystem object from the database
    public EcoSystem retrieveSystem() {
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class); // Query for stored EcoSystem objects
        EcoSystem system;
        if (systems.size() == 0) {
            system = ConfigureASystem.configure(); // Create a new system if none exists
            System.out.println("size==0");
        } else {
            system = systems.get(systems.size() - 1); // Retrieve the latest EcoSystem object
            System.out.println("size not 0");
        }
        conn.close();
        return system;
    }

    // Shuts down the database connection
    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }
}
