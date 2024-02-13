package com.mvc.model;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MethodExecutation {
	private final static long TIMEOUT_LONG = 15000; // 15��
	
	public static Map<String, Object> timeOutCall(final Object obj, String methodName, final Object[] params, Class<? extends Object> arguments[]) throws Exception {
		// return Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		// Source�� ���鶧 ������ Method
		final Method objMethod;
		// �Ű����� Ÿ�� �Ӽ� ������ 1���� ���
		if(arguments.length == 1)
			objMethod = obj.getClass().getMethod(methodName, arguments[0]);
		// �Ű����� Ÿ�� �Ӽ� ������ 2���� ���
		else if(arguments.length == 2)
			objMethod = obj.getClass().getMethod(methodName, arguments[0], arguments[1]);
		// �� ��
		else
			objMethod = obj.getClass().getMethod(methodName);
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<Map<String, Object>> task = new Callable<Map<String, Object>>() {
				@Override
				public Map<String, Object> call() throws Exception {
					Map<String, Object> callMap = new HashMap<String, Object>();
					
					// �Ʒ� �ּ� ������ timeout �׽�Ʈ ����
					// Thread.sleep(4000);
					
					// Method ����
					// �Ķ���� ������ 1���� ��� 1�� ���
					if(params.length == 1)
						callMap.put("return", objMethod.invoke(obj, new Object[] {params}));
					// �Ķ���� ������ 2�� �̻��� ��� 2������ ���
					else if(params.length == 2)
						callMap.put("return", objMethod.invoke(obj, params[0], params[1]));
					// �� ��
					else
						callMap.put("return", objMethod.invoke(obj));
					
					callMap.put("result", true);
					return callMap;
				}
			};
			
		Future<Map<String, Object>> future = executorService.submit(task);
		try {
			// Ÿ�Ӿƿ� ������ �۾� ����
			returnMap = future.get(TIMEOUT_LONG, TimeUnit.MILLISECONDS); // timeout�� ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			// e.printStackTrace();
			returnMap.put("result", false);
		} finally {
			executorService.shutdown();
		}
		
		return returnMap;
	}
}
