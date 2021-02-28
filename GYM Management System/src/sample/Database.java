package sample;


import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Database {
    //creating the local host
    public static MongoClient GYMhost = new MongoClient("localhost",27017);

    //Creating the database
    public static DB GYMDatabase = GYMhost.getDB("GYMDatabase");

    //Creating the collection
    public static void addDatabase() {
        GYMDatabase.createCollection("GYMList",null);

    }

}
