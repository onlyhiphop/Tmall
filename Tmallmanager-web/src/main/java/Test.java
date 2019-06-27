import org.csource.fastdfs.*;

/**
 * @author lbc
 * @description: TODO
 * @date 2019/6/22 17:29
 */
public class Test {

    /**
     * 测试fastDFS
     */
    public void testUpload() throws Exception{
        //创建一个配置文件。文件名任意。内容就是tracker服务器的地址
        //使用全局对象加载配置文件。
        ClientGlobal.init("D:\\java\\IDEA-Tmall\\Tmallmanager-web\\src\\main\\resources\\conf\\client.conf");

        //创建一个TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();

        //通过TrackClient获得一个TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();

        //创建一个StorageServer的引用，可以是null
        StorageServer storageServer = null;

        //创建一个StorageClient，参数需要TrackerServer和StorageServer
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        //使用StorageClient上传文件
        String[] strings = storageClient.upload_file("D:/1.jpg", "jpg", null);

        for (String string : strings){
            System.out.println(string);
        }
    }

}















