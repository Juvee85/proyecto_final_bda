/*
 * ConexionBD.java
 */
package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ConexionBD {

    private static MongoDatabase database;

    private ConexionBD() {}

    public static MongoDatabase getDatabase() {
        if (ConexionBD.database == null) {
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

            ConnectionString cadenaConexion = new ConnectionString("mongodb://localhost/27017");

            MongoClientSettings clientsSettings = MongoClientSettings.builder()
                    .applyConnectionString(cadenaConexion)
                    .codecRegistry(codecRegistry)
                    .build();

            MongoClient dbServer = MongoClients.create(clientsSettings);

            ConexionBD.database = dbServer.getDatabase("bazar");
        }

        return ConexionBD.database;
    }
}
