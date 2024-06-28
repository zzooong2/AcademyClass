package kr.co.green.common.upload;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dto.BoardDto;

@Component
public class UploadFile {
	
	public static final String UPLOAD_PATH = "/Users/zzooong2/green/Green/src/kr/co/Spring/Project/src/main/webapp/resources/uploads/";
	
	public void upload(BoardDto bDto, MultipartFile upload, HttpSession session) {
		// 원본 파일 이름
		String originName = upload.getOriginalFilename();

		// 파일의 확장자
		String extension = originName.substring(originName.lastIndexOf("."));
		
		// 현재 시간 (년,월,일,시,분,초)
		LocalDateTime now = LocalDateTime.now();
		
		// 현재시간을 포맷으로 저장
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String output = now.format(formatter);
		
		// 랜덤문자열 생성
		int stringLength = 8; // 생성할 문자열의 길이
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		Random random = new Random();
		String randomString = random.ints(stringLength, 0, characters.length()) // 길이가 stringLength인 난수 생성
									.mapToObj(characters::charAt) // 생성한 난수에 characters에 선언된 문자를 랜덤으로 매핑시킴
									.map(Object::toString) // char -> string 형 변환
									.collect(Collectors.joining()); // 문자열 결합

		// 파일명: 날짜_랜덤문자열.확장자
		String fileName = output + "_" + randomString + extension;
		
		// 경로 + 파일명
		String filePathName = UPLOAD_PATH + fileName;
		
		// 저장 전, Path 타입으로 변환
		Path filePath = Paths.get(filePathName);
		
		// 저장 로직
		try {
			upload.transferTo(filePath);
			
			bDto.setUploadPath(UPLOAD_PATH);
			bDto.setUploadName(fileName);
			bDto.setUploadOriginName(originName);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
