package kosta.mvc.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadDTO {

	private String name;
	private MultipartFile file; // <input type="file" name="file"/> name 따라가서 file 절대 타입 따라간거 아니다 !
	private String fileName;
	private long fileSize;
}
