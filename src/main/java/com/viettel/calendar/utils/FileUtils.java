/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.utils;

import com.viettel.calendar.config.AppConfig;
import com.google.common.io.Files;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author hiepth6
 */
public class FileUtils {

    static Log logger = LogFactory.getLog(AppConfig.class.getName());
   
    private static final String CONFIG = "config";
    private static final String CONFIG_ALLOW_FILE_EXTENSION = "config.allowFileExtension";
    private static final String CONFIG_ATTACH_HOME = "config.rootFolder";

    /**
     * Kiểm tra đường dẫn đến file có hợp lệ không
     *
     * @param filePath
     * @return
     */
    public static boolean validate(String filePath) {
        // config.allowFileExtension
        ResourceBundle resource = ResourceBundle.getBundle(CONFIG);
        // Có được phép upload tệp có đuôi mở rộng như vậy lên không
        String extension = resource.getString(CONFIG_ALLOW_FILE_EXTENSION);
        if (!extension.isEmpty()) {
            String fileExtension = FileUtils.getFileExtension(filePath);
            if ((("," + extension + ",")).contains("," + fileExtension + ",")) {
                return true;
            }
        }
        // Chứa ký tự đặc biệt
        if (filePath.contains("..") || filePath.contains("\\") || filePath.contains("/")) {
            return false;
        }
        return true;
    }

    /**
     * Lấy phần mở rộng của tệp
     *
     * @param filePath
     * @return
     */
    public static String getFileExtension(String filePath) {
        String reversePath = StringUtils.reverse(filePath);
        String reverseExtension = reversePath.split("\\.")[0];
        return StringUtils.reverse(reverseExtension);
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static String toSafeFileName(String filePath) {
        // Chuyển sang tiếng việt không dấu
        filePath = AccentRemoverUtils.removeAccent(filePath);
        // Loại bỏ các ký tự đặc biệt
        filePath = filePath.replace("\\", "").replace("/", "").replace("..", "");
        return filePath;
    }

    /**
     * Lưu trữ file
     *
     * @param fileData
     * @param attachId
     * @param override
     * @param fileName
     * @return
     */
    public static String saveFile(byte[] fileData, Long attachId, String fileName, boolean override) {
        try {
            ResourceBundle resource = ResourceBundle.getBundle(CONFIG);
            String attachHome = resource.getString(CONFIG_ATTACH_HOME);
            String fileExtension = getFileExtension(fileName);
            String filePath = File.separator + attachId + File.separator + attachId + "." + fileExtension;
            File file = new File(attachHome + filePath);
            File folder = new File(file.getParent());
            if (!folder.exists()) {
                if (!createFolder(folder.getAbsolutePath())) {
                    logger.error("FileUtils::saveFile::Exception::Không tạo được folder lưu tệp");
                    return null;
                }
            }
            if (file.exists() && !override) {
                return filePath;
            }
            Files.write(fileData, file);
            return filePath;
        } catch (IOException ex) {
            logger.error("FileUtils::saveFile::Exception::", ex);
            return null;
        }
    }

    /**
     * Lấy ra dữ liệu của file từ đường dẫn truyền vào
     * @param sourcePath
     * @return
     * @throws IOException
     */
    public static byte[] loadFile(String sourcePath) throws IOException {
        InputStream inputStream = null;
        try {
            ResourceBundle resource = ResourceBundle.getBundle(CONFIG);
            String attachHome = resource.getString(CONFIG_ATTACH_HOME);
            
            inputStream = new FileInputStream(attachHome + sourcePath);
            return readFully(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
    
    /**
     * Lấy ra 1 trang của file truyền vào
     * @param sourcePath
     * @param currentPage
     * @param ext
     * @return
     * @throws IOException 
     */
    public static byte[] loadFilePage(String sourcePath, Long currentPage, String ext) throws IOException{
        InputStream inputStream = null;
        try {
            ResourceBundle resource = ResourceBundle.getBundle(CONFIG);
            String attachHome = resource.getString(CONFIG_ATTACH_HOME);
            
            inputStream = new FileInputStream((attachHome + sourcePath).substring(0,(attachHome + sourcePath).lastIndexOf(File.separator)) + File.separator + currentPage + ext);
            return readFully(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
    
    /**
     * Tạo folder
     *
     * @param folderPath
     * @return Có tạo được hay không
     */
    public static boolean createFolder(String folderPath) {
        File file = new File(folderPath);
        if (file.exists()) {
            return true;
        }
        boolean result = file.mkdirs();
        return result;
    }

    /**
     *
     * @param stream
     * @return
     * @throws IOException
     */
    public static byte[] readFully(InputStream stream) throws IOException {
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }

}
