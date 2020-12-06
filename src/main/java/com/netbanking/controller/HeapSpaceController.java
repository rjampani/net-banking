package com.netbanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeapSpaceController {
	@RequestMapping("/simulateHeapSpaceError")
	public String simulateHeapSpaceError() {
		int ArraySize=2*256000*1024;
        int[] j = new int[ArraySize];
		return "simulateHeapSpaceError";
	}
}
