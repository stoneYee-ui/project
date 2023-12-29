package com.shopping.project.product;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;


@Service
public class ProductDAO {
	
	@Autowired
	private ProductRepo pr;
	
	@Value("${picc.folderr.pathh}")
	private String picPath;
	
	private String makeFileName(MultipartFile mf) {
		String fileName = mf.getOriginalFilename(); // 업로드 된 파일명(ㅋㅋ.png)
		String type = fileName.substring(fileName.lastIndexOf(".")); // .png
		fileName = fileName.replace(type, ""); // ㅋㅋ
		String uuid = UUID.randomUUID().toString(); // e3431f6a-7c5d-4d48-90ca-494187fb4091(네트워크상에서 뭔가를 구분할때 쓰는 UUID)
		return fileName + uuid + type;
	}
	
	public void reg(MultipartFile mf, Product p, HttpServletRequest req) {
		try {
			String fileName = makeFileName(mf);
			mf.transferTo(new File(picPath + "/" + fileName));
			p.setPsp_photo(fileName);
			pr.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Resource getImageFile(String fileName) {
		try {
			return new UrlResource("file:" + picPath + "/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void get(HttpServletRequest req) {
		req.setAttribute("products", pr.findAll());
	}

}
