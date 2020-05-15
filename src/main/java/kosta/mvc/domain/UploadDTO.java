package kosta.mvc.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadDTO {

	private String name;
	private MultipartFile file; // <input type="file" name="file"/> name ���󰡼� file ���� Ÿ�� ���󰣰� �ƴϴ� !
	private String fileName;
	private long fileSize;
}
