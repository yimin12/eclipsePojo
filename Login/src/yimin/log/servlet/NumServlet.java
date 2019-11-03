package yimin.log.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class NumServlet extends HttpServlet {

//	Override teh init function, read tehe data and saved it in ServletContext
	@Override
	public void init() throws ServletException {
		String path = this.getServletContext().getRealPath("/nums/nums.txt");
//		声明流对象
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String nums = br.readLine();
			System.out.println(nums);
			this.getServletContext().setAttribute("nums", nums);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//	Override the destory function, and save the counter to the file
	@Override
	public void destroy() {
//		get the counter from the browser
		int nums = (int) this.getServletContext().getAttribute("nums");
//		get the absolute path
		String path = this.getServletContext().getRealPath("/nums/nums.txt");
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw);
			bw.write(nums + "");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
