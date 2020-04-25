package com.youbenben.youbenben;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class YoubenbenQuery extends BaseQuery {
	
	public YoubenbenQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("youbenben");
  }

  public YoubenbenQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}























