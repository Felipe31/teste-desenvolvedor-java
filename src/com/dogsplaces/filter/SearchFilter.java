package com.dogsplaces.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dogsplaces.model.Dog;

@WebFilter("/search.xhtml")
public class SearchFilter implements Filter {
	 
	 public void destroy() {
	           // TODO Auto-generated method stub
	 
	 }
	 
	 public void doFilter(ServletRequest request, ServletResponse response,
	                    FilterChain chain) throws IOException, ServletException {
	   List<Dog> search= null;
	   HttpSession sess = ((HttpServletRequest) request).getSession(false);

	   if (sess != null){
	         search = (List<Dog>) sess.getAttribute("search");
	   }      
	 
	     if (search == null) {
	              String contextPath = ((HttpServletRequest) request)
	                                 .getContextPath();
	              ((HttpServletResponse) response).sendRedirect(contextPath
	                                 + "/index.xhtml");
	     } else {
	              chain.doFilter(request, response);
	     }
	 
	 }
	 
	 public void init(FilterConfig arg0) throws ServletException {
	           // TODO Auto-generated method stub
	 
	 }
	 
}