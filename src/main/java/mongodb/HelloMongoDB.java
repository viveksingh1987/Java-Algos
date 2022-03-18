package mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.List;

public class HelloMongoDB {
    public static void main(String[] args) {
        Connection connection = new Connection();

        MongoDatabase db = connection.getMyDataBase();

        System.out.println( db.listCollectionNames());

        System.out.println( getPersonCollection(db));

        MongoCollection collection = getPersonCollection(db);

        List<Integer> books = Arrays.asList(27464, 747854);
        BasicDBObject person = new BasicDBObject("_id", "1234")
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("zip", 12345))
                .append("books", books);



    }

    public static MongoCollection getPersonCollection(MongoDatabase db){
            if(db.getCollection("Person") == null){
                db.createCollection("Person");
            }
            return  db.getCollection("Person");
    }
}
