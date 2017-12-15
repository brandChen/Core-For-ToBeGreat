//package mongodb;
//
//import java.util.List;
//
//import org.bson.Document;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.mongodb.client.result.UpdateResult;
//
//public class MongoTest {
//    @Before
//    public void before() {
//        MongoDb.connect("test", "darren", "172.16.155.151", 27017);
//    }
//
//    @Test
//    public void testInsert() {
//        Document document = new Document();
//        document.append("name", "wang").append("gender", "female");
//        MongoDb.insert(document);
//    }
//
//    @Test
//    public void testFindAll() {
//        List<Document> results = MongoDb.findAll();
//        for (Document doc : results) {
//            System.out.println(doc.toJson());
//        }
//    }
//
//    @Test
//    public void testFindBy() {
//        Document filter = new Document();
//        filter.append("name", "li si");
//        List<Document> results = MongoDb.findBy(filter);
//        for (Document doc : results) {
//            System.out.println(doc.toJson());
//        }
//    }
//
//    @Test
//    public void testUpdateOne() {
//        Document filter = new Document();
//        filter.append("gender", "male");
//
//        //注意update文档里要包含"$set"字段
//        Document update = new Document();
//        update.append("$set", new Document("gender", "female"));
//        UpdateResult result = MongoDb.updateOne(filter, update);
//        System.out.println("matched count = " + result.getMatchedCount());
//    }
//
//    @Test
//    public void testUpdateMany() {
//        Document filter = new Document();
//        filter.append("gender", "female");
//
//        //注意update文档里要包含"$set"字段
//        Document update = new Document();
//        update.append("$set", new Document("gender", "male"));
//        UpdateResult result = MongoDb.updateMany(filter, update);
//        System.out.println("matched count = " + result.getMatchedCount());
//    }
//
//    @Test
//    public void testReplace() {
//        Document filter = new Document();
//        filter.append("name", "zhang");
//
//        //注意：更新文档时，不需要使用"$set"
//        Document replacement = new Document();
//        replacement.append("value", 123);
//        MongoDb.replace(filter, replacement);
//    }
//
//    @Test
//    public void testDeleteOne() {
//        Document filter = new Document();
//        filter.append("name", "li");
//        MongoDb.deleteOne(filter);
//    }
//
//    @Test
//    public void testDeleteMany() {
//        Document filter = new Document();
//        filter.append("gender", "male");
//        MongoDb.deleteMany(filter);
//    }
//}