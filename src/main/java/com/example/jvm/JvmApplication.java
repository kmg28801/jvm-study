package com.example.jvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JvmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JvmApplication.class, args);
		// OOMTest();
		StackSOFTest();
	}

	public static void OOMTest() {
		List<OOMObject> oomObjects = new ArrayList<>();
		while (true) {
			oomObjects.add(new OOMObject());
		}
	}

	public static void StackSOFTest() {
		JavaVMStackSOF_1 oom = new JavaVMStackSOF_1();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			System.out.println("스택 길이 : " + oom.stackLength);
			throw e;
		}
	}

	static class OOMObject {

	}

	static class JavaVMStackSOF_1 {
		private int stackLength = 1;

		public void stackLeak() {
			stackLength++;
			stackLeak();
		}
	}
}
