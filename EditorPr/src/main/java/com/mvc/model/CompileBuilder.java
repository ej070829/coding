package com.mvc.model;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.stereotype.Component;


//@Slf4j
@Component
public class CompileBuilder {
	// ������Ʈ home directory ���
	// private final String path = CompilerApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	private final String path = "C:/Users/jihoo/";
	// private final String path = "/compile/";


	@SuppressWarnings({ "resource", "deprecation" })
	public Object compileCode(String body) throws Exception {
		String uuid = UUIDUtil.createUUID();
		String uuidPath = path + uuid + "/";
		
		// Source�� �̿��� java file ����
		File newFolder = new File(uuidPath);
		File sourceFile = new File(uuidPath + "DynamicClass.java");
		File classFile = new File(uuidPath + "DynamicClass.class");
		
		Class<?> cls = null;
		
		// compile System err console ��ȸ�� ����
		ByteArrayOutputStream err = new ByteArrayOutputStream();
		PrintStream origErr = System.err;
		
		try {
			newFolder.mkdir();
			new FileWriter(sourceFile).append(body).close();
			
			// ������� Java ������ ������
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			
			// System�� error outputStream�� ByteArrayOutputStream���� �޾ƿ����� ����
			System.setErr(new PrintStream(err));
			
			// compile ����
			int compileResult = compiler.run(null, null, null, sourceFile.getPath());
			// compile ������ ��� ���� �α� ��ȯ
			if(compileResult == 1) {
				return err.toString();
			}
			
			// �����ϵ� Class�� Load
			URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {new File(uuidPath).toURI().toURL()});
			cls = Class.forName("DynamicClass", true, classLoader);
			
			// Load�� Class�� Instance�� ����
			return cls.newInstance();
		} catch (Exception e) {
			//Logger.error("[CompileBuilder] �ҽ� ������ �� ���� �߻� :: {}", e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			// Syetem error stream �����·� ��ȯ
			System.setErr(origErr);
			
			if(sourceFile.exists())
				sourceFile.delete();
			if(classFile.exists())
				classFile.delete();
			if(newFolder.exists())
				newFolder.delete();
		}
	}
	
	/*
	 * run method : parameter byte array, return byte array
	 * main �޼ҵ� ���� �� �ش� �޼ҵ� ���
	@SuppressWarnings("rawtypes")
	public byte[] runObject(Object obj, byte[] params) throws Exception {
		String methodName = "main";
		Class arguments[] = new Class[] {params.getClass()};
		
		// Source�� ���鶧 ������ Method�� ����
		Method objMethod = obj.getClass().getMethod(methodName, arguments);
		Object result = objMethod.invoke(obj, params);
		return (byte[])result;
	}
	*/
	
	/**
	 * 
	 * @param obj
	 * @param params
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> runObject(Object obj, Object[] params) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		// ������ �޼ҵ� ��
		String methodName = "runMethod";
		// �Ķ���� Ÿ�� ������ŭ ����
		Class arguments[] = new Class[params.length];
		for(int i = 0; i < params.length; i++)
			arguments[i] = params[i].getClass();
		
		/*
		 * reflection method�� console output stream�� �޾ƿ��� ���� ����
		 * reflection method ���� �� System�� out, error outputStream�� ByteArrayOutputStream���� �޾ƿ����� ����
		 * ���� �Ϸ� �� �ٽ� ���� System���� ��ȯ
		 */
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayOutputStream err = new ByteArrayOutputStream();
		PrintStream origOut = System.out;
		PrintStream origErr = System.err;
		try {
			// System�� out, error outputStream�� ByteArrayOutputStream���� �޾ƿ����� ����
			System.setOut(new PrintStream(out));
			System.setErr(new PrintStream(err));
			
			// �޼ҵ� timeout�� üũ�ϸ� ����(15�� �ʰ� �� ��������)
			Map<String, Object> result = new HashMap<String, Object>();
			result = MethodExecutation.timeOutCall(obj, methodName, params, arguments);
			
			// stream ���� ����
			if((Boolean) result.get("result")) {
				returnMap.put("result", ApiResponseResult.SUCEESS.getText());
				returnMap.put("return", result.get("return"));
				if(err.toString() != null && !err.toString().equals("")) {
					returnMap.put("SystemOut", err.toString());
				}else {
					returnMap.put("SystemOut", out.toString());
				}
			}else {
				returnMap.put("result", ApiResponseResult.FAIL.getText());
				if(err.toString() != null && !err.toString().equals("")) {
					returnMap.put("SystemOut", err.toString());
				}else {
					returnMap.put("SystemOut", "���� �ð� �ʰ�");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Syetem out, error stream �����·� ��ȯ
			System.setOut(origOut);
			System.setErr(origErr);
		}
		
		return returnMap;
	}
}
