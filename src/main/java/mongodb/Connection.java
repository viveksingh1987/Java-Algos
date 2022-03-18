package mongodb;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneOptions;
import org.bson.Document;

public class Connection {

    private MongoDatabase getDatabase(String databaseName){
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://mongoadmin:secret@localhost:27017/writeapp?authSource=admin"));
        return mongoClient.getDatabase(databaseName);
    }
    public MongoDatabase getMyDataBase(){
        return getDatabase("MyDatabase2");
    }
}
