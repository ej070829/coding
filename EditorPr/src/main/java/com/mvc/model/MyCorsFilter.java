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
//        // ���� �ʱ�ȭ ����
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
////				httpResponse.setHeader("Access-Control-Allow-Credentials", "true"); //��Ű ��û�� ���
////				httpResponse.setHeader("Access-Control-Allow-Methods","POST, GET"); //����� HTTP �޼���
////				httpResponse.setHeader("Access-Control-Allow-Headers", "*"); //��û�� ����� ���
////
////				chain.doFilter(request, response);
////		        
////			}
////		}
//
//        // CORS ��� ����
//        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        httpResponse.setHeader("Access-Control-Max-Age", "3600"); 
//        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//
//        // �����ö���Ʈ ��û�� ���� ó��
//        if (httpRequest.getMethod().equals("OPTIONS")) {
//            httpResponse.setStatus(HttpServletResponse.SC_OK);
//            return;
//        }
//        // ���� ��û ó��
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // ���� �Ҹ� ����
//    }
//}