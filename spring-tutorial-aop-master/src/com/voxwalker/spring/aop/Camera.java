package com.voxwalker.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
public class Camera {
	
	public void snap() {
		System.out.println("SNAP!");
	}

}
