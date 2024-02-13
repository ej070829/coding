//package com.mvc.model;
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//
//public class MyCorsFilter implements Filter {
//	//Logger logger = LogManager.getLogger(MyCorsFilter.class.getName());;
//	
//	private String allowOrigin;
//	
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // 필터 초기화 로직
//    	//this.allowOrigin = (String)filterConfig.getInitParameter("allow-origin");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
////        if(allowOrigin != null) {
////        	String[] allowOrigins  = allowOrigin.split(",");
////			
////			boolean isAllowOrigin = false;
////			for(String origin : allowOrigins) {
////				if(origin.equals(httpRequest.getHeader("Origin"))) {
////					isAllowOrigin = true;
////					break;
////				}
////			}
////			
////			if(isAllowOrigin) {
////				httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
////				httpResponse.setHeader("Access-Control-Allow-Credentials", "true"); //쿠키 요청을 허용
////				httpResponse.setHeader("Access-Control-Allow-Methods","POST, GET"); //허용할 HTTP 메서드
////				httpResponse.setHeader("Access-Control-Allow-Headers", "*"); //요청을 허용할 헤더
////
////				chain.doFilter(request, response);
////		        
////			}
////		}
//
//        // CORS 헤더 설정
//        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        httpResponse.setHeader("Access-Control-Max-Age", "3600"); 
//        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//
//        // 프리플라이트 요청에 대한 처리
//        if (httpRequest.getMethod().equals("OPTIONS")) {
//            httpResponse.setStatus(HttpServletResponse.SC_OK);
//            return;
//        }
//        // 실제 요청 처리
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // 필터 소멸 로직
//    }
//}