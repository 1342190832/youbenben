package com.xingyou.xingyou;

public interface FootprintProducer {

	boolean canReplaceFootPrint(Footprint fp, Footprint item);
	boolean clearTop();
	String getBeanName();
}


