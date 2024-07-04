package kr.co.green.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
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
		// 게시글 상세보기 이동
		if (requestURI.equals("/news/detail.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/list.do"))) {
			response.sendRedirect("/error/accessDenied?referer=" + referer);
			return false;
		// 게시글 등록 페이지 이동
		} else if (requestURI.equals("/news/enrollForm.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/list.do"))) {
			response.sendRedirect("/error/accessDenied?referer=" + referer);
			return false;
		// 게시글 수정 페이지 이동
		}  else if (requestURI.equals("/news/editForm.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/detail.do"))) {
			response.sendRedirect("/error/accessDenied?referer=" + referer);
			return false;
		// 게시글 삭제 
		}  else if (requestURI.equals("/news/delete.do") && (referer == null || !referer.startsWith(localServerAddress+"/news/detail.do"))) {
			response.sendRedirect("/error/accessDenied?referer=" + referer);
			return false;
		// 회원가입 페이지 이동
		}  else if (requestURI.equals("/member/registerForm.do") && (referer == null)) {
			response.sendRedirect("/error/accessDenied?referer=" + referer);
			return false;
		// 회원가입	
		}  else if (requestURI.equals("/news/register.do") && (referer == null || !referer.startsWith(localServerAddress+"/member/registerForm.do"))) {
			response.sendRedirect("/error/accessDenied?referer=" + referer);
			return false;
		}
		return true;
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
