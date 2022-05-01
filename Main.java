##Javaprogram to connect mongodb

package MongodbJavaPackage;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = client.getDatabase("FlightData");
        MongoCollection col = db.getCollection("TestData1");
        Document sampledoc = new Document("_id","1").append("name","Google");
        col.insertOne(sampledoc);


    }
}
