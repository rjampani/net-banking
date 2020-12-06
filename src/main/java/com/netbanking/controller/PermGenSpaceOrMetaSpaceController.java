package com.netbanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javassist.ClassPool;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.FieldInfo;

@Controller
public class PermGenSpaceOrMetaSpaceController {
	@RequestMapping("/simulateParmgenSpaceError")
	public String simulatePerGenSpaceOrMetaSpaceError() throws Exception {
		for(int i = 0; i < 100_000_000; ++i) {
			generate("com.netbanking.controller.TestController" + i);
		}
		return "simulatePermGenSpaceOrMetaSpace";
	}

	public static Class generate(String name) throws Exception {
		ClassFile cf = new ClassFile(false, name, null);
		cf.setInterfaces(new String[] { "java.lang.Cloneable" });

		FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
		f.setAccessFlags(AccessFlag.PUBLIC);
		cf.addField(f);
		ClassPool pool = ClassPool.getDefault();
		return pool.makeClass(cf).toClass();
	}
}