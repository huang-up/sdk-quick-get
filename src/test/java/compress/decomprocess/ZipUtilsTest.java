package compress.decomprocess;

import org.junit.Test;

/**
 * Created by h on 2017/10/26.
 */
public class ZipUtilsTest {

    /**
     *
     */
    @Test
    public void testDecompress() throws Exception {
        // 解压到指定目录
        ZipUtils.decompress("/Users/h/test/hasChildDir/dir.txt.zip", "/Users/h/test");
    }

    /**
     *
     */
    @Test
    public void testCompress() throws Exception {
        // 压缩文件
        ZipUtils.compress("/Users/h/test/hasChildDir/dir.txt");
    }

}
