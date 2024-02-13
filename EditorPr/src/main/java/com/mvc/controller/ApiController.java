package com.mvc.controller;

import java.io.IOException;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@RestController
public class ApiController {
	
	@GetMapping("/api")
	@ResponseBody
	public String proxyView() throws Exception{
		String url = "http://localhost:8000/";

		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(url, String.class);
		//String to json
		ObjectMapper objMap = new ObjectMapper();
		TypeReference<Map<String, String>> typeRef = new TypeReference<Map<String, String>>(){};
		Map<String,String> map = objMap.readValue(json, typeRef);
		
	    return map.get("title");
	}
	
//	@GetMapping("/postman")
//	@ResponseBody
//	public String getMan() {
//		return "getman";
//	}
	
	@PostMapping("/postman")
	@ResponseBody()
	public String postMan(@RequestBody Object json) throws JsonParseException, JsonMappingException, IOException {	
		RestTemplate restTemplate = new RestTemplate();
		
		// 도커 서버 url
		String url = "http://localhost:8000/compile";
		
		//header  :   headers.set("헤더이름", "값");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));//contentType
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));//accept
		
		//body
		LinkedHashMap<String,String> body = (LinkedHashMap)json;

		// HttpEntity = header + body
		HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(body, headers);
		// HTTP 요청 : 결과 String
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		String response = responseEntity.getBody();
		
		// 응답 값 웹페이지에 전달
		return response;
	}
	
	
//	@Autowired 
//	CompileBuilder builder;
//	
//	@PostMapping(value="compile")
//	@RequestMapping(value = "compile", method = {RequestMethod.POST, RequestMethod.OPTIONS}, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Map<String, Object> compileCode(@RequestBody Map<String, Object> input) throws Exception {
//		
//		Map<String, Object> returnMap = new HashMap<String, Object>();
//		
//		// compile input code
//		Object obj = builder.compileCode(input.get("code").toString());
//		
//		System.out.println(input.get("code").toString());
//		
//		// compile 결과 타입이 String일 경우 컴파일 실패 후 메시지 반환으로 판단하여 처리
//		if(obj instanceof String) {
//			returnMap.put("result", ApiResponseResult.FAIL.getText());
//			returnMap.put("SystemOut", obj.toString());
//			return returnMap;
//		}
//		
//		// 실행 후 결과 전달 받음
//		long beforeTime = System.currentTimeMillis();
//		
//		// 파라미터
//		String participant[] = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String completion[] = new String[] {"josipa", "filipa", "marina", "nikola"};
//		Object[] params = {participant, completion};
//		
//		// 코드 실행
//		Map<String, Object> output = builder.runObject(obj, params);
//		long afterTime = System.currentTimeMillis();
//		
//		// 코드 실행 결과 저장
//		returnMap.putAll(output);
//		// 소요시간
//		returnMap.put("performance", (afterTime - beforeTime));
//		
//		// s :: 결과 체크 :: //
//		// TODO 상황에 따른 결과 동적 체크 처리 필요
//		try {
//			if(returnMap.get("return") != null && !returnMap.get("return").equals("vinko")) {
//				returnMap.put("result", ApiResponseResult.FAIL.getText());
//				returnMap.put("SystemOut", returnMap.get("SystemOut").toString() + "\r\n결과 기대값과 일치하지 않습니다.");
//			}
//		}catch (Exception e) {
//			returnMap.put("result", ApiResponseResult.FAIL.getText());
//			returnMap.put("SystemOut", returnMap.get("SystemOut").toString() + "예상치 못한 오류로 검사에 실패했습니다.");
//		}
//		// e :: 결과 체크 :: //
//		
//		return returnMap;
//	}

}
