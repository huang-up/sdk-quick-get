package com.huang.file.vfs;

import junit.framework.TestCase;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.apache.log4j.net.SyslogAppender;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/9/8.
 *
 */

// http://pro.ctlok.com/2011/06/apache-commons-vfs-for-sftp.html
public class Vfs2Test {
    private final static Logger LOGGER = LoggerFactory.getLogger(Vfs2Test.class);

    @Test
    public void createFileObject() throws FileSystemException {

        // FileSystemManager 用来定位FileObject(resolveFile() 参数可以是 uri relativePath local)
        // This method will also automatically scan the classpath for a /META-INF/vfs-providers.xml file (also in jar files).
        // If such a file is found Commons VFS uses it in addition to the default providers.xml.
        // method 1
//        FileSystemManager fileSystemManager = VFS.getManager();

        // StandardFileSystemManager extends DefaultFileSystemManager
        // method 2
//        StandardFileSystemManager fileSystemManager = new StandardFileSystemManager();
//        fileSystemManager.setConfiguration("");
//        fileSystemManager.setLogger(); // optional
//        fileSystemManager.setDefaultProvider(); // optional
//        fileSystemManager.setReplicator(); // optional
//        fileSystemManager.setTemporaryFileStore(); // optional
//        fileSystemManager.setBaseFile(); // optional
//        fileSystemManager.init();
//        fileSystemManager.close();

        //
        // method 3
//        DefaultFileSystemManager fileSystemManager = new DefaultFileSystemManager();
//        fileSystemManager.setLogger(); // optional
//        fileSystemManager.addProvider();
//        fileSystemManager.setDefaultProvider(); // optional
//        fileSystemManager.setReplicator(); // optional
//        fileSystemManager.setTemporaryFileStore(); // optional
//        fileSystemManager.setBaseFile(); // optional
//        fileSystemManager.init();
//        fileSystemManager.close();

 /*
        // samb
        FileSystemOptions fileSystemOptions = new FileSystemOptions();
        StaticUserAuthenticator auth = new StaticUserAuthenticator("domain", "username", "password");
        DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(fileSystemOptions, auth);
        // From here, the options apply to all files that are resolved relative to this file.
        FileObject smbFileObject = VFS.getManager().resolveFile("smb://host/anyshare/dir", fileSystemOptions);
*/

/*
        // sftp
        FileSystemOptions opts = new FileSystemOptions();
        // SSH Key checking
        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
        // Root directory set to user home
        SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
        // Timeout is count by Milliseconds
        SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);
        // FileObject(不确定存在) 代表一个file或者folder, 用来访问其内容, 目录结构
        FileObject fileObject = VFS.getManager().resolveFile("sftp://username:password@domainname.com/resume.pdf");
        // 文件读写
        FileContent fileContent = fileObject.getContent();
*/
        // local
        FileSystemManager localFileSystemManager = VFS.getManager();
        FileObject localSrcFileObject = localFileSystemManager.resolveFile("file:///Users/h/test");
        FileObject localDesObject = localFileSystemManager.resolveFile("file:///Users/h/Desktop");
        // Selectors 几种标准的文件选择器实现实例
        // FileSelector 遍历文件结构时文件选择器(Type Depth All Extension Pattern 需要各自实现实例)
//        FileSelector fileSelector = new PatternFileSelector(Pattern);
        FileSelector fileSelector = Selectors.EXCLUDE_SELF;
        localDesObject.copyFrom(localSrcFileObject, Selectors.SELECT_FOLDERS);

        FileObject fileObject = localFileSystemManager.resolveFile(System.getProperty("user.dir"));
        // 文件类型(FOLDER FILE)
        FileType fileType = fileObject.getType();

        if (fileObject.exists()) {
//            LOGGER.info(String.format("file %s exist", fileObject.getName().getPath()));
            LOGGER.info(String.format("file %s exist", fileObject.getName().getURI()));
            if (fileType.equals(FileType.FOLDER)) {
                for (FileObject file:fileObject.getChildren()) {
                    LOGGER.info(file.getName().getURI());
                    LOGGER.info(file.getName().getBaseName());
                    LOGGER.info(file.getName().getPath());
                }
            }
        } else {
            fileObject.createFile();
        }


        // FileUtils 读字节、写流、拷贝FileObject
        /*FileUtil.copyContent(FileObject, FileObject);
        byte[] bytes = FileUtil.getContent(FileObject);
        FileUtil.writeContent(FileObject, OutputStream);*/


    }

