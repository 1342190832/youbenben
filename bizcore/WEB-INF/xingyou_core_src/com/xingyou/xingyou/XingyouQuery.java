package com.xingyou.xingyou;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class XingyouQuery extends BaseQuery {
	
	public XingyouQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("xingyou");
  }

  public XingyouQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}























