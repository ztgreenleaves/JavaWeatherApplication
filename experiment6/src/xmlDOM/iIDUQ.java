package xmlDOM;

import Bean.WeatherBean;
import Jframe.IShowWarning;

public interface iIDUQ {
	WeatherBean updateXML();//更新时间，bean包括更新后的当前时间
	WeatherBean deleteXML();//删除时间，bean包括删除时间（时间为空）
	WeatherBean insertXML();//插入当前时间
	WeatherBean queryXML(String city,IShowWarning iw);//查询信息，bean包括当前xml中内容
}
