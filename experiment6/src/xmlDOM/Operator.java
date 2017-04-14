package xmlDOM;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Bean.WeatherBean;
import Jframe.IShowWarning;
import Utils.HttpUtil;

public class Operator implements iIDUQ {
	// lianyungang 101191001
	// xuzhou 101190801
	// nanjing 101190101
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	private String url = "http://wthrcdn.etouch.cn/WeatherApi?city=";
	private Document doc = null;
	private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	private DocumentBuilder db = null;
	private Element root = null;
	private String city;
	private String fileName;
	private String path ="xmlsave/";
	private WeatherBean weather = new WeatherBean();
	private int flag;
	private WeatherBean initBeanByInputStream(String city, IShowWarning iw) {
		setCity(city);
		flag = 0;
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(HttpUtil.getXMLStream(url + city));
			root = doc.getDocumentElement();
			weather.setCity(root.getElementsByTagName("city").item(0).getTextContent());
			flag = 1;
			weather.setWendu(root.getElementsByTagName("wendu").item(0).getTextContent());
			weather.setFengli(root.getElementsByTagName("fengli").item(0).getTextContent());
			weather.setShidu(root.getElementsByTagName("shidu").item(0).getTextContent());
			weather.setFengxiang(root.getElementsByTagName("fengxiang").item(0).getTextContent());
			weather.setSunrise(root.getElementsByTagName("sunrise_1").item(0).getTextContent());
			weather.setSunset(root.getElementsByTagName("sunset_1").item(0).getTextContent());
			weather.setPm25(root.getElementsByTagName("pm25").item(0).getTextContent());
			weather.setSuggest(root.getElementsByTagName("suggest").item(0).getTextContent());
			weather.setQuality(root.getElementsByTagName("quality").item(0).getTextContent());
			Date date = new Date();
			fileName = city + "_" + formatter.format(date);
			tfInXmlFile(fileName);
			return weather;
		} catch (Exception e) {
			//e.printStackTrace();
			if(flag == 1){
				weather.setPm25(null);
				weather.setQuality(null);
				weather.setSuggest(null);
			}else{
				System.out.println(flag);
				String warnings = "查无此城市";
				iw.ShowWarnings(warnings);
			}
		}
		return weather;
	}

	private WeatherBean initBeanByFilePath(String fileName) {
		setCity(city);
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(path+fileName);
			root = doc.getDocumentElement();
			weather.setCity(root.getElementsByTagName("city").item(0).getTextContent());
			weather.setWendu(root.getElementsByTagName("wendu").item(0).getTextContent());
			weather.setFengli(root.getElementsByTagName("fengli").item(0).getTextContent());
			weather.setShidu(root.getElementsByTagName("shidu").item(0).getTextContent());
			weather.setFengxiang(root.getElementsByTagName("fengxiang").item(0).getTextContent());
			weather.setSunrise(root.getElementsByTagName("sunrise_1").item(0).getTextContent());
			weather.setSunset(root.getElementsByTagName("sunset_1").item(0).getTextContent());
			weather.setPm25(root.getElementsByTagName("pm25").item(0).getTextContent());
			weather.setSuggest(root.getElementsByTagName("suggest").item(0).getTextContent());
			weather.setQuality(root.getElementsByTagName("quality").item(0).getTextContent());
			return weather;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public WeatherBean updateXML() {
		initBeanByFilePath(fileName + ".xml");
		Element currentTime = (Element) root.getElementsByTagName("currentTime").item(0);
		Date date = new Date();
		String curTime = formatter.format(date);
		currentTime.setTextContent(curTime);
		weather.setCurrentTime(curTime);
		fileName = city + "_" + formatter.format(date);
		tfInXmlFile(fileName);
		return weather;
	}

	@Override
	public WeatherBean deleteXML() {
		initBeanByFilePath(fileName + ".xml");
		Element currentTime = (Element) root.getElementsByTagName("currentTime").item(0);
		root.removeChild(currentTime);
		weather.setCurrentTime(null);
		Date date = new Date();
		fileName = city + "_" + formatter.format(date);
		tfInXmlFile(fileName);
		return weather;
	}

	@Override
	public WeatherBean insertXML() {
		initBeanByFilePath(fileName + ".xml");
		Element currentTime = doc.createElement("currentTime");
		Date date = new Date();
		String curTime = formatter.format(date);
		currentTime.setTextContent(curTime);
		root.appendChild(currentTime);
		weather.setCurrentTime(root.getElementsByTagName("currentTime").item(0).getTextContent());
		fileName = city + "_" + formatter.format(date);
		tfInXmlFile(fileName);
		return weather;
	}

	@Override
	public WeatherBean queryXML(String city,IShowWarning iw) {
		return initBeanByInputStream(city,iw);
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void tfInXmlFile(String fileName) {
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(doc), new StreamResult(new File(path+fileName + ".xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
