package com.yy.spring.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

public class FileUploadUtil {

	public static String fileUploadPathUrl = "D:\\svnproject\\wechatprintingPicture";

	/**
	 * 图片读取存放获取路径
	 *
	 * @param file     文件
	 * @param fileName 文件存放的目录名
	 * @return
	 */
	public static String saveImage(MultipartFile file, String fileName, HttpServletRequest requestFileUploadUtil) {
		long timestamp = new Date().getTime();// 获取时间戳
		String newFileName = timestamp + "" + file.getOriginalFilename(); // file.getOriginalFilename()是获取原始图片的拓展名，newfileName新的文件名字
		String[] split = newFileName.split("\\.");
		Random random = new Random();
		String rand = random.getRand();
		// String substring = newFileName.substring(newFileName.length()-4,
		// newFileName.length());
		// System.out.println(substring);
		String iurl = rand + "." + split[1];
		String path = fileName;
		System.out.println(file.getName());
		String newPath = path + "/" + iurl;//// 图片存放的位置路径
		System.out.println("新文件名字" + iurl);
		System.out.println("新路径" + newPath);
		File filePath = new File(path + "/");
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		if (!file.isEmpty()) {
			BufferedOutputStream out = null;
			try {
				out = new BufferedOutputStream(new FileOutputStream(new File(newPath)));
				out.write(file.getBytes());
				out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String url = iurl;

		return url;
	}
}