    /**
     * see http://commons.apache.org/vfs/filesystems.html
     *
     *
     *
     * Local Files
     URI Format
     [file://] absolute-path
     Where absolute-path is a valid absolute file name for the local platform. UNC names are supported under Windows.
     Examples
     file:///home/someuser/somedir
     file:///C:/Documents and Settings
     file://///somehost/someshare/afile.txt
     /home/someuser/somedir
     c:\program files\some dir
     c:/program files/some dir
     *
     *
     *
     * Zip, Jar and Tar
     Provides read-only access to the contents of Zip, Jar and Tar files.
     URI Format
     zip:// arch-file-uri[! absolute-path]
     jar:// arch-file-uri[! absolute-path]
     tar:// arch-file-uri[! absolute-path]
     tgz:// arch-file-uri[! absolute-path]
     tbz2:// arch-file-uri[! absolute-path]
     Where arch-file-uri refers to a file of any supported type, including other zip files. Note: if you would like to use the ! as normal character it must be escaped using %21.
     tgz and tbz2 are convenience for tar:gz and tar:bz2.
     Examples
     jar:../lib/classes.jar!/META-INF/manifest.mf
     zip:http://somehost/downloads/somefile.zip
     jar:zip:outer.zip!/nested.jar!/somedir
     jar:zip:outer.zip!/nested.jar!/some%21dir
     tar:gz:http://anyhost/dir/mytar.tar.gz!/mytar.tar!/path/in/tar/README.txt
     tgz:file://anyhost/dir/mytar.tgz!/somepath/somefile
     *
     *
     *
     * gzip and bzip2
     Provides read-only access to the contents of gzip and bzip2 files.
     URI Format
     gz:// compressed-file-uri
     bz2:// compressed-file-uri
     Where compressed-file-uri refers to a file of any supported type. There is no need to add a ! part to the uri if you read the content of the file you always will get the uncompressed version.
     Examples
     gz:/my/gz/file.gz
     *
     *
     *
     * HTTP and HTTPS
     Provides access to files on an HTTP server.
     URI Format
     http://[ username[: password]@] hostname[: port][ absolute-path]
     https://[ username[: password]@] hostname[: port][ absolute-path]
     File System Options
     proxyHost The proxy host to connect through.
     proxyPort The proxy port to use.
     cookies An array of Cookies to add to the request.
     maxConnectionsPerHost The maximum number of connections allowed to a specific host and port. The default is 5.
     maxTotalConnections The maximum number of connections allowed to all hosts. The default is 50.
     Examples
     http://somehost:8080/downloads/somefile.jar
     http://myusername@somehost/index.html
     *
     *
     *
     * WebDAV
     Provides access to the files on an FTP server.
     URI Format
     ftp://[ username[: password]@] hostname[: port][ absolute-path]
     Examples
     ftp://myusername:mypassword@somehost/pub/downloads/somefile.tgz
     *
     *
     *
     * FTPS
     Provides access to the files on an FTP server over SSL.
     URI Format
     ftps://[ username[: password]@] hostname[: port][ absolute-path]
     Examples
     ftps://myusername:mypassword@somehost/pub/downloads/somefile.tgz
     *
     *
     *
     * SFTP
     Provides access to the files on an SFTP server (that is, an SSH or SCP server).
     URI Format
     sftp://[ username[: password]@] hostname[: port][ absolute-path]
     Examples
     sftp://myusername:mypassword@somehost/pub/downloads/somefile.tgz
     *
     *
     *
     * CIFS
     Provides access to the files on a CIFS server, such as a Samba server, or a Windows share.
     URI Format
     smb://[ username[: password]@] hostname[: port][ absolute-path]
     Examples
     smb://somehost/home
     *
     *
     *
     * Temporary Files
     Provides access to a temporary file system, or scratchpad, that is deleted when Commons VFS shuts down. The temporary file system is backed by a local file system.
     URI Format
     tmp://[ absolute-path]
     Examples
     tmp://dir/somefile.txt
     *
     *
     *
     * res
     This is not really a filesystem, it just tries to lookup a resource using javas ClassLoader.getResource() and creates a VFS url for further processing.
     URI Format
     res://[ path]
     Examples
     res:path/in/classpath/image.png
     might result in jar:file://my/path/to/images.jar!/path/in/classpath/image.png
     *
     *
     *
     * ram
     A filesystem which stores all the data in memory. You can configure the max size and a predicate (FileSelector). The predicate will be used to check if it is allowed to add a given file.
     URI Format
     ram://[ path]
     Examples
     ram:///any/path/to/file.txt
     *
     *
     *
     * mime
     This filesystem can read mails and its attachements like archives.
     If a part in the parsed mail has no name, a dummy name will be generated. The dummy name is: _body_part_X where X will be replaced by the part number.
     URI Format
     mime:// mime-file-uri[! absolute-path]
     Examples
     mime:file:///your/path/mail/anymail.mime!/
     mime:file:///your/path/mail/anymail.mime!/filename.pdf
     mime:file:///your/path/mail/anymail.mime!/_body_part_0
     *
     */
}
