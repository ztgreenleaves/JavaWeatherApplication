package Test;

import Utils.HttpUtil;

public class TestHttp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://wthrcdn.etouch.cn/WeatherApi?citykey=101191001";
		try {
			String res = HttpUtil.getXML(url);
			System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
