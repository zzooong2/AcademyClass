package kr.co.green.common.interceptor;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AccessInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String referer = request.getHeader("referer");
		String requestURI = request.getRequestURI();
		
		String serverAddress = request.getRequestURL().toString();
		String localServerAddress = serverAddress.replace(requestURI, "");
		
//		System.out.println("-----------------AccessInterceptor---------------");
//		System.out.println("referer: " + referer);
//		System.out.println("requestURI: " + requestURI);
//		System.out.println("serverAddress: " + serverAddress);
//		System.out.println("localServerAddress: " + localServerAddress);
//		System.out.println("-------------------------------------------------");
		
		
		// 1. 요청받은 URL이 /news/detail.do일 때 (상세보기를 요청했을 때)
		// 2. 주소창에 직접 URL을 입력해서 요청했을 때
		// 3. 요청한 URL이 http://localhost/news/list.do가 아닐 때
		//    (다른 페이지에서 상세보기를 요청했을 때)
		
//		// 게시글 상세보기 이동
//		if (requestURI.equals("/news/detail.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/list.do"))) {
//			response.sendRedirect("/error/accessDenied?referer=" + referer);
//			return false;
//		// 게시글 등록 페이지 이동
//		} else if (requestURI.equals("/news/enrollForm.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/list.do"))) {
//			response.sendRedirect("/error/accessDenied?referer=" + referer);
//			return false;
//		// 게시글 수정 페이지 이동
//		}  else if (requestURI.equals("/news/editForm.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/detail.do"))) {
//			response.sendRedirect("/error/accessDenied?referer=" + referer);
//			return false;
//		// 게시글 삭제 
//		}  else if (requestURI.equals("/news/delete.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/detail.do"))) {
//			response.sendRedirect("/error/accessDenied?referer=" + referer);
//			return false;
//		// 회원가입 페이지 이동
//		}  else if (requestURI.equals("/member/registerForm.do") && (referer == null)) {
//			response.sendRedirect("/error/accessDenied?referer=" + referer);
//			return false;
//		// 회원가입	
//		}  else if (requestURI.equals("/news/register.do") && (referer == null || !referer.startsWith(localServerAddress+"/member/registerForm.do"))) {
//			response.sendRedirect("/error/accessDenied?referer=" + referer);
//			return false;
//		}
//		return true;
		
		HashMap<String, String[]> requestMap = new HashMap<>();
		requestMap.put("/news/detail.do", new String[]{"/news/list.do", "/news/editForm.do"});
		requestMap.put("/news/enroll.do", new String[]{"/news/enrollForm.do"});
		requestMap.put("/news/editForm.do", new String[]{"/news/detail.do"});
		requestMap.put("/news/edit.do", new String[]{"/news/editForm.do"});
		requestMap.put("/news/delete.do", new String[]{"/news/detail.do"});
		requestMap.put("/member/register.do", new String[]{"/member/registerForm.do"});
		
		// 1. 컨트롤러를 호출 유무(true, false)를 결정하는 변수 명시적 초기화
		boolean checkPathResult = true;
		
		// 2. requestMap 안에 있는 Key를 하나씩 꺼내는 forEach문
		for(String key : requestMap.keySet()) {
			// 3. pathCheck 메서드 호출 (반환값을 result에 저장)
			// result -> true: 정상적 접근
			// result -> false: 비정상적 접근
			boolean result = pathCheck(requestURI, referer, localServerAddress, key, requestMap.get(key));
			
			// 9. pathCheck 메서드 실행 후 반환받은 값이 false일 때(비정상적 접근일 때) 
			if(!result) {
				response.sendRedirect("/error/accessDeniend?referer="+referer);
				checkPathResult = false;
				break;
			}
		}
		// 10. forEach문 종료 후 checkPathResult 리턴
		return checkPathResult;
	}
	
	// 4. 호출된 메서드 실행
	private boolean pathCheck(String requestURI, 
			 				  String referer, 
			 				  String localServiceAddress, 
			 				  String requestMain, 
			 				  String[] requestSub) throws IOException{
		// 5. 검증된 결과값을 저장하는 변수
		// true: 정상, false: 비정상
		boolean invalidReferer = true;
		
		// 6. 접근 검증 코드 (사용자가 요청한 URL <-> Key값이 일치하는지 확인)
		if(requestURI.equals(requestMain)) {
			
			// 7. 사용자가 요청했을 당시의 URL이 null인지 확인 (null -> 주소창에 직접 입력했을 때)
			if(referer == null) {
				// 7-1. null: 비정상 접근 (변수에 false 저장)
				invalidReferer = false;
			} else {
				// 7-2. !null: 정상 접근 (HashMap에 저장되어있는 데이터를 forEach문으로 하나씩 꺼내서 변수에 저장)
				// ex) requestSub: {"/news/list.do", "/news/editForm.do"} 
				//     첫번째 반복문: value = /news/list.do
				//     두번째 반복문: value = /news/editForm.do
				for(String value : requestSub) {
					// 7-3. 요청했을 당시 URL이 value의 주소가 아닐 때 변수에 true 저장 (잘못된 접근일 때)
					
					// Example....
					// 처리중인 페이지: /news/detail.do
					// 요청했을 당시의 URL(referer): /news/list.do
					if(!referer.startsWith(localServiceAddress + value)) {
						// 첫번째 반복에 의해서 value = /news/list.do
						// referer(/news/list.do)가 value(/news/editForm.do)가 아닐 때
						// --> 조건식 결과 true, 비정상적 접근
						invalidReferer = false;
						break;
					} else {
						// 두번째 반복에 의해서 value = /news/list.do
						// referer(/news/list.do)가 value(/news/list.do)가 아닐 때
						// --> 조건식 결과 false, 정상적 접근
						invalidReferer = true;
						break;
					}
				}
			}
		}
		// 8. 검증 완료 후 정상적인 접근으로 판단 후 true 리턴
		return invalidReferer;
	}
	
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}


}
