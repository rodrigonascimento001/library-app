package com.br.rodrigo.libraryapp.infra;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.br.rodrigo.libraryapp.exceptions.UploadException;
import com.br.rodrigo.libraryapp.util.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.br.rodrigo.libraryapp.util.Constants.BUCKET;

@Component
public class FileSaver {
	@Autowired
	private Environment env;

	@Autowired
	private AmazonS3 amazonS3;

	@Autowired
	private HttpServletRequest request;

	public String write(MultipartFile file) throws UploadException {
		try {
			amazonS3.putObject(new PutObjectRequest(env.getProperty(BUCKET),file.getOriginalFilename(),
					file.getInputStream(),null)
					.withCannedAcl(CannedAccessControlList.PublicRead)
			);

			return "https://"+BUCKET+".s3."+ Region.US_EAST_1.getName() +".amazonaws.com/"+file.getOriginalFilename();
			
		} catch (IllegalStateException | IOException e) {
			throw new UploadException("Erro ao executar upload do arquivo");
		}
	}

	public void deleteObject(String objectName){
		amazonS3.deleteObject(BUCKET, objectName);
	}
}









