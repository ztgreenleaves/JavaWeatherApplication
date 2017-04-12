package Bean;

public class WeatherBean {
	private String city;
	private String wendu;
	private String fengli;
	private String shidu;
	private String fengxiang;
	private String sunrise;
	private String sunset;
	private String pm25;
	private String suggest;
	private String quality;
	private String currentTime;
	private String alarmText;
	private String imgUrl;

	@Override
	public String toString() {
		return "WeatherBean [city=" + city + ", wendu=" + wendu + ", fengli=" + fengli + ", shidu=" + shidu
				+ ", fengxiang=" + fengxiang + ", sunrise=" + sunrise + ", sunset=" + sunset + "\n, pm25=" + pm25
				+ ", suggest=" + suggest + ", quality=" + quality + ", currentTime=" + currentTime + ", alarmText="
				+ alarmText + ", imgUrl=" + imgUrl + "]";
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public String getShidu() {
		return shidu;
	}

	public void setShidu(String shidu) {
		this.shidu = shidu;
	}

	public String getFengxiang() {
		return fengxiang;
	}

	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getAlarmText() {
		return alarmText;
	}

	public void setAlarmText(String alarmText) {
		this.alarmText = alarmText;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
