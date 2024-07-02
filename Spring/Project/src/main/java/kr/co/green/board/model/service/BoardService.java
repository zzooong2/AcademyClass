package kr.co.green.board.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dto.BoardDto;
import kr.co.green.common.paging.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 가져오기
	public List<BoardDto> getList(PageInfo pi, BoardDto bDto);
	
	// 게시글 수량 조회
	public int getListCount(BoardDto bDto);
	
	// 게시글 상세 조회(조회수 증가)
	public BoardDto getDetail(BoardDto bDto, String type);
	
	// 게시글 작성
	public int setEnroll(BoardDto bDto, MultipartFile upload, HttpSession session);
	
	// 게시글 삭제
//	public int delete(int boardNo, int memberNo, HttpSession session);
	public int delete(int boardNo, int memberNo, @SessionAttribute("memberNo") int loginMemberNo);
	
	// 게시글 수정 페이지 이동
	public BoardDto getEditForm(BoardDto bd);
	
	// 게시글 수정
	public int edit(BoardDto bDto, MultipartFile upload, int loginMemberNo);
}
