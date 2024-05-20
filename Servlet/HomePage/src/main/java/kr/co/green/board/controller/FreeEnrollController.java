package kr.co.green.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.co.green.board.model.dto.FreeDTOImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/enroll.do")
public class FreeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 데이터 받아서 변수에 저장
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 게시글 작성자 확인
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("userNo");
		
		// DTO 정보저장
		FreeDTOImpl freeDTO = new FreeDTOImpl();
		freeDTO.setBoardTitle(title);
		freeDTO.setBoardContent(content);
		freeDTO.setMemberNo(memberNo);
		
		// 파일 업로드
		Collection<Part> parts = request.getParts();
		String uploadDirectory = "/Users/zzooong2/green/Green/src/kr/co/Servlet/HomePage/src/main/webapp/resources/uploads/freeBoard";
		
		// 파일 업로드 디렉토리가 존재하지 않으면 생성
		File filePath = new File(uploadDirectory);
		if(!filePath.exists()) {
			filePath.mkdirs();
		}

		// 서비스 호출
		FreeServiceImpl freeService = new FreeServiceImpl();
		int result = freeService.enroll(freeDTO); // 게시글 등록
		
		// 게시글 번호 가져오기
		freeService.selectNo(freeDTO);
		
		
		// 게시글에 파일 첨부하기
		String fileName = null;
		for(Part part : parts) {
			fileName = getFileName(part);
			if(fileName != null) {
				part.write(filePath + File.separator + fileName);
				
				freeDTO.setFilePath(uploadDirectory);
				freeDTO.setFileName(fileName);
				int resultUpload = freeService.fileUpload(freeDTO);
			}
		}
		
		if(result == 1) {
			response.sendRedirect("/freeBoard/list.do?cPage=1&category=fb_title&seach-text=");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/board/free/freeEnroll.jsp");
			view.forward(request, response);
		}
	}

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return null;
    }

}
