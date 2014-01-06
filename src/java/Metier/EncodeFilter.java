package Metier;
import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 *
 * @author Fabien
 */
public class EncodeFilter implements Filter{
	@SuppressWarnings("unused")
	private FilterConfig filterConfig = null;
 
	@Override
	public void destroy() {
		this.filterConfig = null;	
	}
 
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Setting the character set for the request
		request.setCharacterEncoding("UTF-8");
 
		// pass the request on
		chain.doFilter(request, response);
 
		// Setting the character set for the response
		response.setContentType("text/html; charset=UTF-8");
	}
 
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;	
	}
}