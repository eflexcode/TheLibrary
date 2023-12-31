package com.larrex.thelibrary;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Util {
    public static final String uploadUniversalPath = "C:/Users/E.F.Lhomes/Desktop/springuploads/";
    public static final String downloadUniversalPath = "http://localhost:8093/the_library/liberian/v1/profile/";
    public static final String downloadUniversalPath2 = "http://localhost:8093/the_library/";
    public static Long exp_time = 600000L;
    public static Long JWT_TWO_MONTHS_EXP_TIME = 5259600000L;


    public static String createFile(MultipartFile multipartFile) throws IOException {
        String imageName = String.valueOf(System.currentTimeMillis() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")));
//        String downloadUrl = uploadUniversalPath+"/";

        File file = new File(Util.uploadUniversalPath, imageName);
//        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return imageName;
    }

    public static byte[] downloadImage(String filename) {
        String filepath = Util.uploadUniversalPath + filename;
        byte[] imageByte;
        try {
            imageByte = Files.readAllBytes(new File(filepath).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return imageByte;
    }
}
